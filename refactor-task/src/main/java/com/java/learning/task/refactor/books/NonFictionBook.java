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
public class NonFictionBook extends Book {

	public NonFictionBook(final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}

	public NonFictionBook(final String title, final int bookCategory) {
		super(title, bookCategory);
	}

	@Override public double getAmountForBook(int daysRented) {
		double thisAmount = 0;
		thisAmount += (daysRented) * 3;
		return thisAmount;
	}

	@Override public int getRentalPoint(int daysRented) {
		return 1;
	}
}
