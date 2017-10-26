// IAT 265 - Assignment 2.1
//Primary Programmer: Berke Boz
//
//Class: CustomRandomizers
//
//	Purpose of this class is for coding efficiency
//	This class is used for assigning random values
//
//
//
//
import processing.core.PVector;

public class CustomRandomizers {

	public static PVector getRandomNormalizedAccelerationVector() {
		PVector p;
		return p = new PVector((int)(Math.random()*100)-100,(int)(Math.random()*100)-100).normalize();
	}
	
	public static PVector getRandomVectorOnPanel() {
		PVector p = new PVector(Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-350))+350,
				Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-350))+350);
		 
		//System.out.println(p.x);
		//System.out.println(p.y);
		//System.out.println("-------------");
		
		
		return p;
	}
	
}
