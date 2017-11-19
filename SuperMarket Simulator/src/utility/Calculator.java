package utility;

import java.util.ArrayList;
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

	static int utilization1, utilization2, utilization3, utilization4, utilization5, utilization6, utilization7,
			utilization8 = 0;

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

	// public float waitTime() {
	// int waitTime = random.nextInt(60);
	//// int wait = waitTime;
	//// Thread.sleep(wait + 100);
	// waitingTime = waitingTime + waitTime;
	// setAverageProductsPerTrolly();
	// waitingTime = waitingTime / total;
	// totalWaitTime = totalWaitTime + waitTime; // To be Corrected //
	//
	// return waitingTime;
	// }

	public double totTime() {
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

	public static int[] getA() {
		return a;
	}

	public static void setA(int[] a) {
		Calculator.a = a;
	}

	// public int getAverageProductsPerTrolly() {
	// return averageProductsPerTrolly;
	// }
	//
	// public void setAverageProductsPerTrolly() {
	// averageProductsPerTrolly = products / total;
	// }

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

	/**
	 * @return the utilization1
	 */
	public synchronized static int getUtilization1() {
		return utilization1;
	}

	/**
	 * @param utilization1
	 *            the utilization1 to set
	 */
	public synchronized static void setUtilization1() {
		utilization1++;
	}

	/**
	 * @return the utilization2
	 */
	public synchronized static int getUtilization2() {
		return utilization2;
	}

	/**
	 * @param utilization2
	 *            the utilization2 to set
	 */
	public synchronized static void setUtilization2() {
		utilization2++;
	}

	/**
	 * @return the utilization3
	 */
	public synchronized static int getUtilization3() {
		return utilization3;
	}

	/**
	 * @param utilization3
	 *            the utilization3 to set
	 */
	public synchronized static void setUtilization3() {
		utilization3++;
	}

	/**
	 * @return the utilization4
	 */
	public synchronized static int getUtilization4() {
		return utilization4;
	}

	/**
	 * @param utilization4
	 *            the utilization4 to set
	 */
	public synchronized static void setUtilization4() {
		utilization4++;
	}

	/**
	 * @return the utilization5
	 */
	public synchronized static int getUtilization5() {
		return utilization5;
	}

	/**
	 * @param utilization5
	 *            the utilization5 to set
	 */
	public synchronized static void setUtilization5() {
		utilization5++;
	}

	/**
	 * @return the utilization6
	 */
	public synchronized static int getUtilization6() {
		return utilization6;
	}

	/**
	 * @param utilization6
	 *            the utilization6 to set
	 */
	public synchronized static void setUtilization6() {
		utilization6++;
	}

	/**
	 * @return the utilization7
	 */
	public synchronized static int getUtilization7() {
		return utilization7;
	}

	/**
	 * @param utilization7
	 *            the utilization7 to set
	 */
	public synchronized static void setUtilization7() {
		utilization7++;
	}

	/**
	 * @return the utilization8
	 */
	public synchronized static int getUtilization8() {
		return utilization8;
	}

	/**
	 * @param utilization8
	 *            the utilization8 to set
	 */
	public synchronized static void setUtilization8() {
		utilization8++;
	}

}
