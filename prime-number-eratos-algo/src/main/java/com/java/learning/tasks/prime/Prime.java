package com.java.learning.tasks.prime;

public class Prime{

	public void printAllPrimeNumberUpToRange(int range){
		boolean prime[] = new boolean[range + 1];

		/**
		 * created an array to map all prime numbers as true
		 */
		for(int i=0; i <=range; i++){
			prime[i] = true;
		}

		/**
		 * Started with 2 as its a smallest prime number
		 */
		for(int p = 2; p*p <=range; p++)
		{
			// if number occur first time as true, means its a prime number, then remove the multiple of this number from list
			if(prime[p] == true)
			{
				for(int i = p*2; i <= range; i += p)
					prime[i] = false;
			}
		}

		/**
		 * printing all primes
		 */
		for(int i = 2; i <= range; i++)
		{
			if(prime[i] == true)
				System.out.print(i + " ");
		}
	}
}