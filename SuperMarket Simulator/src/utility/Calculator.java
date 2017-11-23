package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mayank , Chandan
 * 
 * Getters and setters for the calculations
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

	/* Utilization for each customer */
	static int utilization1, utilization2, utilization3, utilization4, utilization5, utilization6, utilization7,
			utilization8 = 0;

	static long waitTimeForCashier8, waitTimeForCashier7, waitTimeForCashier6, waitTimeForCashier5, waitTimeForCashier4,
			waitTimeForCashier3, waitTimeForCashier2, waitTimeForCashier1 = 0;

	UserInputs userInputs = new UserInputs();

	/* Number of Checkouts */
	int checkout = userInputs.getSetNumOfCashiers();

	static int sum;
	float startTime = 0;
	static int customerLost = 0;
	static long totalWaitTime = 0;

	/* Average Products */
	static int averageProducts = 0;

	public Calculator(long start) {
		startTime = start;
	}

	public Calculator() {
		// TODO Auto-generated constructor stub
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
	public synchronized int getUtilization1() {
		return utilization1;
	}

	/**
	 * @param utilization1
	 *            the utilization1 to set
	 */
	public synchronized void setUtilization1() {
		utilization1++;
	}

	/**
	 * @return the utilization2
	 */
	public synchronized int getUtilization2() {
		return utilization2;
	}

	/**
	 * @param utilization2
	 *            the utilization2 to set
	 */
	public synchronized void setUtilization2() {
		utilization2++;
	}

	/**
	 * @return the utilization3
	 */
	public synchronized int getUtilization3() {
		return utilization3;
	}

	/**
	 * @param utilization3
	 *            the utilization3 to set
	 */
	public synchronized void setUtilization3() {
		utilization3++;
	}

	/**
	 * @return the utilization4
	 */
	public synchronized int getUtilization4() {
		return utilization4;
	}

	/**
	 * @param utilization4
	 *            the utilization4 to set
	 */
	public synchronized void setUtilization4() {
		utilization4++;
	}

	/**
	 * @return the utilization5
	 */
	public synchronized int getUtilization5() {
		return utilization5;
	}

	/**
	 * @param utilization5
	 *            the utilization5 to set
	 */
	public synchronized void setUtilization5() {
		utilization5++;
	}

	/**
	 * @return the utilization6
	 */
	public synchronized int getUtilization6() {
		return utilization6;
	}

	/**
	 * @param utilization6
	 *            the utilization6 to set
	 */
	public synchronized void setUtilization6() {
		utilization6++;
	}

	/**
	 * @return the utilization7
	 */
	public synchronized int getUtilization7() {
		return utilization7;
	}

	/**
	 * @param utilization7
	 *            the utilization7 to set
	 */
	public synchronized void setUtilization7() {
		utilization7++;
	}

	/**
	 * @return the utilization8
	 */
	public synchronized int getUtilization8() {
		return utilization8;
	}

	/**
	 * @param utilization8
	 *            the utilization8 to set
	 */
	public synchronized void setUtilization8() {
		utilization8++;
	}

	/**
	 * @return the waitTimeForCashier8
	 */
	public long getWaitTimeForCashier8() {
		return waitTimeForCashier8;
	}

	/**
	 * @param waitTimeForCashier8 the waitTimeForCashier8 to set
	 */
	public void setWaitTimeForCashier8(long waitTimeForCashier8) {
		Calculator.waitTimeForCashier8 = waitTimeForCashier8;
	}

	/**
	 * @return the waitTimeForCashier7
	 */
	public long getWaitTimeForCashier7() {
		return waitTimeForCashier7;
	}

	/**
	 * @param waitTimeForCashier7 the waitTimeForCashier7 to set
	 */
	public void setWaitTimeForCashier7(long waitTimeForCashier7) {
		Calculator.waitTimeForCashier7 = waitTimeForCashier7;
	}

	/**
	 * @return the waitTimeForCashier6
	 */
	public long getWaitTimeForCashier6() {
		return Calculator.waitTimeForCashier6;
	}

	/**
	 * @param waitTimeForCashier6 the waitTimeForCashier6 to set
	 */
	public void setWaitTimeForCashier6(long waitTimeForCashier6) {
		Calculator.waitTimeForCashier6 = waitTimeForCashier6;
	}

	/**
	 * @return the waitTimeForCashier5
	 */
	public long getWaitTimeForCashier5() {
		return Calculator.waitTimeForCashier5;
	}

	/**
	 * @param waitTimeForCashier5 the waitTimeForCashier5 to set
	 */
	public void setWaitTimeForCashier5(long waitTimeForCashier5) {
		Calculator.waitTimeForCashier5 = waitTimeForCashier5;
	}

	/**
	 * @return the waitTimeForCashier4
	 */
	public long getWaitTimeForCashier4() {
		return Calculator.waitTimeForCashier4;
	}

	/**
	 * @param waitTimeForCashier4 the waitTimeForCashier4 to set
	 */
	public void setWaitTimeForCashier4(long waitTimeForCashier4) {
		Calculator.waitTimeForCashier4 = waitTimeForCashier4;
	}

	/**
	 * @return the waitTimeForCashier3
	 */
	public long getWaitTimeForCashier3() {
		return waitTimeForCashier3;
	}

	/**
	 * @param waitTimeForCashier3 the waitTimeForCashier3 to set
	 */
	public void setWaitTimeForCashier3(long waitTimeForCashier3) {
		Calculator.waitTimeForCashier3 = waitTimeForCashier3;
	}

	/**
	 * @return the waitTimeForCashier2
	 */
	public long getWaitTimeForCashier2() {
		return waitTimeForCashier2;
	}

	/**
	 * @param waitTimeForCashier2 the waitTimeForCashier2 to set
	 */
	public void setWaitTimeForCashier2(long waitTimeForCashier2) {
		Calculator.waitTimeForCashier2 = waitTimeForCashier2;
	}

	/**
	 * @return the waitTimeForCashier1
	 */
	public long getWaitTimeForCashier1() {
		return waitTimeForCashier1;
	}

	/**
	 * @param waitTimeForCashier1 the waitTimeForCashier1 to set
	 */
	public void setWaitTimeForCashier1(long waitTimeForCashier1) {
		Calculator.waitTimeForCashier1 = waitTimeForCashier1;
	}

	public long setTotalTime(long seconds) {
		totalWaitTime = totalWaitTime + seconds;
		return  totalWaitTime;
	}
	
	public long getTotalTime() {
		return  totalWaitTime;
	}

}
