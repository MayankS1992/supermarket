package model;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.Calculator;
import utility.UserInputs;

/**
 * @author Mayank The Feeder class has the run methods for the producer Threads.
 *
 */
public class Feeder implements Runnable {
	@SuppressWarnings("rawtypes")
	private final BlockingQueue[] queue;
	Calculator calculations = new Calculator();
	UserInputs userInputs = new UserInputs();
	int MaxNumOfProducts = userInputs.getMaximumProducts();;
	@SuppressWarnings("rawtypes")
	BlockingQueue qu;
	Random random = new Random();
	static int productsInCart, index = 0;
	private long start = System.nanoTime();
	private long sim = 1;

	@SuppressWarnings("rawtypes")
	public Feeder(BlockingQueue[] queue) {
		this.queue = queue;
	}

	@SuppressWarnings("unchecked")
	public void run() {

		while ((System.nanoTime() - start) <= (sim * 60000000000L))

			try {

				// productsInCart = random.nextInt(MaxNumOfProducts) + 1;
				qu = minimum(queue); // Smallest Queue generated
				Customer customer = new Customer();
				customer.setNumberOfProducts(MaxNumOfProducts);
				customer.setWaitTime(customer.getNumberOfProducts());

				//
				// Express Queue
				//
				if (customer.getNumberOfProducts() < 10) {
					if (queue[0].size() >= 6) {

						calculations.setCustomerLost(MaxNumOfProducts);
						// Frequency of express customers//
						int waitTime = random.nextInt(250);
						Thread.sleep(waitTime + 100);
					} else {

						// Customer is put inside the queue
						long start = System.currentTimeMillis();
						customer.setEntryTime(start);
						queue[0].put(customer);
						// calculations.waitTime();
						int waitTime = random.nextInt(5);
						Thread.sleep(waitTime + 100);
					}
					// Products in Cart more than 10
				} else if (customer.getNumberOfProducts() > 10) {
					if (qu.size() >= 6) {

						calculations.setCustomerLost(MaxNumOfProducts);
						int waitTime = random.nextInt(250);
						Thread.sleep(waitTime + 100);
					} else {
						long start = System.currentTimeMillis();
						minimum(queue).put(customer);
						// calculations.waitTime();
						int waitTime = random.nextInt(260);
						Thread.sleep(waitTime + 100);
					}
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(Feeder.class.getName()).log(Level.SEVERE, null, ex);
			}

	}

	/**
	 * 
	 * Find the shortest queue for the Customer
	 * 
	 * @param queue2
	 *            : denotes the customer queues
	 * @return queue[index] : The queue and its position
	 */
	@SuppressWarnings("rawtypes")

	private BlockingQueue minimum(BlockingQueue[] queue2) {
		int min = queue[1].size();
		for (int count = 1; count < queue.length; count++) {
			if (queue[count].size() <= min) {
				min = queue[count].size();
				index = count;
			}
		}
		return queue[index];
	}
}