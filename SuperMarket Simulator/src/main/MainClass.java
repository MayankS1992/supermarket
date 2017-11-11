package main;

import java.io.IOException;

import view.TopLevelWindow;


/**
 * @author Mayank
 * 
 * Entry point of the code.
 *
 */
public class MainClass {
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		try {
			TopLevelWindow entryPoint = new TopLevelWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
