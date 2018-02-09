package com.java.learning.task.multithreading.tasks.wikicall;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * This file will use concept of ForkAndJoin concurrency concept to read an URL and write its data into jason format in file,
 * named as search keyword.txt
 *
 * @author pappuy
 */

public class WikiReadWriteCall extends RecursiveAction {
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
		List<WikiReadWriteCall> subTask = new ArrayList<>();
		List<String> left = getKeywords().subList(0, THRESHOLD);
		List<String> right = getKeywords().subList(THRESHOLD, getKeywords().size());
		subTask.add(new WikiReadWriteCall(left, getUrl()));
		subTask.add(new WikiReadWriteCall(right, getUrl()));
		return subTask;
	}

	/**
	 * This will process a subtask, means will read url and write it into file from list keyword one by one
	 */
	private void computeDirectly() {
		try {
			System.out.println("Thread stared computing list " + Thread.currentThread().getName());
			for (String keyword : keywords) {
				if (keyword.contains(" ")) {
					keyword = keyword.replaceAll(" ", "%20");
				}
				String callingUrl = getUrl() + "" + keyword + "";
				System.out.println(Thread.currentThread().getName() + " computing " + callingUrl);
				JSONObject data = readUrlData(callingUrl);
				writeUrlJsonDataIntoFile(data, keyword);
			}
			System.out.println("Thread Completed computing list " + Thread.currentThread().getName());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
		JSONObject json = null;
		StringBuilder sb = new StringBuilder();
		URL url = new URL(callingUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if (responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " + responsecode + " for calling url " + callingUrl);
		else {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String decodedString;
			while ((decodedString = bufferedReader.readLine()) != null) {
				sb.append(decodedString);
			}
			json = new JSONObject(sb.toString());
			bufferedReader.close();
		}
		return json;
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
		String key = null;
		Iterator<String> iterator = urlJsonData.keys();
		while (iterator.hasNext()) {
			key = iterator.next();
			if("batchcomplete".equals(key)){
				continue;
			}
			if (!"extract".equals(key) ) {
				urlJsonData = urlJsonData.getJSONObject(key);
			} else {
				Files.write(Paths.get(outputFile), urlJsonData.get(key).toString().getBytes());
				break;
			}
		}
	}
}