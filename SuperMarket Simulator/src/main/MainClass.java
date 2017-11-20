package main;


import java.awt.Color;
import java.io.File;

import javax.swing.UIManager;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import utility.Calculator;
import utility.CustomerSubject;
import view.TopLevelWindow;

/**
 * @author Mayank, Chandan
 * 
 *        
 *         Entry point of the code.
 *         
 *
 */
public class MainClass {

	public static void main(String args[]) {
		
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				
				if ("Nimbus".equals(info.getName())) {

					UIManager.setLookAndFeel(info.getClassName());
					
					UIManager.getLookAndFeelDefaults().put("Panel.background", Color.LIGHT_GRAY.brighter());
					
					TopLevelWindow entryPoint = new TopLevelWindow();
					
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
}
