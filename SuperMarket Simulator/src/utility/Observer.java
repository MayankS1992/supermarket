package utility;

import java.io.IOException;

public abstract class Observer {
	
	protected CustomerSubject subject;
	
	public abstract void update() throws IOException;

}
