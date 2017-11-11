package utility;


/**
 * @author Mayank
 * Getters and setters for the user Inputs
 *
 */
public class UserInputs {
	
	static int setNumOfCashiers;
	static int maximumProducts;

	public int getSetNumOfCashiers() {
		return setNumOfCashiers;
	}

	public void setSetNumOfCashiers(int number_of_Checkout) {
		UserInputs.setNumOfCashiers = number_of_Checkout;
	}

	public int getMaximumProducts() {
		return maximumProducts;
	}

	public void setMaximumProducts(int maximumProducts) {
		UserInputs.maximumProducts = maximumProducts;
	}

}
