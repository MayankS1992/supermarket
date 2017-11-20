package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.Ithread;
import utility.Labels;

/**
 * @author Mayank, Chandan
 * Graphics for the User Input page.
 *
 */

public class TopLevelWindow {
	/**
	 * @throws IOException
	 */

	Boolean scanners = false;

	public TopLevelWindow() throws IOException {

		// Create and set up the window.

		Labels label = new Labels();
		JFrame frame = new JFrame(label.getAppHeader());
		frame.setSize(280, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setVisible(true);
		frame.add(panel);

		frame.setVisible(true);
		JLabel Number_of_Checkouts = new JLabel(label.getHeader1());
		Number_of_Checkouts.setBounds(10, 10, 80, 25);
		Number_of_Checkouts.setVisible(true);
		panel.add(Number_of_Checkouts);

		JTextField Number_of_Checkout = new JTextField(20);
		Number_of_Checkout.setBounds(100, 10, 160, 25);
		Number_of_Checkout.setVisible(true);
		panel.add(Number_of_Checkout);

		JLabel passwordLabel = new JLabel(label.getHeader2());
		passwordLabel.setBounds(10, 40, 80, 25);
		passwordLabel.setVisible(true);
		panel.add(passwordLabel);

		JTextField maxProducts = new JTextField(20);
		maxProducts.setBounds(100, 40, 160, 25);
		maxProducts.setVisible(true);
		panel.add(maxProducts);

		JLabel simulationTime = new JLabel(label.getHeader3());
		simulationTime.setBounds(10, 40, 80, 25);
		simulationTime.setVisible(true);
		panel.add(simulationTime);

		JTextField simulationTimeField = new JTextField(20);
		simulationTimeField.setBounds(100, 40, 160, 25);
		simulationTimeField.setVisible(true);
		panel.add(simulationTimeField);

		JButton simulate = new JButton(label.getButton1());
		simulate.setBounds(10, 80, 80, 25);
		simulate.setVisible(true);
		panel.add(simulate);

		JButton closeButton = new JButton(label.getButton2());
		closeButton.setBounds(180, 80, 80, 25);
		panel.add(closeButton);

		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Use Scanners");
		chckbxNewCheckBox_1.setBounds(200, 100, 80, 25);
		chckbxNewCheckBox_1.setVisible(true);
		panel.add(chckbxNewCheckBox_1);

		frame.revalidate();
		frame.repaint();

		/* Listener for Simulate */
		simulate.addActionListener(new ActionListener() {
			public int parserValues(JTextField input) {
				int value = Integer.parseInt(input.getText());
				return value;
			}

			public void actionPerformed(ActionEvent e) {
				System.out.println("Button was clicked");
				ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
				if (parserValues(maxProducts) > 500 || parserValues(Number_of_Checkout) > 8) {
					JOptionPane.showMessageDialog(null, "Please enter the data in the defined range", "ALERT",
							JOptionPane.WARNING_MESSAGE);
				} else {
					exec.scheduleAtFixedRate(new Runnable() {
						public void run() {
							Ithread.threadinstantiate(parserValues(maxProducts), parserValues(Number_of_Checkout),
									parserValues(simulationTimeField),scanners);
						}
					}, 0, 5, TimeUnit.SECONDS);
				}

			}
		});

		/**
		 * 
		 * Closes the window on click of close
		 * 
		 * 
		 */

		closeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

		chckbxNewCheckBox_1.addActionListener(new ActionListener() {

			@Override
			/* Listener for check-box */
			public void actionPerformed(ActionEvent arg0) {
				scanners = true;
			}
		});

	}
}
