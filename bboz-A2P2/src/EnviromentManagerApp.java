// IAT 265 - Assignment 3.2
//Primary Programmer: Berke Boz
//
//Class: EnviromentManagerApp
//Superclass JFrame
//
//
//Assignment 1.2 Change Log
//
//	- Changed Panel size
//		- Was 1280x720
//		- Now 1920x1080
//
//
//Assignment 2 Change Log
//
//	- None
//
//Assignment 3 Change Log
//
//	- None
//

import java.awt.Dimension;

import javax.swing.JFrame;

public class EnviromentManagerApp extends JFrame{

	private static final long serialVersionUID = 1L;


	//This constructor acts as an driver function for the project
	public EnviromentManagerApp(String title) {
		super(title);																//Calls the superclass
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//Exits the program when closed
		this.setSize(1920,1080);													//Set frame resolution to 1080p (1920x1080)
		
		Dimension panelSize = this.getSize();										//Creates a Dimension type object to pass the screen size values
		EnviromentPanel animPanel = new EnviromentPanel(panelSize);					//Panel size is subject to change
				
		add(animPanel);																//Panel is added
		
		this.setVisible(true);														//Sets the panel visible
	}
	
	
	public static void main(String[] args) {
		new EnviromentManagerApp("Demo");				//Runs the application
		
		
		
	}
	
	
}
