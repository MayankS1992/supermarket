package threadFactory;

import model.Cashier;
import utility.ThreadBean;

public class Consumer5 implements Threads {

	private Cashier cons;
	Thread consumer = new Thread();

	public Consumer5(Cashier cons) {
		this.cons = cons;
		createThread();
	}
	
	public Consumer5() {
		ThreadBean threadBean = new ThreadBean();
		((Thread) threadBean.getConsumerThread5()).start();
	}

	@Override
	public Thread createThread() {
		return Consumer.createThread(cons, consumer);
	}
}
