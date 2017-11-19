package model;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import utility.Calculator;
import utility.CustomerSubject;
import utility.UserInputs;

/**
 * @author Mayank
 *
 */
public class Cashier implements Runnable {
	@SuppressWarnings("rawtypes")
	private BlockingQueue queue;
	Calculator c = new Calculator();
	CustomerSubject customerHistory = new CustomerSubject();
	protected long start = System.nanoTime();
	UserInputs user = new UserInputs();
	protected long sim = 1;
	public Customer value;
	public int time;
	public int index;
	Random random = new Random();
	int rand, times = 0;
	Calculator c1 = new Calculator(start);
	static int totalProductsProcessed1 = 0;
	static int totalProductsProcessed2 = 0;
	static int totalProductsProcessed3 = 0;
	static int totalProductsProcessed4 = 0;
	static int totalProductsProcessed5 = 0;
	static int totalProductsProcessed6 = 0;
	static int totalProductsProcessed7 = 0;
	static int totalProductsProcessed8 = 0;
	static int totalProcessed = 0;

	public static int totalProducts() {
		totalProcessed = totalProductsProcessed1 + totalProductsProcessed2 + totalProductsProcessed3
				+ totalProductsProcessed4 + totalProductsProcessed5 + totalProductsProcessed6 + totalProductsProcessed7
				+ totalProductsProcessed8;
		return totalProcessed;
	}

	@SuppressWarnings("rawtypes")
	public Cashier(BlockingQueue q) {
		this.queue = q;
	}

	public Cashier() {
		// TODO Auto-generated constructor stub
	}

	public Object[] queueReturn() {
		Object[] arr = (Object[]) queue.toArray();
		return (Object[]) arr;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the totalProductsProcessed1
	 */
	public synchronized static int getTotalProductsProcessed1() {
		return totalProductsProcessed1;
	}

	/**
	 * @param totalProductsProcessed1
	 *            the totalProductsProcessed1 to set
	 */
	public synchronized static void setTotalProductsProcessed1(int totalProductsProcessed) {
		totalProductsProcessed1 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed2
	 */
	public synchronized static int getTotalProductsProcessed2() {
		return totalProductsProcessed2;
	}

	/**
	 * @param totalProductsProcessed2
	 *            the totalProductsProcessed2 to set
	 */
	public synchronized static void setTotalProductsProcessed2(int totalProductsProcessed) {
		Cashier.totalProductsProcessed2 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed3
	 */
	public synchronized static int getTotalProductsProcessed3() {
		return totalProductsProcessed3;
	}

	/**
	 * @param totalProductsProcessed3
	 *            the totalProductsProcessed3 to set
	 */
	public synchronized static void setTotalProductsProcessed3(int totalProductsProcessed) {
		Cashier.totalProductsProcessed3 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed4
	 */
	public synchronized static int getTotalProductsProcessed4() {
		return totalProductsProcessed4;
	}

	/**
	 * @param totalProductsProcessed4
	 *            the totalProductsProcessed4 to set
	 */
	public synchronized static void setTotalProductsProcessed4(int totalProductsProcessed) {
		Cashier.totalProductsProcessed4 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed5
	 */
	public synchronized static int getTotalProductsProcessed5() {
		return totalProductsProcessed5;
	}

	/**
	 * @param totalProductsProcessed5
	 *            the totalProductsProcessed5 to set
	 */
	public synchronized static void setTotalProductsProcessed5(int totalProductsProcessed) {
		Cashier.totalProductsProcessed5 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed6
	 */
	public synchronized static int getTotalProductsProcessed6() {
		return totalProductsProcessed6;
	}

	/**
	 * @param totalProductsProcessed6
	 *            the totalProductsProcessed6 to set
	 */
	public synchronized static void setTotalProductsProcessed6(int totalProductsProcessed) {
		Cashier.totalProductsProcessed6 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed7
	 */
	public synchronized static int getTotalProductsProcessed7() {
		return totalProductsProcessed7;
	}

	/**
	 * @param totalProductsProcessed7
	 *            the totalProductsProcessed7 to set
	 */
	public synchronized static void setTotalProductsProcessed7(int totalProductsProcessed) {
		Cashier.totalProductsProcessed7 = totalProductsProcessed;
	}

	/**
	 * @return the totalProductsProcessed8
	 */
	public synchronized static int getTotalProductsProcessed8() {
		return totalProductsProcessed8;
	}

	/**
	 * @param totalProductsProcessed8
	 *            the totalProductsProcessed8 to set
	 */
	public synchronized static void setTotalProductsProcessed8(int totalProductsProcessed) {
		Cashier.totalProductsProcessed8 = totalProductsProcessed;
	}

}
