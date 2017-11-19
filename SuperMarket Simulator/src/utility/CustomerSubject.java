package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerSubject {
	
	 private List<Observer> observers = new ArrayList<Observer>();
	 NavigableMap<String, String> customer = new TreeMap<String, String>();
	    
//	static Map<Integer, String> customer = new LinkedHashMap<Integer, String>();
	
	public NavigableMap<String, String> getCustomerHistory() {
		return customer;
	}

	public void setCustomerHistory(int products, int waitTime) throws IOException {
		customer.put(String.valueOf(products), String.valueOf(waitTime));
		notifyAllObservers();
	}
	
	public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers() throws IOException{
	      for (Observer observer : observers) {
	         observer.update();
	      }
	   }

}
