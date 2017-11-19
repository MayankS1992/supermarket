package model;

import java.util.Random;

public class Customer {

	int numberOfProducts;
	int waitTime;
	long entryTime;
	long exitTime;
	long waitTimeCustomer;
	static int total;

	/**
	 * @return the numberOfProducts
	 */
	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	/**
	 * @param numberOfProducts
	 *            the numberOfProducts to set
	 */
	public void setNumberOfProducts(int maximumnNumOfProducts) {

		Random random = new Random();
		int productsInCart = random.nextInt(maximumnNumOfProducts) + 1;
		numberOfProducts = productsInCart;
		total = total + numberOfProducts;
	}

	/**
	 * @return the waitTime
	 * 
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * @param waitTime
	 *            the waitTime to set
	 */
	public void setWaitTime(int products) {
		Random random = new Random();
		int rand = random.nextInt(6) + 1;
		waitTime = (products * rand);
		System.out.println(waitTime+"Products"+products);
	}

	/**
	 * @return the entryTime
	 */
	public long getEntryTime() {
		return entryTime;
	}

	/**
	 * @param start the entryTime to set
	 */
	public void setEntryTime(long start) {
		this.entryTime = start;
	}

	/**
	 * @return the exitTime
	 */
	public long getExitTime() {
		return exitTime;
	}

	/**
	 * @param end the exitTime to set
	 */
	public void setExitTime(long end) {
		this.exitTime = end;
		long waitTimeCustomer = ((exitTime - entryTime) / 1000);
	}

	/**
	 * @return the waitTimeCustomer
	 */
	public long getWaitTimeCustomer() {
		return waitTimeCustomer;
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return total;
	}


}
