package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer3 implements Threads {

	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer3(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer3() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread3()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}


}
