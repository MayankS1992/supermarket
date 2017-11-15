package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer2 implements Threads {
	
	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer2(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer2() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread2()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}


}
