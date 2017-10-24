// IAT 265 - Assignment 2.1
//Primary Programmer: Berke Boz
//
//Class: fish
//Superclass: Creature
//
//
//Assignment 1.2 Change Log
//
// New Class Variables:
// 	- float MAX_ACCELERATION
//	- float maxVelocity
//	- Int fishWidth
//	- Int fishHeight
//	- Int StripeNumber
//
//	- swimToTarget(Bait) added
//		Input: Bait
//		Output: None
//		Code Dependencies:
//			- Bait Class
//				- replaceBait()
//			- Creature Class
//				- checkIfClose()
//				- acceleration
//				- speedVector
//				- anchorPoint
//				- acceleration
//
//	- scalefish(Graphics2D,int) added
//		Input: Graphics2D Object, int scalefactor
//		Output: None
//
// - getRandomColor() added
//		Input: None
//		Output: Color
//
//	- draw() got modified
//		Input: None
//		Output: None
//		- Affine Transform added
//		- scale factor added
//		- random color added
//		Code Dependencies:
//			- Creature Class
//				- anchorPoint
//				- scaleFactor
//				- speedVector 
//			- fish Class
//				- fishWidth
//				- fishHeight
//				- stripeNumber
//				
//
//		BONUS QUESTION ATTEMPTED
//
//
//Assignment 2.1 Change Log
//
//	- void swimIdle() added
//	Input: None
//	Output: None
//
//
//Assignment 2.2 Change Log
//
//	__________________________________________________________________________________________________
//									Fish Energy Model Explanation
//	__________________________________________________________________________________________________
//
//
//	-----:	A clear value to hold total energy of the fish does not exist but an energy model is present
//	-----:	Energy Model is explained in detail below,
//
//	...:::	For sake of simplicity, fish size/scale is assumed proportional to fish's weight
//	...:::  For each frame fish have been alive, fish gains +10* fish scale into hungrySinceFrames(which holds hunger value)
//	....::	If fish doesn't eat a bait for 2500/(fish scale * 10) frames, fish shrinks
//	....::	When fish consumes a bait, it grows and hungerSinceFrames parameter is cleared to zero.
//	....::	When fish shrinks to half of its starting size, it get sick, become grey and gets darker over time
//	___________________________________________________________________________________________________
//	___________________________________________________________________________________________________
//
//
//	-	boundaryBox added
//	-	hungrySinceFrames added 
//	-	New parameters to hold draw information about the bait added
//	-	extraForce vector added
//	-	randomAcceleration added
//	-	greyRGBValues added and set to 180 by default
//
//	- int getHunger() added
//	- void grow()	added
//	- void shrink() added
//	- void increaseHunger() added 
//	- void updateMaxSpeed() added
//	- int getMaxSpeed() added
//	- void getSick() added
//	- void shrinkIfHungry() added
//  - void setShapeAttributes() added
//	- Shape getBoundary() added
//	- boolean collides(Fish f) added
//
//	- void swimToTarget(Bait baitObj) modified
//		- When target is consumed, hungrySinceFrames is cleared to 0
//		- A random acceleration vector for each fish is generated
//
//


//Imported Libraries

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JPanel;

import processing.core.PVector;


public class Fish extends Creature{

	private int stripeNumber;																	//Indicates number of Stripes on fish
	private int greyRGBValues = 190;
	

	private Arc2D fishStripe1;
	private Arc2D fishStripe2;
	private Arc2D fishStripe3;
	private Arc2D fishStripe11;
	private Arc2D fishStripe21;
	private Arc2D fishStripe31;


