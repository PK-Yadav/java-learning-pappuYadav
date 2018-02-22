package com.java.learning.task.multithreading.tasks.wordcount.wikicall;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This file will use concept of ForkAndJoin concurrency concept to read an URL and write its data into jason format in file,
 * named as search keyword.txt
 *
 * @author pappuy
 */

public class WikiReadWriteCall extends RecursiveAction {

	private static final Logger logger = Logger.getLogger(WikiReadWriteCall.class.getName());
	private static final int THRESHOLD = 10;
	private List<String> keywords;
	private String       url;

	public WikiReadWriteCall(List<String> keywords, String url) {
		this.keywords = keywords;
		this.url = url;
	}

	protected void compute() {
		if (THRESHOLD >= keywords.size()) {
			computeDirectly();
		} else {
			ForkJoinTask.invokeAll(breakTaskIntoSubTask());
		}

	}

	/**
	 * will break a bulky list into small list as given threshold and create new subtask.
	 *
	 * @return
	 */
	private List<WikiReadWriteCall> breakTaskIntoSubTask() {
		logger.log(Level.INFO,"Breaking task into sub task");
		List<WikiReadWriteCall> subTask = new ArrayList<>();
		subTask.add(new WikiReadWriteCall(getKeywords().subList(0, THRESHOLD), getUrl()));
		subTask.add(new WikiReadWriteCall(getKeywords().subList(THRESHOLD, getKeywords().size()), getUrl()));
		return subTask;
	}

	/**
	 * This will process a subtask, means will read url and write it into file from list keyword one by one
	 */
	private void computeDirectly() {
		logger.log(Level.INFO, "Thread stared computing list " + Thread.currentThread().getName());
		for (String keyword : keywords) {
			try {
				String callingUrl = getUrl() + "" + URLEncoder.encode(keyword,"UTF-8") + "";
				System.out.println(Thread.currentThread().getName() + " computing " + callingUrl);
				JSONObject data = readUrlData(callingUrl);
				writeUrlJsonDataIntoFile(data, keyword);
			} catch (Exception ex) {
				logger.log(Level.SEVERE, "Exception reading and writing url data"+ex.getMessage());
				logger.log(Level.SEVERE, ex.toString());
			}
		}
		logger.log(Level.INFO, "Thread Completed computing list " + Thread.currentThread().getName());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	/**
	 * method to read an url data and also check weather url response is success or not
	 *
	 * @param callingUrl
	 * @return JSONObject
	 * @throws IOException
	 */
	private JSONObject readUrlData(String callingUrl) throws IOException {
		logger.log(Level.INFO," start reading data of wiki call response");
		JSONObject json = null;
		URL urlConn = getUrlConnection(callingUrl);
		if (null == urlConn) {
			return json;
		}
		StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.openStream()));
		String decodedString;
		while ((decodedString = bufferedReader.readLine()) != null) {
			sb.append(decodedString);
		}
		json = new JSONObject(sb.toString());
		bufferedReader.close();
		return json;
	}

	/**
	 * This will return URl connection if status code is 200 and on successful url connection
	 * @param callingUrl
	 * @return
	 * @throws IOException
	 */
	private URL getUrlConnection(String callingUrl) throws IOException {

		URL urlConn = new URL(callingUrl);
		HttpURLConnection conn = (HttpURLConnection) urlConn.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if (responsecode != 200) {
			logger.log(Level.WARNING, "HttpResponseCode: " + responsecode + " for calling url " + callingUrl);
			throw new RuntimeException("HttpResponseCode: " + responsecode + " for calling url " + callingUrl);
		}
		return urlConn;
	}

	/**
	 * method to write jsondata into file.
	 *
	 * @param urlJsonData
	 * @param keyword
	 * @throws IOException
	 */
	private void writeUrlJsonDataIntoFile(JSONObject urlJsonData, String keyword) throws IOException {
		String outputFile = "/Users/pappuy/wikiurldata/outfiles/" + keyword + ".txt";
		logger.log(Level.INFO,"Writing jsondata at locatio :  "+ outputFile);
		if(urlJsonData != null) {
			Files.write(Paths.get(outputFile), urlJsonData.toString().getBytes());
		}
	}
}
