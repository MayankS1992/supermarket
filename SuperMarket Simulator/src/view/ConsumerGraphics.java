package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import model.Cashier;
import model.Feeder;
import utility.Calculator;
import utility.UserInputs;

public class ConsumerGraphics extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static UserInputs userInputs = new UserInputs();
	public final static int checkOuts = userInputs.getSetNumOfCashiers();;
	public final static int maxQueueSize = 7;
	private JPanel queue[] = new JPanel[checkOuts];
	private JPanel queueLines[][] = new JPanel[checkOuts][maxQueueSize];
	private JPanel clerkPanel[];
	private JPanel checkOutsPanel;
	private JPanel infoPanel;
	private ProducerGraphics cv[][] = new ProducerGraphics[checkOuts][maxQueueSize];
	private Cashier[] consumerArray;
	private Feeder producerArray;
	private Timer timer;

	public ConsumerGraphics(Cashier[] cus, Feeder pp) 
	{             
		consumerArray=cus;
        setProducerArray(pp);		
		createFrame();
		createView();		
		timer = new Timer(70, new TimerListener());
		timer.start();
	}
	
	  
	private void createFrame() 
	{
        this.setTitle(" Checkout Simulation ");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
	}

	private void createView() 
	{
		checkOutsPanel = new JPanel();
		checkOutsPanel.setLayout(new GridLayout(checkOuts + 1, 1, 2, 2));
		infoPanel();			
		createCheckOuts();
		getContentPane().add(checkOutsPanel);

		for (int count = 0; count < checkOuts; count++) 
		{
			for (int i = 0; i < maxQueueSize; i++) 
			{
				cv[count][i] = new ProducerGraphics();
				System.out.println(cv[count][i]);
				queueLines[count][i].add(cv[count][i]);
			}
		}
	}

	private void infoPanel() 
	{	
		clerkPanel = new JPanel[checkOuts];
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(1, maxQueueSize + 1, 2, 1));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		infoPanel.setBackground(new Color(0,10,182,100));	
		checkOutsPanel.add(infoPanel);
	}

	@SuppressWarnings("rawtypes")
	private void createCheckOuts() 
	{
		Calculator c=new Calculator();
		ArrayList List = new ArrayList();
		List = (ArrayList) c.getUtilization();
		System.out.println(List);
		ImageIcon counterImg = new ImageIcon("images/checkout.png");
		for (int count = 0; count < checkOuts; count++) 
		{
			clerkPanel[count] = new JPanel();
			clerkPanel[count].setBorder(BorderFactory.createLineBorder(Color.blue));
			clerkPanel[count].setBackground(Color.CYAN);
			if(count==0)
			{
				clerkPanel[count].add(new JLabel("Express Lane " + (count + 1)));
				clerkPanel[count].add(new JLabel("<html><br></html>", SwingConstants.CENTER));
				clerkPanel[count].add(new JLabel("Utilization :" +List.get(count)));
				clerkPanel[count].add(new JLabel("", (Icon) counterImg, SwingConstants.CENTER));
				
			}
			else
			{
				clerkPanel[count].add(new JLabel("Utilization :" + List.get(count)));
				clerkPanel[count].add(new JLabel("<html><br></html>", SwingConstants.CENTER));
				clerkPanel[count].add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
				
			}			
			queue[count] = new JPanel();
			queue[count].setLayout(new GridLayout(1, maxQueueSize + 1, 2, 1));
			queue[count].setBorder(BorderFactory.createLineBorder(Color.black));
			queue[count].add(clerkPanel[count]);

			for (int i = 0; i < maxQueueSize; i++) 
			{
				queueLines[count][i] = new JPanel();
				queueLines[count][i].setBorder(BorderFactory.createLineBorder(Color.darkGray));
				queue[count].add(queueLines[count][i]);
			}
			checkOutsPanel.add(queue[count]);
		}
	}

	public void showCustomer() 
	{
		for (int count = 0; count < checkOuts; count++) {
			for (int i = 0; i < maxQueueSize; i++) {
				try 
				{
					if (consumerArray[count] != null)
					cv[count][i].setCustomer((int)(consumerArray[count].queueReturn())[i]);
				} 
				catch (IndexOutOfBoundsException e) 
				{
					cv[count][i].setCustomer(0);
				}
			}
		}
	}
	public void showLive()
	{
		
		Calculator c=new Calculator();
		infoPanel.removeAll();
		
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		infoPanel.add(new JLabel("no of customers:"));
		infoPanel.add(new JLabel(c.getTotalCustomers()+"", SwingConstants.LEFT));
		
		infoPanel.add(new JLabel("Lost Customers:"));
		infoPanel.add(new JLabel(c.getCustomerLost()+"", SwingConstants.LEFT));
		
		infoPanel.add(new JLabel("no of products"));
		infoPanel.add(new JLabel(c.getTotalProducts()+"", SwingConstants.LEFT));
		
		infoPanel.add(new JLabel("Average wait time for customer:"));
		infoPanel.add(new JLabel(c.waitTime()+"", SwingConstants.LEFT));
		
		infoPanel.add(new JLabel("Average Utilization:"));
		infoPanel.add(new JLabel(c.average()+"", SwingConstants.LEFT));
		
		infoPanel.add(new JLabel("Average Products per trolly:" ));
		infoPanel.add(new JLabel(c.getAverageProductsPerTrolly()+"", SwingConstants.LEFT));
		
		infoPanel.add(new JLabel("Total Wait time for customers:" ));
		infoPanel.add(new JLabel(c.totTime()+"", SwingConstants.LEFT));
	}

	//Timing to refresh queue
	private class TimerListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				checkOutsPanel.revalidate();
				checkOutsPanel.repaint();
				showCustomer();
				showLive();
			}
			catch(Exception e1)
			{
				
			}
			
		}
	}
	
    public Feeder getProducerArray() {
		return producerArray;
	}


	public void setProducerArray(Feeder producerArray) {
		this.producerArray = producerArray;
	}

	
}

