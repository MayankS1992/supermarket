package model;

import java.util.concurrent.BlockingQueue;

import utility.UserInputs;

public class Cashier3 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer3 = new Thread();
	UserInputs userInputs = new UserInputs();
	Cashier[] consumer = new Cashier[userInputs.getSetNumOfCashiers()];

	@SuppressWarnings("rawtypes")
	public Cashier3(BlockingQueue q, int index) {
		super(q, index);
		this.queue = q;
		this.index = index;
	}

}
