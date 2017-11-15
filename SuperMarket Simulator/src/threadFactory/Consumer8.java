package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer8 implements Threads {

	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer8(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer8() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread8()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}


}
