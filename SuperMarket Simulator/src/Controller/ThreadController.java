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
import view.ConsumerGraphics;


/**
 * @author Mayank
 * The threads are executed as per the user input.
 * Notifies the consumerGraph to create graphics for the producer and consumer so created here.
 *
 */
public class ThreadController implements Ithread {
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

	@SuppressWarnings({ "rawtypes" })
	public ThreadController(int maxProducts, int number_of_Checkout, int simulationTime) 
	{
		UserInputs userInputs = new UserInputs();
		userInputs.setSetNumOfCashiers(number_of_Checkout);
		userInputs.setMaximumProducts(maxProducts);
		userInputs.setSimulationTime(simulationTime);
		
		int NumOfCashiers = userInputs.getSetNumOfCashiers();
		Cashier[] consumer = new Cashier[NumOfCashiers];
		BlockingQueue[] queue = new BlockingQueue[NumOfCashiers];
		ArrayList<BlockingQueue> linkedQueues = new ArrayList<BlockingQueue>();

		for (int i = 0; i < NumOfCashiers; i++) {
			/*		
			 * 
			 * An optionally-bounded blocking queue based on linked nodes. 
			 * This queue orders elements FIFO (first-in-first-out). 
			 * The head of the queue is that element that has been on the queue the longest time. 
			 * The tail of the queue is that element that has been on the queue the shortest time. 
			 * New elements are inserted at the tail of the queue, 
			 * and the queue retrieval operations obtain elements at the head of the queue.
			 * 
			 *  
			 */			
			queue[i] = new LinkedBlockingQueue();
			linkedQueues.add(queue[i]);
		}

		Feeder producer = new Feeder(queue);
		prodd = new Thread(producer);
		try {
			for (int i = 1; i <= NumOfCashiers; i++) {
				switch (i) {
				case 1:
					Cashier1 cons1 = new Cashier1((BlockingQueue) linkedQueues.get(i-1));
					consumer1 = new Thread(cons1);
					consumer[0] = cons1;
					break;
				case 2:
					Cashier2 cons2 = new Cashier2((BlockingQueue) linkedQueues.get(i-1));
					consumer2 = new Thread(cons2);
					consumer[1] = cons2;
					break;
				case 3:
					Cashier3 cons3 = new Cashier3((BlockingQueue) linkedQueues.get(i-1));
					consumer3 = new Thread(cons3);
					consumer[2] = cons3;
					break;
				case 4:
					Cashier4 cons4 = new Cashier4((BlockingQueue) linkedQueues.get(i-1));
					consumer4 = new Thread(cons4);
					consumer[3] = cons4;
					break;
				case 5:
					Cashier5 cons5 = new Cashier5((BlockingQueue) linkedQueues.get(i-1));
					consumer5 = new Thread(cons5);
					consumer[4] = cons5;
					break;
				case 6:
					Cashier6 cons6 = new Cashier6((BlockingQueue) linkedQueues.get(i-1));
					consumer6 = new Thread(cons6);
					consumer[5] = cons6;
					break;
				case 7:
					Cashier7 cons7 = new Cashier7((BlockingQueue) linkedQueues.get(i-1));
					consumer7 = new Thread(cons7);
					consumer[6] = cons7;
					break;
				case 8:
					Cashier8 cons8 = new Cashier8((BlockingQueue) linkedQueues.get(i-1));
					consumer8 = new Thread(cons8);
					consumer[7] = cons8;
					break;
				default:
					System.out.print("Checkout Range exceeded");
					break;
				}
			}
		} catch (Exception e) {
			Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, e);
		}
		
		
		/*
		 * 
		 * The Consumer Graphics Constructor 
		 * with the consumer and producer 
		 * objects for graphics creation
		 * 
		 * */
		ConsumerGraphics graphicsObject = new ConsumerGraphics(consumer, producer);
		graphicsObject.setVisible(true);
		
		prodd.start();

		for (int i = 1; i <= NumOfCashiers; i++) {
			switch (i) {
			case 1:
				consumer1.start();
				break;
			case 2:
				consumer2.start();
				break;
			case 3:
				consumer3.start();
				break;
			case 4:
				consumer4.start();
				break;
			case 5:
				consumer5.start();
				break;
			case 6:
				consumer6.start();
				break;
			case 7:
				consumer7.start();
				break;
			case 8:
				consumer8.start();
				break;
			default:
				System.out.print("Checkout Range exceeded");
				break;
			}
		}
		try {
			prodd.join();
			for (int i = 1; i <= NumOfCashiers; i++) {
				switch (i) {
				case 1:
					consumer1.join();
					break;
				case 2:
					consumer2.join();
					break;
				case 3:
					consumer3.join();
					break;
				case 4:
					consumer4.join();
					break;
				case 5:
					consumer5.join();
					break;
				case 6:
					consumer6.join();
					break;
				case 7:
					consumer7.join();
					break;
				case 8:
					consumer8.join();
					break;
				default:
					System.out.print("Checkout Range exceeded");
					break;
				}
			}
		}

		catch (InterruptedException ex) {
			Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
