package com.java.learning.tasks;

import com.java.learning.tasks.observer.Observer;
import com.java.learning.tasks.subscriber.ArticleSubscriber;
import com.java.learning.tasks.subscriber.BlogSubscriber;
import com.java.learning.tasks.topic.Article;
import com.java.learning.tasks.topic.Blog;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        //create subject
        Blog topic = new Blog();
        Article aTopic = new Article();

        //create observers
        Observer obj1 = new BlogSubscriber("Obj1");
        Observer obj2 = new BlogSubscriber("Obj2");
        Observer obj3 = new BlogSubscriber("Obj3");
        Observer obj4 = new ArticleSubscriber("Obj1");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
        aTopic.register(obj4);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);
        obj4.setSubject(aTopic);

        //check if any update is available
        //obj1.update();

        //now send message to subject
        topic.addArticle("Java 8", " Please try to use streams ", obj4);

    }
}
