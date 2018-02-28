package com.java.learning.tasks.topic;

import com.java.learning.tasks.observer.Observer;
import com.java.learning.tasks.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Article implements Subject {
	private List<Observer> observers;
	private boolean        changed;
	private String         description;
	private String         heading;
	private final Object MUTEX = new Object();

	public Article() {
		observers = new ArrayList<>();
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

	@Override public Article getUpdate(Observer obj) {
		return this;
	}

	public void createNewArticle(String heading, String description, Observer observer){
		if(null != observer && !observers.contains(observer)){
			observers.add(observer);
		}
		this.heading = heading;
		this.description = description;
		notifyObservers();
	}
	@Override
	public String toString(){
		return "[ Article Heading :- "+ heading +" \n Description :- "+ description +" ]";
	}
}