package Controller;


/**
 * @author Mayank
 * Interface for implementing the Thread Controller
 */
public interface Ithread 
{
	@SuppressWarnings("rawtypes")
	public static void threadinstantiate(int maxProducts, int number_of_Checkout) 
	{
		new ThreadController(maxProducts,number_of_Checkout);
	}
}
