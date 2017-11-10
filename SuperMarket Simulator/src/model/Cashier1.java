package model;

import java.util.concurrent.BlockingQueue;

import utility.UserInputs;

public class Cashier1 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer1 = new Thread();
	UserInputs userInputs = new UserInputs();
	Cashier[] consumer = new Cashier[userInputs.getSetNumOfCashiers()];

	@SuppressWarnings("rawtypes")
	public Cashier1(BlockingQueue q, int index) {
		super(q, index);
		this.queue = q;
		this.index = index;
	}

}
