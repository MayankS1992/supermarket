package Controller;


public interface Ithread 
{
	@SuppressWarnings("rawtypes")
	public static void threadinstantiate(int maxProducts, int number_of_Checkout) 
	{
		new IthreadImpl(maxProducts,number_of_Checkout);
	}
}
