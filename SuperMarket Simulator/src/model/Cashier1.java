package model;

import java.util.concurrent.BlockingQueue;


/**
 * @author Mayank
 * 
 * The class extends the Cashier class and 
 * if invoked it uses the run method from 
 * Cashier to create a thread
 *
 */
public class Cashier1 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer1 = new Thread();

	@SuppressWarnings("rawtypes")
	public Cashier1(BlockingQueue q, int index) {
		super(q, index);
		this.queue = q;
		this.index = index;
	}
	

}
