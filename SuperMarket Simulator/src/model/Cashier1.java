package model;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.Calculator;
import utility.NewCustomerObserver;
import utility.UserInputs;

/**
 * @author Mayank
 * 
 *         The class extends the Cashier class and if invoked it uses the run
 *         method from Cashier to create a thread
 *
 */
public class Cashier1 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer1 = new Thread();
	UserInputs user = new UserInputs();

	@SuppressWarnings("rawtypes")
	public Cashier1(BlockingQueue q) {
		super(q);
		this.queue = q;
	}

	public void run() {

		Customer customer = new Customer();
		while ((System.nanoTime() - start) <= (sim * 60000000000L))

			try {
				int time = customer.getWaitTime();
				long end = System.currentTimeMillis();
				customer.setExitTime(end);
				value = (Customer) ((BlockingQueue) queue).take();
				if (value != null) {
					Thread.sleep(time + 1000);
					Calculator.setUtilization1();
				}

				/* Information being stored inside the calculator class */
				c.setTotalCustomers();
				new NewCustomerObserver(customerHistory);
				customerHistory.setCustomerHistory(customer.getNumberOfProducts(), time+1000);
				Cashier.setTotalProductsProcessed1(customer.getNumberOfProducts());
				c.setUtilization(index);

			} catch (InterruptedException | IOException ex) {
				Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
			}
	}
}
