package model;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.Calculator;
import utility.UserInputs;

public class Cashier6 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer6 = new Thread();
	UserInputs userInputs = new UserInputs();
	Cashier[] consumer = new Cashier[userInputs.getSetNumOfCashiers()];
	long a, b = 0;
	int factor = 1;

	@SuppressWarnings("rawtypes")
	public Cashier6(BlockingQueue q) {
		super(q);
		this.queue = q;
	}

	public void run() {
		
		if(userInputs.getScanner())
		{
			factor = 2;
			System.out.print("bbyebye");
		}
		Customer customer = new Customer();
		while ((System.nanoTime() - start) <= (sim * 60000000000L))

			try {
				int time = customer.getWaitTime() + 50;
				long end = System.nanoTime();
				customer.setExitTime(end);
				value = (Customer) ((BlockingQueue) queue).take();
				if(value != null)
				{
					Thread.sleep(time+1000);
					c.setUtilization6();
				}
				
				value = (Customer) ((BlockingQueue) queue).take();
				a = (long) value.exitTime;
				b = (long) value.entryTime;
				c.setTotalTime(TimeUnit.NANOSECONDS.toSeconds(end-b));
				c.setWaitTimeForCashier6(end - b);

				if (value.numberOfProducts > 0) {
					Thread.sleep((value.waitTime/factor)+150);
					c.setUtilization6();
				}

				/* Information being stored inside the calculator class */
				c.setTotalCustomers();
				// new NewCustomerObserver(customerHistory);
				customerHistory.setCustomerHistory(c.getTotalCustomers(), time);
				Cashier.setTotalProductsProcessed6(customer.getNumberOfProducts());
				c.setUtilization(index);

			} catch (InterruptedException | IOException ex) {
				Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
			}
	}

}
