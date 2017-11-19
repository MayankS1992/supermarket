package Controller;

/**
 * @author Mayank Interface for implementing the Thread Controller
 */
public interface Ithread {
	public static void threadinstantiate(int maxProducts, int number_of_Checkout, int i) {
		new ThreadController(maxProducts, number_of_Checkout, i);
	}
}
