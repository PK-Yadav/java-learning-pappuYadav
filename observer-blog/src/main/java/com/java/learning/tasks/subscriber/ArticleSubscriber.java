package com.java.learning.tasks.subscriber;

import com.java.learning.tasks.observer.Observer;
import com.java.learning.tasks.subject.Subject;
import com.java.learning.tasks.topic.Article;

public class ArticleSubscriber implements Observer{
	private String  name;
	private Subject topic;

	public ArticleSubscriber(String nm) {
		this.name = nm;
	}

	@Override public void update() {
		Article article = (Article) topic.getUpdate(this);
		if (article == null) {
			System.out.println(name + ":: No new ariticle");
		} else
			System.out.println(name+":: Consuming message::"+article.toString());
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}
}