package Controller;

/**
 * @author Mayank 
 */
public interface Ithread {
	public static void threadinstantiate(int maxProducts, int number_of_Checkout, int i, Boolean scanners) {
		new ThreadController(maxProducts, number_of_Checkout, i, scanners);
	}
}
