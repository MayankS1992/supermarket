package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import model.Cashier;
import model.Customer;
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
	@SuppressWarnings("unused")
	private Feeder producerArray;
	private Timer timer;

	public ConsumerGraphics(Cashier[] cus, Feeder pp) {
		consumerArray = cus;
		setProducerArray(pp);
		createFrame();
		createView();
		timer = new Timer(70, new TimerListener());
		timer.start();
	}

	private void createFrame() {
		this.setTitle(" Checkout Simulation ");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
	}

	private void createView() {
		checkOutsPanel = new JPanel();
		checkOutsPanel.setLayout(new GridLayout(checkOuts + 1, 1, 2, 2));
		infoPanel();
		createCheckOuts();
		getContentPane().add(checkOutsPanel);

		for (int count = 0; count < checkOuts; count++) {
			for (int i = 0; i < maxQueueSize; i++) {
				cv[count][i] = new ProducerGraphics();
				// System.out.println(cv[count][i]);
				queueLines[count][i].add(cv[count][i]);
			}
		}
	}

	private void infoPanel() {
		clerkPanel = new JPanel[checkOuts];
		infoPanel = new JPanel();
		Font font = new Font("Verdana", Font.BOLD, 8);
		infoPanel.setLayout(new GridLayout(1, maxQueueSize + 1, 2, 1));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		infoPanel.setFont(font);
		infoPanel.setBackground(new Color(0, 10, 182, 100));
		checkOutsPanel.add(infoPanel);
	}

	@SuppressWarnings("rawtypes")
	private void createCheckOuts() {
		try {
			Calculator c = new Calculator();
			ArrayList List = new ArrayList();
			ImageIcon counterImg = new ImageIcon("images/lappy.png");
			for (int count = 0; count < checkOuts; count++) {
				clerkPanel[count] = new JPanel();
				if (count == 0) {
					clerkPanel[count].setBorder(BorderFactory.createLineBorder(Color.blue));
					clerkPanel[count].setBackground(Color.CYAN);
					clerkPanel[count]
							.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization1()));
					clerkPanel[count]
							.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier1())));
					clerkPanel[count].add(new JLabel("", (Icon) counterImg, SwingConstants.CENTER));

				} else {
					clerkPanel[count].setBorder(BorderFactory.createLineBorder(Color.blue));
					clerkPanel[count].setBackground(Color.CYAN.darker());
					switch (count) {
					case 1:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization2()));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier2())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					case 2:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization3()));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier3())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					case 3:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization4()));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier4())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					case 4:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization5()));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier5())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					case 5:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization6()));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier6())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					case 6:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization7()));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier7())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					case 7:
						clerkPanel[count]
								.add(new JLabel("<html><b>Utilization :</b><html>" + c.getUtilization8()));
//						clerkPanel[count].add(new JLabel("<html><br></html>", SwingConstants.CENTER));
						clerkPanel[count]
								.add(new JLabel("<html><b>Wait Time :</b><html>" + TimeUnit.NANOSECONDS.toSeconds(c.getWaitTimeForCashier8())));
						clerkPanel[count]
								.add(new JLabel("Checkout " + (count + 1), (Icon) counterImg, SwingConstants.CENTER));
						break;
					default:
						System.out.print("Checkout Range exceeded");
						break;
					}

				}
				queue[count] = new JPanel();
				queue[count].setLayout(new GridLayout(1, maxQueueSize + 1, 2, 1));
				queue[count].setBorder(BorderFactory.createLineBorder(Color.black));
				queue[count].add(clerkPanel[count]);

				for (int i = 0; i < maxQueueSize; i++) {
					queueLines[count][i] = new JPanel();
					queueLines[count][i].setBorder(BorderFactory.createLineBorder(Color.darkGray));
					queue[count].add(queueLines[count][i]);
				}
				checkOutsPanel.add(queue[count]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void showCustomer() {
		Object[] arr = null;
		for (int count = 0; count < checkOuts; count++) {
			for (int i = 0; i < maxQueueSize; i++) {
				try {
					if (consumerArray[count] != null)
						cv[count][i].setCustomer((Customer) (consumerArray[count].queueReturn())[i]);
				} catch (IndexOutOfBoundsException e) {
					// cv[count][i].setCustomer((Customer)(consumerArray[count].queueReturn())[i]);
				}
			}
		}
	}

	public void showLive() {
		try {
			Calculator c = new Calculator();
			Customer ca = new Customer();
			infoPanel.removeAll();
			Font font = new Font("Verdana", Font.BOLD, 8);
			infoPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
			infoPanel.add(new JLabel("no of customers:"));
			infoPanel.add(new JLabel(c.getTotalCustomers() + "", SwingConstants.LEFT));

			infoPanel.add(new JLabel("Lost Customers:"));
			infoPanel.add(new JLabel(c.getCustomerLost() + "", SwingConstants.LEFT));

			infoPanel.add(new JLabel("no of products"));
			infoPanel.add(new JLabel(ca.getTotal() + "", SwingConstants.LEFT));

			infoPanel.add(new JLabel("Average wait time for customer:"));
			infoPanel.add(new JLabel(c.getTotalTime()/c.getTotalCustomers() + "", SwingConstants.LEFT));

			infoPanel.add(new JLabel("Average Utilization:"));
			infoPanel.add(new JLabel(c.average() + "", SwingConstants.LEFT));

			infoPanel.add(new JLabel("Average Products per trolly:"));
			infoPanel.add(new JLabel(ca.getTotal() / c.getTotalCustomers() + "", SwingConstants.LEFT));

//			infoPanel.add(new JLabel("Total Wait time for customers:"));
//			infoPanel.add(new JLabel(c.totTime() + "", SwingConstants.LEFT));

			infoPanel.setFont(font);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Timing to refresh queue
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {

				createView();
				checkOutsPanel.revalidate();
				checkOutsPanel.repaint();
				showCustomer();
				showLive();
			} catch (Exception e1) {

			}

		}
	}

	public void setProducerArray(Feeder producerArray) {
		this.producerArray = producerArray;
	}

}
