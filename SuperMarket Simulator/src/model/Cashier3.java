package model;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.UserInputs;

public class Cashier3 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer3 = new Thread();
	UserInputs userInputs = new UserInputs();
	Cashier[] consumer = new Cashier[userInputs.getSetNumOfCashiers()];
	long a, b = 0;

	@SuppressWarnings("rawtypes")
	public Cashier3(BlockingQueue q) {
		super(q);
		this.queue = q;
	}

	@SuppressWarnings("rawtypes")
	public void run() {

		Customer customer = new Customer();
		while ((System.nanoTime() - start) <= (sim * 60000000000L))
			try {
				int time = customer.getWaitTime()+50;
				long end = System.nanoTime();
				customer.setExitTime(end);

				value = (Customer) ((BlockingQueue) queue).take();
				a = (long) value.exitTime;
				b = (long) value.entryTime;
				c.setTotalTime(TimeUnit.NANOSECONDS.toSeconds(end-b));
				c.setWaitTimeForCashier3(end - b);

				if (value.numberOfProducts > 0) {
					Thread.sleep(value.waitTime + 150);
					c.setUtilization3();
				}

				/* Information being stored inside the calculator class */
				c.setTotalCustomers();
				// new NewCustomerObserver(customerHistory);
				customerHistory.setCustomerHistory(c.getTotalCustomers(), time);
				Cashier.setTotalProductsProcessed3(customer.getNumberOfProducts());
				c.setUtilization(index);

			} catch (InterruptedException | IOException ex) {
				Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
			}
	}

}
