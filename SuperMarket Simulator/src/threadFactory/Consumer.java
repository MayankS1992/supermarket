package threadFactory;

import model.Cashier;

public class Consumer {
	
	public static Thread createThread(Cashier cons, Thread consumer) {
		try {
			consumer = new Thread((Runnable) cons);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return consumer;
	}

}
