package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Mayank Getters and setters for the calculations
 */
public class Calculator {

	Random random = new Random();

	/* Total Waiting Time */
	float waitingTime = 0;

	float totalTime = 0;

	/* Total Customers Lost */
	static int lost = 0;

	/* Total Customers processed */
	static int total = 0;

	/* Total Products processed */
	static int products = 0;

	static int a[] = new int[8];

	UserInputs userInputs = new UserInputs();

	/* Number of Checkouts */
	int checkout = userInputs.getSetNumOfCashiers();

	static int sum;
	float startTime = 0;
	static int averageProductsPerTrolly = 0;
	static int customerLost = 0;
	static double totalWaitTime = 0.0;

	public Calculator(long start) {
		startTime = start;
	}

	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	public float getStartTime() {
		return startTime;
	}

	public float waitTime() {
		try {
			int waitTime = random.nextInt(60);
			int wait = waitTime;
			Thread.sleep(wait + 100);
			waitingTime = waitingTime + wait;
			setAverageProductsPerTrolly();
			waitingTime = waitingTime / total;
			totalWaitTime = totalWaitTime + waitTime; // To be Corrected //
		} catch (InterruptedException ex) {

		}
		return waitingTime;
	}

	public double totTime()	{
		return totalWaitTime;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Integer> getUtilization() {
		int i = 0;
		List<Integer> arrayList = new ArrayList<Integer>();
		for (i = 0; i < checkout; i++) {
			arrayList.add(a[i]);
		}
		return arrayList;
	}

	public int average() {
		for (int i = 0; i < checkout; i++) {
			sum = sum + a[i];
		}
		sum = sum / checkout;
		setAverage(sum);
		return sum;
	}

	private void setAverage(int sum2) {
		Calculator.sum = sum2;
	}

	public int getAverage() {
		return sum;
	}

	public synchronized void setTotalCustomers() {
		total++;
	}

	public int getTotalCustomers() {
		return total;
	}

	public synchronized void setTotalProducts(int a) {
		products += a;
	}

	public int getTotalProducts() {
		return products;
	}

	double myRandom(double min, double max) {
		Random r = new Random();
		return (r.nextInt((int) ((max - min) * 10 + 1)) + min * 10) / 10.0;
	}

	public void setUtilization(int index) {
		a[index] += 1;
	}

	public static int getProducts() {
		return products;
	}

	public static void setProducts(int products) {
		Calculator.products = products;
	}

	public static int[] getA() {
		return a;
	}

	public static void setA(int[] a) {
		Calculator.a = a;
	}

	public int getAverageProductsPerTrolly() {
		return averageProductsPerTrolly;
	}

	public void setAverageProductsPerTrolly() {
		averageProductsPerTrolly = products / total;
	}

	@SuppressWarnings("rawtypes")
	private static List<Integer> arrayListOfLostCustomers = new ArrayList<Integer>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Integer> setCustomerLost(int maxNumOfProducts) {

		arrayListOfLostCustomers.add(maxNumOfProducts);
		return arrayListOfLostCustomers;
	}

	public int getCustomerLost() {
		return arrayListOfLostCustomers.size();
	}

}
