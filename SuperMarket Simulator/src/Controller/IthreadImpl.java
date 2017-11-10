package Controller;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cashier;
import model.Cashier1;
import model.Cashier2;
import model.Cashier3;
import model.Cashier4;
import model.Cashier5;
import model.Cashier6;
import model.Cashier7;
import model.Cashier8;
import model.Feeder;
import utility.UserInputs;
import view.ConsumerGraph;

public class IthreadImpl implements Ithread {
	@SuppressWarnings("rawtypes")
	ArrayList list = new ArrayList();
	Thread consumer1 = new Thread();
	Thread consumer2 = new Thread();
	Thread consumer3 = new Thread();
	Thread consumer4 = new Thread();
	Thread consumer5 = new Thread();
	Thread consumer6 = new Thread();
	Thread consumer7 = new Thread();
	Thread consumer8 = new Thread();
	Thread prodd = new Thread();
	int counter = 0;

	@SuppressWarnings({ "rawtypes", "unused" })
	public IthreadImpl(int maxProducts, int number_of_Checkout) {

		UserInputs userInputs = new UserInputs();
		userInputs.setSetNumOfCashiers(number_of_Checkout);

		int NumOfCashiers = userInputs.getSetNumOfCashiers();
		Cashier[] consumer = new Cashier[NumOfCashiers];
		BlockingQueue[] queue = new BlockingQueue[NumOfCashiers];
		ArrayList<BlockingQueue> linkedQueues = new ArrayList<BlockingQueue>();

		for (int i = 0; i < NumOfCashiers; i++) {
			queue[i] = new LinkedBlockingQueue();
			linkedQueues.add(queue[i]);
		}

		Feeder producer = new Feeder(queue);
		prodd = new Thread(producer);
		try {
			for (int i = 1; i <= NumOfCashiers; i++) {
				switch (i) {
				case 1:
					Cashier1 cons1 = new Cashier1((BlockingQueue) linkedQueues.get(counter), counter);
					consumer1 = new Thread(cons1);
					counter++;
					consumer[0] = cons1;
				case 2:
					Cashier2 cons2 = new Cashier2((BlockingQueue) linkedQueues.get(counter), counter);
					consumer2 = new Thread(cons2);
					counter++;
					consumer[1] = cons2;
				case 3:
					Cashier3 cons3 = new Cashier3((BlockingQueue) linkedQueues.get(counter), counter);
					consumer3 = new Thread(cons3);
					counter++;
					consumer[2] = cons3;
				case 4:
					Cashier4 cons4 = new Cashier4((BlockingQueue) linkedQueues.get(counter), counter);
					consumer4 = new Thread(cons4);
					counter++;
					consumer[3] = cons4;
				case 5:
					Cashier5 cons5 = new Cashier5((BlockingQueue) linkedQueues.get(counter), counter);
					consumer5 = new Thread(cons5);
					counter++;
					consumer[4] = cons5;
				case 6:
					Cashier6 cons6 = new Cashier6((BlockingQueue) linkedQueues.get(counter), counter);
					consumer6 = new Thread(cons6);
					counter++;
					consumer[5] = cons6;
				case 7:
					Cashier7 cons7 = new Cashier7((BlockingQueue) linkedQueues.get(counter), counter);
					consumer7 = new Thread(cons7);
					counter++;
					consumer[6] = cons7;
				case 8:
					Cashier8 cons8 = new Cashier8((BlockingQueue) linkedQueues.get(counter), counter);
					consumer1 = new Thread(cons8);
					counter++;
					consumer[7] = cons8;
				default:
					System.out.print("Checkout Range exceeded");
				}
			}
		} catch (Exception e) {
			Logger.getLogger(IthreadImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		System.out.print(consumer);
		System.out.print(producer);

		ConsumerGraph graphicsObject = new ConsumerGraph(consumer, producer);
		graphicsObject.setVisible(true);
		prodd.start();

		for (int i = 1; i <= NumOfCashiers; i++) {
			switch (i) {
			case 1:
				consumer1.start();
			case 2:
				consumer2.start();
			case 3:
				consumer3.start();
			case 4:
				consumer4.start();
			case 5:
				consumer5.start();
			case 6:
				consumer6.start();
			case 7:
				consumer7.start();
			case 8:
				consumer8.start();
			default:
				System.out.print("Checkout Range exceeded");
			}
		}
		try {
			prodd.join();
			for (int i = 1; i <= NumOfCashiers; i++) {
				switch (i) {
				case 1:
					consumer1.join();
				case 2:
					consumer2.join();
				case 3:
					consumer3.join();
				case 4:
					consumer4.join();
				case 5:
					consumer5.join();
				case 6:
					consumer6.join();
				case 7:
					consumer7.join();
				case 8:
					consumer8.join();
				default:
					System.out.print("Checkout Range exceeded");
				}
			}
		}

		catch (InterruptedException ex) {
			Logger.getLogger(IthreadImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
