/**
 *
 */
package com.java.learning.task.refactor.books;

import com.java.learning.task.refactor.abstractcls.Book;

import java.util.Date;

/**
 * Movie : Simple data class representing movie data.
 *
 * @author pappuy
 */
public class ChildrensBook extends Book {

	public ChildrensBook(final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}

	public ChildrensBook(final String title, final int bookCategory) {
		super(title, bookCategory);
	}

	@Override public double getAmountForBook(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 2;
		return thisAmount;
	}

	@Override public int getRentalPoint(int daysRented) {
		return 1;
	}

}


