package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer6 implements Threads {

	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer6(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer6() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread6()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}


}
