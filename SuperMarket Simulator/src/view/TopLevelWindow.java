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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.Ithread;



/**
 * @author Mayank
 * Graphics for the User Input page.
 *
 */

public class TopLevelWindow {
	public TopLevelWindow() throws IOException {

		// Create and set up the window.
		JFrame frame = new JFrame("SuperMarket Simulator");
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setVisible(true);
		
		frame.getContentPane().add(new JPanelWithBackground("images/bg.jpg"));
		frame.add(panel);
		
		frame.setVisible(true);
		JLabel Number_of_Checkouts = new JLabel("Number of Checkouts");
		Number_of_Checkouts.setBounds(10, 10, 80, 25);
		Number_of_Checkouts.setVisible(true);
		panel.add(Number_of_Checkouts);

		JTextField Number_of_Checkout = new JTextField(20);
		Number_of_Checkout.setBounds(100, 10, 160, 25);
		Number_of_Checkout.setVisible(true);
		panel.add(Number_of_Checkout);

		JLabel passwordLabel = new JLabel("Max Products");
		passwordLabel.setBounds(10, 40, 80, 25);
		passwordLabel.setVisible(true);
		panel.add(passwordLabel);

		JTextField maxProducts = new JTextField(20);
		maxProducts.setBounds(100, 40, 160, 25);
		maxProducts.setVisible(true);
		panel.add(maxProducts);

		JButton loginButton = new JButton("Simulate");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.setVisible(true);
		panel.add(loginButton);

		JButton registerButton = new JButton("Close");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
//		frame.getContentPane().setSize(399,399);
//		frame.getContentPane().setSize(400,400);
		frame.revalidate();
		frame.repaint();
		frame.pack();

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
	
	
	/**
	 * @author Mayank
	 * Draws a background Image
	 */
	@SuppressWarnings("serial")
	
	public class JPanelWithBackground extends JPanel {

		  private Image backgroundImage;

		  // Some code to initialize the background image.
		  // Here, we use the constructor to load the image. This
		  // can vary depending on the use case of the panel.
		  public JPanelWithBackground(String fileName) throws IOException {
		    backgroundImage = ImageIO.read(new File(fileName));
		  }

		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    // Draw the background image.
		    g.drawImage(backgroundImage, 0, 0, this);
		  }
		}
}
