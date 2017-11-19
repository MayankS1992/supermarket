package utility;

import java.io.IOException;


public class NewCustomerObserver extends Observer {

	public NewCustomerObserver(CustomerSubject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() throws IOException {

		CreateExcelReport updateReport = new CreateExcelReport(subject);
		System.out.println("Customer History " + (subject.getCustomerHistory()));
	}

}
