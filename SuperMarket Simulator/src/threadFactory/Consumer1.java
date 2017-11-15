package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer1 implements Threads {

	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer1(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer1() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread1()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}

	
}
