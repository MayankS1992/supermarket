package model;

import java.util.concurrent.BlockingQueue;

import utility.UserInputs;

public class Cashier5 extends Cashier implements Runnable {
	@SuppressWarnings({ "rawtypes", "unused" })
	private BlockingQueue queue;
	Thread consumer5=new Thread();
	UserInputs userInputs = new UserInputs();
	Cashier[] consumer=new Cashier[userInputs.getSetNumOfCashiers()];
	@SuppressWarnings("rawtypes")
	public Cashier5(BlockingQueue q, int index) 
	{super(q, index);
	this.queue=q;
    this.index=index;}

}
