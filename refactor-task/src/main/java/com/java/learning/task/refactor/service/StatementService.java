package com.java.learning.task.refactor.service;

import com.java.learning.task.refactor.pojo.Customer;
import com.java.learning.task.refactor.pojo.Rental;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This file will act like a service to fetch statement of book rental for a customer.
 *
 * @author pappuy
 */

public class StatementService {

	/**
	 * @return
	 */
	public String fetchStatement(Customer customer) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
		List<Rental> rentals = customer.getRentals();
		if(null == rentals || rentals.isEmpty()){
			return result.toString();
		}
		Iterator<Rental> rentalsItr = rentals.listIterator();
		while (rentalsItr.hasNext()) {
			double thisAmount = 0;
			Rental rental = rentalsItr.next();
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