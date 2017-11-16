package model;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.Calculator;
import utility.UserInputs;

/**
 * @author Mayank
 *
 */
public class Cashier implements Runnable {
	@SuppressWarnings("rawtypes")
	private BlockingQueue queue;
	Calculator c = new Calculator();
	private long start = System.nanoTime();
	UserInputs user = new UserInputs();
	private long sim = 1;
	public int value;
	public int time;
	public int index;
	Random random = new Random();
	int rand, times = 0;
	Calculator c1 = new Calculator(start);
	HashMap<Integer, String> customer = new HashMap<Integer, String>();

	@SuppressWarnings("rawtypes")
	public Cashier(BlockingQueue q, int index) {
		this.queue = q;
		this.index = index;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public void run() {
		while ((System.nanoTime() - start) <= (sim * 60000000000L))
			try {
				int i = 0;
				rand = random.nextInt(5) + 1;
				value = (int) ((BlockingQueue) queue).take();
				time = value * rand;
				c.setCustomerHistory(i, time);
				customer.put(i, String.valueOf(time));
				System.out.println(c.getCustomerHistory());
				i++;
				c.setTotalCustomers();
				c.setTotalProducts(value);
				double seconds = time / 1000.0;
				c.setUtilization(index);
				Thread.sleep(time * 10 + 20);
			} catch (InterruptedException ex) {
				Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
			}
	}

	public Object[] queueReturn() {

		Object[] arr = queue.toArray();
		return arr;
	}

}
