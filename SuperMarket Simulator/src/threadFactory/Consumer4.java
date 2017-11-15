package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer4 implements Threads  {
	
	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer4(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer4() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread4()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}

}
