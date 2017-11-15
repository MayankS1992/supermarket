package threadFactory;
import model.Cashier;

public class Factory {
	
	public static Threads createThread(String cashierNumber, Cashier cons){
	      if(cashierNumber == null){
	         return null;
	      }		
	      if(cashierNumber.equalsIgnoreCase("1")){
	         return new Consumer1(cons);
	         
	      } else if(cashierNumber.equalsIgnoreCase("2")){
	         return new Consumer2(cons);
	         
	      } else if(cashierNumber.equalsIgnoreCase("3")){
	         return new Consumer3(cons);
	      } 
	      else if(cashierNumber.equalsIgnoreCase("4")){
		         return new Consumer4(cons);
		      }
	      else if(cashierNumber.equalsIgnoreCase("5")){
		         return new Consumer5(cons);
		      }
	      else if(cashierNumber.equalsIgnoreCase("6")){
		         return new Consumer6(cons);
		      }
	      else if(cashierNumber.equalsIgnoreCase("7")){
		         return new Consumer7(cons);
		      }
	      else if(cashierNumber.equalsIgnoreCase("8")){
		         return new Consumer8(cons);
		      }
	      
	      return null;
	   }

	public static Threads startThread(String cashierNumber) {
		if(cashierNumber == null){
	         return null;
	      }		
	      if(cashierNumber.equalsIgnoreCase("1")){
	         return new Consumer1();
	         
	      } else if(cashierNumber.equalsIgnoreCase("2")){
	         return new Consumer2();
	         
	      } else if(cashierNumber.equalsIgnoreCase("3")){
	         return new Consumer3();
	      } 
	      else if(cashierNumber.equalsIgnoreCase("4")){
		         return new Consumer4();
		      }
	      else if(cashierNumber.equalsIgnoreCase("5")){
		         return new Consumer5();
		      }
	      else if(cashierNumber.equalsIgnoreCase("6")){
		         return new Consumer6();
		      }
	      else if(cashierNumber.equalsIgnoreCase("7")){
		         return new Consumer7();
		      }
	      else if(cashierNumber.equalsIgnoreCase("8")){
		         return new Consumer8();
		      }
	      
	      return null;
	}

}
