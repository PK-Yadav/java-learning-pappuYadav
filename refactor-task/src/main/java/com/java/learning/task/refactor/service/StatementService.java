package com.java.learning.task.refactor.service;

import com.java.learning.task.refactor.pojo.Customer;
import com.java.learning.task.refactor.pojo.Rental;

import java.util.Iterator;

/**
 * This file will act like a service to fetch statement of book rental for a customer.
 *
 * @author pappuy
 */

public class StatementService {

	/**
	 * @return
	 */
	public String fetchStatement() {
		Customer customer = new Customer("Suresh");
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalsItr = customer.getRentals().listIterator();
		StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

		while (rentalsItr.hasNext()) {
			double thisAmount = 0;
			Rental rental = (Rental) rentalsItr.next();
			thisAmount = rental.fetchPrice();
			frequentRenterPoints += rental.getRentalPoint();
			result.append("\t").append(rental.getBook().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
			totalAmount += thisAmount;
		}

		result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
		result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
		return result.toString();
	}
}