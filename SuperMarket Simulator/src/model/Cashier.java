package model;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.Calculator;
import utility.CustomerSubject;
import utility.NewCustomerObserver;
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
	private long start = System.nanoTime();
	UserInputs user = new UserInputs();
	private long sim = 1;
	public int value;
	public int time;
	public int index;
	Random random = new Random();
	int rand, times = 0;
	Calculator c1 = new Calculator(start);

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
				
				rand = random.nextInt(5) + 1;
				value = (int) ((BlockingQueue) queue).take();
				time = value * rand;
				/*Information being stored inside the calculator class*/
				c.setTotalCustomers();
				new NewCustomerObserver(customerHistory);
				customerHistory.setCustomerHistory(c.getTotalCustomers(), time);
				c.setTotalProducts(value);
				c.setUtilization(index);
				/*System.out.println(time+"is time for sleep");
				System.out.println(value+"num of products");
				System.out.println(rand+"random value generator");
				System.out.println(customerHistory.getCustomerHistory());*/
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
