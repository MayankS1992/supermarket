package utility;


/**
 * @author Mayank
 * Getters and setters for the user Inputs
 *
 */
public class UserInputs {
	
	static int setNumOfCashiers;
	static int maximumProducts;
	static int simulationTime;
	
	/**
	 * @return the setNumOfCashiers
	 */
	public int getSetNumOfCashiers() {
		return setNumOfCashiers;
	}

	public void setSetNumOfCashiers(int number_of_Checkout) {
		UserInputs.setNumOfCashiers = number_of_Checkout;
	}
	
	/**
	 * @return the maximumProducts
	 */
	public int getMaximumProducts() {
		return maximumProducts;
	}

	public void setMaximumProducts(int maximumProducts) {
		UserInputs.maximumProducts = maximumProducts;
	}

	public void setSimulationTime(int simulationTime) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the simulationTime
	 */
	public int getSimulationTime() {
		return simulationTime;
	}

}
