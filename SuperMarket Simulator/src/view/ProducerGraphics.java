package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * @author Mayank
 * The Class responsible for generation of graphics for the customers.
 * Displays an icon where a customer is present and when the customer is absent shows null.
 */
@SuppressWarnings("serial")
public class ProducerGraphics extends JPanel {
	@SuppressWarnings("unused")
	final private static Border blackline = BorderFactory.createLineBorder(Color.black);
	final public static ImageIcon img = new ImageIcon("images/cashier.png");
	final public JLabel cust = new JLabel("", img, SwingConstants.CENTER);
	final public JLabel noCust = new JLabel("Null");
	private int c;

	@SuppressWarnings("unused")
	public ProducerGraphics() {
		setBackground(Color.white);
		setLayout(new BorderLayout());
		cust.removeAll();
		JLabel cust = new JLabel("Shopper", img, SwingConstants.CENTER);
		setBorder(blackline);
		c = 0;
		addIcon();
	}
	
	public void addIcon() {
		removeAll(); // Clear panel
		if (c != 0) {
			add(cust);
			JLabel products = new JLabel(c + "");
			add(products, BorderLayout.WEST);
		} else {
			add(noCust);
		}
	}

	public void setCustomer(int cc) {
		c = cc;
		addIcon();
	}

	public int getNumberOfGoods() {
		return c;
	}
}