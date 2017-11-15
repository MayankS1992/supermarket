package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer7 implements Threads {

	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer7(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer7() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread7()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}


}
