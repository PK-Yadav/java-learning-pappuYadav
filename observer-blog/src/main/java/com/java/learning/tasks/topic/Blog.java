package com.java.learning.tasks.topic;

import com.java.learning.tasks.observer.Observer;
import com.java.learning.tasks.subject.Subject;
import com.java.learning.tasks.subscriber.ArticleSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Blog implements Subject {

	private List<Observer> observers;
	private boolean        changed;
	private List<Article>  articles;
	private final Object MUTEX = new Object();

	public Blog() {
		observers = new ArrayList<>();
		articles = new ArrayList<>();
	}

	@Override public void register(Observer obj) {
		if (obj == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
	}

	@Override public void unregister(Observer obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	@Override public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}
	}

	@Override
	public Article getUpdate(Observer obj) {
		return this.articles.get(articles.size()-1);
	}

	public void addArticle(String heading, String description, Observer observer){
		Article article = new Article();
		article.createNewArticle(heading, description, observer);
		//ArticleSubscriber topic = new ArticleSubscriber();

		this.changed=true;
		this.articles.add(article);
		notifyObservers();
	}
}