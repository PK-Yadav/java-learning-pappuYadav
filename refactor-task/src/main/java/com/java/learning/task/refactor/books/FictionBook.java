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
public class FictionBook extends Book {

	public FictionBook(final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}

	public FictionBook(final String title, final int bookCategory) {
		super(title, bookCategory);
	}

	@Override public double getAmountForBook(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2)
			thisAmount += (daysRented - 2) * 1.5;
		return thisAmount;
	}

	@Override public int getRentalPoint(int daysRented) {
		if (daysRented > 1)
			return 2;
		return 1;
	}

}