	//Default constructor for the fish class
	public Fish() {
		super();
		JPanel panelReference = getPanel();															//Uses the panel reference to reference panel border values
		fishHeight = 70;
		fishWidth = 175;
		anchorPoint.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150))+150;
		anchorPoint.y = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150))+150;
		creatureColor = getRandomColor();

		stripeNumber = (int)(Math.random()*4);
		scaleFactor = (float) (Math.random()*(1f))+0.3f;
		
		initialScale = scaleFactor;
		extraForce = new PVector(0,0);
		
		updateMaxSpeed();																			//Update the speed of the fish reversely proportional to its size
		isSick = false;																				//Fish's are born healthy
		setShapeAttributes();																		//Draw the fish

		FOV = new Area(detectionRadiusCircle);
	
	}
	//Constructor for further control [Not used in Assignment 1&2]
	public Fish(int fishScale,Color fishColor) {
		creatureColor = fishColor;
	}
	

	public void killFish() {isAlive = false;}
	
	public void getSick() {
		//Sick animal gets grey color
		if(greyRGBValues == 190 && isSick)
			this.creatureColor = new Color(greyRGBValues, greyRGBValues, greyRGBValues);
		//Sick fish color gets darker
		if(isSick) {
			if(greyRGBValues >= 10) {
				greyRGBValues -=1;
				
					
			}
			else {
				killFish();													//Kill the fish
			}
			//Update the color
			creatureColor = new Color(greyRGBValues, greyRGBValues, greyRGBValues);	
		}
	
	}
	
	
	
	//If fish is hungry enough for a while, it shrinks. If fish shrinks to half size, it gets sick
	public void shrinkIfHungry() {
		//hungrySinceFrames  modified to demonstrate sickness function faster
		if(hungrySinceFrames >= 900) {
			shrink();
			hungrySinceFrames = 0;
		}
		
		if(initialScale/2 > (scaleFactor))
			isSick = true;
		
	}
	

	

	//Return true if both objects collide
	public boolean collides(Bait b) {
		return (this.getBoundary().intersects(b.getBoundary().getBounds2D())&&
				b.getBoundary().intersects(this.getBoundary().getBounds2D()));
	
	}
	
		
	
	//Used to create a velocity and acceleration vector between the Fish and Bait object
	public void swimToTarget(Bait baitObj){
		if(baitObj != null) {
			PVector baitRef = new PVector(baitObj.getPos().x, baitObj.getPos().y);
			
			//If Fish is far from object, creates an acceleration vector, normalizes it and adds to speedVector
			if(!checkIfClose(baitObj, this)) {
				acceleration = PVector.sub(baitRef,anchorPoint);				//Calculate Acceleration
				
				acceleration.normalize();										//Normalize Acceleration
				
				acceleration.limit(MAX_ACCELERATION);							//Limit Acceleration
				
				acceleration.setMag(1f);										//Sets magnitude of Acceleration
				
				speedVector.add(acceleration);									//Adds Acceleration to Speed Vector
				
				speedVector.limit(maxVelocity);								//Limits speed vector
				anchorPoint.add(extraForce);
				
				anchorPoint.add(speedVector);									//Adds speed vector to position vector
				extraForce = new PVector(0,0);
			}
			else {	
				EnviromentPanel.consumeTargetBait(baitObj);						//Consume bait if Fish is considered close
				grow();
				hungrySinceFrames = 0;
				randomAcceleration = PVector.random2D().normalize();
			}
				
			
		}
		
	}
	
	

	
	

	
	


	public void draw(Graphics2D g2) {
		super.draw(g2);
		
		AffineTransform af = new AffineTransform();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		

		g2.translate((int)anchorPoint.x, (int)anchorPoint.y);
		g2.scale(scaleFactor, scaleFactor);
		
		float angle = speedVector.heading();									//Point Fish to position vector
		g2.rotate(angle);														//Rotate Fish
		
		//Used to scale -1 times if object changes vector position
		if(speedVector.x < 0)
			g2.scale(1, -1);
		
		g2.setColor(Color.WHITE);
		

		//For loop to draw stripes
		for(int i = 0; i < stripeNumber+1;i++)
		{
			
			if(i == 0)
				continue;
			if(i != 3) {
				g2.drawArc(100- fishWidth + 55 - ((i-1)*20), 0 - fishHeight, 140, 140, 180, 25);
				g2.drawArc(100- fishWidth + 55 - ((i-1)*20), 0 - fishHeight, 140, 140, 180, -25);
			}
			if(i == 3) {
				g2.drawArc(100- fishWidth + 55 - ((i-1)*20), 0 - fishHeight, 140, 140, 180, 23);
				g2.drawArc(100- fishWidth + 55 - ((i-1)*20), 0 - fishHeight, 140, 140, 180, -23);
			}
			
			
			
			
		}
		
		

		
		
		
		g2.setTransform(af);
		
	}
	
	
	
}