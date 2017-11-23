package model;

import java.util.Date;
import java.util.Random;

/**
 * @author Mayank
 *
 */
public class Customer {

	/* number of products */
	int numberOfProducts;

	/* wait time */
	int waitTime;

	/* entry time */
	long entryTime;

	/* exit time */
	long exitTime;

	/* Total Products per trolley */
	static int total;
	
	/* Total wait per trolley */
	static int averageWaitTime;

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
		int rand = random.nextInt(15) + 1;
		waitTime = (products * rand);
	}

	/**
	 * @return the entryTime
	 */
	public long getEntryTime() {
		return entryTime;
	}

	/**
	 * @param date
	 *            the entryTime to set
	 */
	public void setEntryTime(long date) {
		this.entryTime = date;
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return total;
	}

	/**
	 * @return the exitTime
	 */
	public long getExitTime() {
		return exitTime;
	}

	/**
	 * @param exitTime
	 *            the exitTime to set
	 */
	public void setExitTime(long exitTime) {
		this.exitTime = exitTime;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public static void setTotal(int total) {
		Customer.total = total;
	}

	/**
	 * @return the totalWaitTime
	 */
	public static int getTotalWaitTime() {
		return averageWaitTime;
	}

	/**
	 * @param totalWaitTime the totalWaitTime to set
	 */
	public static void setTotalWaitTime(int totalWaitTime) {
		
		Customer.averageWaitTime = totalWaitTime;
	}

}
