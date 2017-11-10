package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Ithread;

public class TopLevelWindow {
	public TopLevelWindow() {

		// Create and set up the window.
		JFrame frame = new JFrame("SuperMarket Simulator");
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.revalidate();
		frame.repaint();

		frame.setVisible(true);
//		panel.setLayout(null);
		JLabel Number_of_Checkouts = new JLabel("Number of Checkouts");
		Number_of_Checkouts.setBounds(10, 10, 80, 25);
		panel.add(Number_of_Checkouts);

		JTextField Number_of_Checkout = new JTextField(20);
		Number_of_Checkout.setBounds(100, 10, 160, 25);
		panel.add(Number_of_Checkout);

		JLabel passwordLabel = new JLabel("Max Products");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JTextField maxProducts = new JTextField(20);
		maxProducts.setBounds(100, 40, 160, 25);
		panel.add(maxProducts);

		JButton loginButton = new JButton("Simulate");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);

		JButton registerButton = new JButton("Close");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		frame.revalidate();
		frame.repaint();

		loginButton.addActionListener(new ActionListener() {
			public int parserValues(JTextField input) {
				int value = Integer.parseInt(input.getText());
				return value;
			}

			public void actionPerformed(ActionEvent e) {
				System.out.println("Button was clicked");
				ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
				if (parserValues(maxProducts) > 200 || parserValues(Number_of_Checkout) > 8) {
					JOptionPane.showMessageDialog(null, "Please enter the data in the defined range", "ALERT", JOptionPane.WARNING_MESSAGE);
				} else {
					exec.scheduleAtFixedRate(new Runnable() {
						public void run() {
							Ithread.threadinstantiate(parserValues(maxProducts), parserValues(Number_of_Checkout));
						}
					}, 0, 5, TimeUnit.SECONDS);
				}

			}
		});

	}
}
