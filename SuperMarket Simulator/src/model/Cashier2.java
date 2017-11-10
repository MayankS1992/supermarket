package model;

import java.util.concurrent.BlockingQueue;

import utility.UserInputs;

public class Cashier2 extends Cashier implements Runnable{
	@SuppressWarnings({ "unused", "rawtypes" })
	private BlockingQueue queue;
	Thread consumer2=new Thread();
	UserInputs userInputs = new UserInputs();
	Cashier[] consumer=new Cashier[userInputs.getSetNumOfCashiers()];
	@SuppressWarnings("rawtypes")
	public Cashier2(BlockingQueue q, int index) 
	{super(q, index);
	this.queue=q;
    this.index=index;}

}
