package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CreateExcelReport {
	
	@SuppressWarnings("resource")
	public CreateExcelReport(CustomerSubject subject) throws IOException
	{
		
		String fileName = "C:\\Users\\Mayank\\Desktop\\Reports\\report.txt";
		FileWriter fw = new FileWriter(fileName, true);
		Calculator c = new Calculator();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {

			String content = subject.getCustomerHistory().get(String.valueOf(c.getTotalCustomers()));

			bw.write(content);

			// no need to close it.
			//bw.close();

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
}

