package utility;

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

	public void setCustomerHistory(int i, int waitTime) {
		customer.put(String.valueOf(i), String.valueOf(waitTime));
		notifyAllObservers();
	}
	
	public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	   }

	public Object lastEntry() {
		// TODO Auto-generated method stub
		return null;
	} 

}
