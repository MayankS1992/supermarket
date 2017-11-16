package utility;


import java.io.File;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class NewCustomerObserver extends Observer {

	public NewCustomerObserver(CustomerSubject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	   @Override
	   public void update() {
		   
		    updateReport();
	      System.out.println( "Customer History " + ( subject.getCustomerHistory() ) ); 
	   }

	private void updateReport() {
		
		try{
			Calculator c = new Calculator();
			String fileName = "C:\\Users\\Mayank\\Desktop\\Reports\\3.xls";
			WritableWorkbook wb = Workbook.createWorkbook(new File(fileName));
			WritableSheet sheet = wb.createSheet("sheet1", 0);
			Label label = new Label(0, c.getTotalCustomers(), String.valueOf(c.getTotalCustomers()));
			sheet.addCell(label);
			
			Label label1 = new Label(0, c.getTotalCustomers()+1, subject.getCustomerHistory().get(String.valueOf(c.getTotalCustomers())));
			sheet.addCell(label1);
			
			wb.write();
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
