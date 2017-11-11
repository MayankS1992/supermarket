package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import model.Cashier;
import model.Feeder;
import utility.Calculator;
import utility.UserInputs;

public class ConsumerGraph extends JFrame {

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

	public ConsumerGraph(Cashier[] cus, Feeder pp) 
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
		this.setSize(1200, 700);// set frame size
		this.setLocationRelativeTo(null);// set frame start location
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close
		this.setResizable(true);// disable resize
	}

	private void createView() 
	{
		// Creation of panel for each queue
		checkOutsPanel = new JPanel();
		checkOutsPanel.setLayout(new GridLayout(checkOuts + 1, 1, 2, 2));
		infoPanel();			
		//Creates 8 Checkouts setting the border and background colors and creates an express checkout lane too
		createCheckOuts();
		// add stuff into frame
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
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		infoPanel.setBackground(new Color(0,0,182,155));	
	}

	@SuppressWarnings("rawtypes")
	private void createCheckOuts() 
	{
		Calculator c=new Calculator();
		ArrayList List = new ArrayList();
		List = (ArrayList) c.getUtilization();
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
				clerkPanel[count].add(new JLabel("<html><br></html>", SwingConstants.CENTER));
				
			}
			else
			{
				clerkPanel[count].add(new JLabel("Checkout " + (count + 1)));
				clerkPanel[count].add(new JLabel("<html><br></html>", SwingConstants.CENTER));
				clerkPanel[count].add(new JLabel("Utilization :" + List.get(count)));
				clerkPanel[count].add(new JLabel("<html><br></html>", SwingConstants.CENTER));
				
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
		checkOutsPanel = new JPanel();
		checkOutsPanel.setLayout(new GridLayout(checkOuts + 1, 1, 2, 2));
		createCheckOuts();
		getContentPane().add(checkOutsPanel);
		Calculator c=new Calculator();
		infoPanel.removeAll();
		infoPanel.add(new JLabel("no of customers:"));
		infoPanel.add(new JLabel("<html><div>"+c.getTotalCustomers()+"</div></html>", SwingConstants.CENTER));
		infoPanel.add(new JLabel("<html><br></html>", SwingConstants.CENTER));
		
		infoPanel.add(new JLabel("Lost Customers:"));
		infoPanel.add(new JLabel("<html><div>"+c.getCustomerLost()+"</div></html>", SwingConstants.CENTER));
		infoPanel.add(new JLabel("<html><br></html>", SwingConstants.CENTER));
		
		infoPanel.add(new JLabel("no of products"));
		infoPanel.add(new JLabel("<html><div>"+c.getTotalProducts()+"</div></html>", SwingConstants.CENTER));
		infoPanel.add(new JLabel("<html><br></html>", SwingConstants.CENTER));
		
		infoPanel.add(new JLabel("Average wait time for customer:"));
		infoPanel.add(new JLabel("<html><div>"+ c.waitTime()+"</div></html>", SwingConstants.CENTER));
		infoPanel.add(new JLabel("<html><br></html>", SwingConstants.CENTER));
		
		infoPanel.add(new JLabel("Average Utilization:"+ c.average()));
		infoPanel.add(new JLabel("<html><br></html>", SwingConstants.CENTER));
		infoPanel.add(new JLabel("Average Products per trolly:"+ c.getAverageProductsPerTrolly() ));
		infoPanel.add(new JLabel("<html><br></html>", SwingConstants.CENTER));
		infoPanel.add(new JLabel("Total Wait time for customers:"+ c.totTime() ));
		checkOutsPanel.add(infoPanel);
	}

	//Timing to refresh queue
	private class TimerListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				showCustomer();
				showLive();
				checkOutsPanel.revalidate();
				checkOutsPanel.repaint();	
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

