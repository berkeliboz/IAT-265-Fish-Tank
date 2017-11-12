// IAT 265 - Assignment 2
//Primary Programmer: Berke Boz
//
//Class: Creature
//
//This is a template for further created objects
//
//Assignment 1.2 Change Log
//
// - checkIfClose(PVector x1,PVector x2) added
//		Input: PVector x1, PVector x2
//		Output: True/False
//		Code Dependencies:
//			- Creature Class:
//				-PVector x1
//				-PVector x2
//
//	New Class Variables:
//	- PVector anchorPoint, speedVector, headTipCoordinates, acceleration
//	- Float scaleFactor
//
//Assignment 2.1 Change Log
//
// - checkIfClose(Bait b,Fish fishRef) modified
//		Input: Bait b,Fish fishRef	(was PVector x1, PVector x2)
//		- Now checks the distance a lot more accurately 
//
//
//Assignment 2.2 Change Log
//
//	- checkIfClose(bait b,Fish fishRef) modified
//		- now checkIfClose(bait b,Fish fishRef) uses intersection to check 
//
//	- getBestBait(ArrayList<Bait> baitList) added
//		- traverses through baitlist and chooses best bait for each creature object according to attForce = baitSize/distance formulat
//
//
//
//
//Assignment 3.1 Change Log
//
//	- Common functions for Fish and Predator class have been moved to this file
//
//	- Getters/Setters updated
//
//	:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//	::::.....................ENERGY MODEL FUNCTIONALITY MODIFIED.......................::::
//	:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::	 
//	:::::::	- Now all fishes have Hunger Timer and Total Energy counter.			:::::::
//	::::::: - When Fish is out of energy, hunger timer starts.						:::::::
//	::::::: 	- If hunger timer is more than 900 frames, fish shrinks				:::::::
//	::::::: 	- Hunger timer is restarts from 0, but energy is not replenished.	:::::::
//	::::::: - Energy is increases only if when Fish consumes another fish or bait	:::::::
//	:::::::		- Hunger timer is set to zero when fish is fed						:::::::
//	::::::: - If fish shrinks to half of its size, it gets sick. 					:::::::
//	::::::: 	- No recovery condition is implemented.								:::::::
//	:::::::		- For Predator Fish, sickness threshold is much lower.				:::::::
//	:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//	:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//Imported Libraries
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.print.attribute.ResolutionSyntax;
import javax.swing.JPanel;
import processing.core.PVector;

public class Creature {

	//Static max values setup
	protected float MAX_ACCELERATION = 0.1f; 
	protected float MAX_VELOCITY= 10f;
	protected float maxVelocity = 10f;
	
	
	protected int greyRGBValues = 190;
	
	protected boolean infoDrawn = true;
	
	//Represents the area 
	protected Area boundaryBox;
	protected Area FOV;
	
	protected float totalEnergy;
	
	//Represents hunger value for the fish
	protected int hungrySinceFrames = 0;
	
	protected Color eyeColor = Color.WHITE;
	 
	//Class parameters 
	protected PVector anchorPoint,speedVector,headTipCoordinates;							//Anchor Point Holds Default Position of create
	protected PVector acceleration;															//acceleration is used to store acceleration vector
	protected float scaleFactor;															//Used to control the scaling of the creature
	protected Color creatureColor;															//Main color of the object
	protected boolean isSick = false;
	protected boolean isAlive = true;
	
	protected int fishWidth;																		//The main scale factor for fish object, also fish's oval width
	protected int fishHeight;																		//fish's oval height
	
	protected Arc2D fishHead;
	protected Arc2D fishEyes;
	protected Arc2D fishEyeBall;
	protected Arc2D fishLowerBody;
	protected Arc2D fishUpperBody;
	protected Arc2D fishLowerTail1;
	protected Arc2D fishLowerTail2;
	protected Arc2D fishLowerTail3;
	protected Arc2D fishMidTail1;
	protected Arc2D fishMidTail2;
	protected Arc2D fishUpperTail1;
	protected Arc2D fishUpperTail2;
	protected Arc2D fishUpperTail3;

	protected Arc2D detectionRadiusCircle;
	
	protected boolean hasEnergy;
	protected int detectionRadius = 550;

	private boolean isChoosen = false;
	
	protected boolean isIn = true;
	
	public void setIsIn(boolean isIn) {this.isIn = isIn;}
	public boolean getIsIn() {return isIn;}
	
	public PVector getAnchorPts() {return anchorPoint;}
	
	//Getter functions
	public int getXPos() {return (int) anchorPoint.x;}											
	public int getYPos() {return (int) anchorPoint.y;}
	public Color getColor() {return creatureColor;}
	public static JPanel getPanel() {return EnviromentPanel.getPanel();}
	public PVector getPositionVector() {return anchorPoint;}
	public boolean getLifeStatus() {return isAlive;}
	
	public void sickenFish() {isSick = true;}
	
	public boolean getSicknessStatus() {return isSick;}
	
	//Default constructor for the default creature type object								[These parameters are very likely to be modified]
	public Creature() {
		hasEnergy = true;
		fishHeight = 70;
		fishWidth = 175;
		totalEnergy = 1000f;
		randomAcceleration = PVector.random2D().normalize();										//Fish are born with a random acceleration vector
		anchorPoint = new PVector(200, 200);
		scaleFactor = (int)(Math.random()*10);
		creatureColor = Color.BLUE;
		speedVector = new PVector(10,10);
		acceleration = new PVector(1,1);
		extraForce = new PVector(1,1);
	}
	
	//Getter functions
	protected float getEnergy() {return totalEnergy;}
	protected int getWidth() {return fishWidth;}
	protected int getHeight() {return fishHeight;}
	protected PVector getSpeedVector() {return speedVector;}
	protected PVector getAccelerationVector() {return acceleration;}
	
	protected void setIsChoosenFalse() {isChoosen = false;}
	protected void setIsChoosenTrue() {isChoosen = true;}
	
	
	//This extra force vector is added to position vector of the fish when fish collides
	protected PVector extraForce;
	protected PVector randomAcceleration;
	
	protected float initialScale;

	
	//Setter Functions
	
	protected void setEnergy(float totalEnergy) {this.totalEnergy = totalEnergy;}
	protected void setSpeedVector(PVector speedVector) {this.speedVector = speedVector;}
	protected void setAccelerationVector(PVector acceleration) {this.acceleration = acceleration;}
	public void setExtraForce(PVector extraForce) {this.extraForce = extraForce;}
	public void setHungrySinceFrames(int hungrySinceFrames) {this.hungrySinceFrames = hungrySinceFrames;}
	public void setAnchorPoint(PVector anchorPoint) {this.anchorPoint = anchorPoint;}
	
	//Hunger level related functions
	protected int getHunger() {return hungrySinceFrames;}
	protected void grow() {scaleFactor *=1.1;}
	protected void shrink() {scaleFactor *=0.9;}
	
	
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
				System.out.print("IS DEAD");
				System.out.print(isAlive);
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
		
		//If fish has shrunk less than its initial size, it gets sick
		if(initialScale/2 > (scaleFactor))
			isSick = true;
		
	}
	
	
	public void useEnergy() {
		if(totalEnergy >=5) {
			totalEnergy-=10*scaleFactor;
			hasEnergy = true;
		}
		else {
			hungrySinceFrames+=10*scaleFactor;
			hasEnergy = false;		
		}
	}
	//Justification: Using energy is a shared functionality between Predator Fish and Non-Predator Fish
	

	
	public void swimToMiddle() {
		acceleration = PVector.sub(EnviromentPanel.middlePoint(), getPositionVector());
		acceleration.normalize();
		acceleration.limit(MAX_ACCELERATION);
		acceleration.setMag(1f);
		
		speedVector.add(acceleration);
		speedVector.limit(maxVelocity);
		anchorPoint.add(speedVector);
	}
	//Justification: Swimming to middle when out of the screen is a shared functionality between Predator Fish and Non-Predator Fish
	
	//Return true if both objects collide
	protected boolean collides(Fish f) {
		return (this.getBoundary().intersects(f.getBoundary().getBounds2D())&&
				f.getBoundary().intersects(this.getBoundary().getBounds2D()));
	}
	//Justification: This function is used by both Predator Fish and normal fish. Predator fish uses this funtion to eat fish while normal fish uses this function to collide each other

	//Draw the fish
	protected void setShapeAttributes() {
		fishHead = new Arc2D.Double(110- fishWidth + 55, 40 - fishHeight, 60, 60, 0, 360,Arc2D.PIE);
		fishEyes = new Arc2D.Double(140- fishWidth + 55, 50 - fishHeight, 20, 20, 0, 360,Arc2D.PIE);
		fishEyeBall = new Arc2D.Double(147- fishWidth + 55, 57 - fishHeight, 12, 13, 0, 360,Arc2D.PIE);
		fishLowerBody = new Arc2D.Double(50- fishWidth + 55, 65 - fishHeight, 100, 40, 0, 360,Arc2D.PIE);
		fishUpperBody = new Arc2D.Double(50- fishWidth + 55, 35 - fishHeight, 100, 40, 0, 360,Arc2D.PIE);
		fishLowerTail1 = new Arc2D.Double(0- fishWidth + 55, 80 - fishHeight, 60, 60, 45, 90,Arc2D.PIE);
		fishLowerTail2 = new Arc2D.Double(0- fishWidth + 55, 80 - fishHeight-5, 60, 60, 45, 90,Arc2D.PIE);
		fishLowerTail3 = new Arc2D.Double(0- fishWidth + 55, 80 - fishHeight-15, 60, 60, 45, 90,Arc2D.PIE);
		fishMidTail1 = new Arc2D.Double(0- fishWidth + 55, 40 - fishHeight, 60, 60, 135, 90,Arc2D.PIE);
		fishMidTail2 = new Arc2D.Double(50- fishWidth + 55, 60 - fishHeight, 20, 20, 0, 360,Arc2D.PIE);
		fishUpperTail1 = new Arc2D.Double(0 - fishWidth + 55, 0 - fishHeight, 60, 60, 225, 90,Arc2D.PIE);
		fishUpperTail2 = new Arc2D.Double(0 - fishWidth + 55, 0 - fishHeight+ 5, 60, 60, 225, 90,Arc2D.PIE);
		fishUpperTail3 = new Arc2D.Double(0 - fishWidth + 55, 0 - fishHeight+ 15, 60, 60, 225, 90,Arc2D.PIE);
		
		detectionRadiusCircle = new Arc2D.Double(-detectionRadius/2, -detectionRadius/2, detectionRadius, detectionRadius, 0, 360,Arc2D.PIE);
		
		
		//Added the area of each part
		boundaryBox = new Area(fishHead);
		boundaryBox.add(new Area(fishEyes));
		boundaryBox.add(new Area(fishEyeBall));
		boundaryBox.add(new Area(fishLowerBody));
		boundaryBox.add(new Area(fishUpperBody));
		boundaryBox.add(new Area(fishLowerTail1));
		boundaryBox.add(new Area(fishLowerTail2));
		boundaryBox.add(new Area(fishLowerTail3));
		boundaryBox.add(new Area(fishMidTail1));
		boundaryBox.add(new Area(fishMidTail2));
		boundaryBox.add(new Area(fishUpperTail1));
		boundaryBox.add(new Area(fishUpperTail2));
		boundaryBox.add(new Area(fishUpperTail3));
	}
	
	//Update Max Speed
	protected void updateMaxSpeed() {maxVelocity = getMaxSpeed();}
	
	
	//Setup/Get max speed of the fish
	protected int getMaxSpeed() {return (int) (5/scaleFactor);}
	
	//Generates random Color for Fish Only
	public Color getRandomColor() {
		int a = (int)(Math.random()*3);
		switch(a) {
		case 0:
			return(new Color(251,188,111));						//Light Orange
		case 1:
			return(new Color(255, 140, 0));						//Dark Orange
		case 2: 
			return(new Color(221,222,102));						//Greener Orange (I really dont know)
		default:
			return(new Color(255, 140, 0));						//Dark Orange		
		}
	}
	
	//Gets last acceleration vector and adds in on speed vector
	public void swimIdle() {
		randomAcceleration.limit(MAX_ACCELERATION).mult(2);
		speedVector.add(randomAcceleration);
		speedVector.limit(maxVelocity);
		anchorPoint.add(extraForce);
		anchorPoint.add(speedVector);									//Adds speed vector to position vector
		extraForce = new PVector(0,0);		
	}
	//Justification: This function is used by both Predator Fish and normal fish.

	
	//Checks boundaries for Fish object
	public static void checkBoundaries(Creature f) {
		getPanel();

		if((f.anchorPoint.x >= getPanel().getWidth() - f.fishWidth/4)||f.anchorPoint.x <= 0 + f.fishWidth||
				f.anchorPoint.y >= getPanel().getHeight() - f.fishHeight/4||f.anchorPoint.y <= 0 + f.fishHeight) {
			f.swimToMiddle();
			f.setIsIn(false);
			
		}
		//Justification: This function is used by both Predator Fish and normal fish.			
		

		
	}
	
	public void toggleDrawInfo() {
		infoDrawn = !infoDrawn;
	}
	
	
	//Return shape value for intersection check
	protected Shape getBoundary() {
		AffineTransform af = new AffineTransform();
		//Translate the Affine transform
		af.translate((int)anchorPoint.x, (int)anchorPoint.y);
		//Scale the Affine transform
		af.scale(scaleFactor, scaleFactor);		
		//Point the Affine transform to bait 
		float angle = speedVector.heading();									
		af.rotate(angle);			
		if(speedVector.x < 0)
			af.scale(1, -1);
		//Return Affine Transform for intersection check
		return af.createTransformedShape(boundaryBox);
	}
	
	

	public void highlightFish(Graphics2D g2) {
		Color defC = g2.getColor();
		g2.setColor(Color.GREEN);
		Stroke def = g2.getStroke();
		g2.setStroke(new BasicStroke(10));
		g2.draw(boundaryBox);
		g2.setStroke(def);
		g2.setColor(defC);
	}
	
	public void draw(Graphics2D g2) {
		
		//Setup AntiAliasing and Affine Transform
		AffineTransform af = g2.getTransform();	
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	
	
		
		Color darkOrange = new Color(255, 140, 0);
		Stroke defaultStroke = g2.getStroke();
		
		

		g2.setColor(darkOrange);
		
		g2.translate((int)anchorPoint.x, (int)anchorPoint.y);
		
		
		
		g2.scale(scaleFactor, scaleFactor);
		
		float angle = speedVector.heading();									//Point Fish to position vector
		g2.rotate(angle);														//Rotate Fish
		
		//Used to scale -1 times if object changes vector position
		if(speedVector.x < 0)
			g2.scale(1, -1);

		g2.setColor(creatureColor);
		//Upper Tail
		
		
		if(isChoosen)
			highlightFish(g2);
		
		g2.fill(fishUpperTail1);
		g2.setStroke(new BasicStroke(10));
		g2.fill(fishUpperTail2);
		g2.fill(fishUpperTail3);
		
		g2.setStroke(defaultStroke);
		//Mid Tail
		
		g2.fill(fishMidTail1);
		g2.fill(fishMidTail2);
		
		//Lower Tail
		g2.setStroke(new BasicStroke(10));
		g2.fill(fishLowerTail1);
		g2.fill(fishLowerTail2);
		g2.fill(fishLowerTail3);
		
		g2.setStroke(defaultStroke);
		
		
		//Upper Body
		g2.fill(fishUpperBody);
		
		//Lower Body
		g2.fill(fishLowerBody);
		
		//Stripe 1
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(10));
		

		
		
		g2.setColor(creatureColor);
		
		
		
		//Head
		
		g2.fill(fishHead);
		
		//Eyes
		
		g2.setColor(eyeColor);
		g2.fill(fishEyes);
		
		//Eyeball
		
		g2.setColor(Color.BLACK);
		
		g2.fill(fishEyeBall);
		
		g2.setColor(Color.pink);
		
	
		
		
		g2.setTransform(af);
		
		
		
		//Visual Debuggers
		
		//g2.setColor(Color.magenta);
		//g2.drawLine((int)anchorPoint.x, (int)anchorPoint.y, 0, 0);
		
		//g2.draw(getBoundary().getBounds2D());
		
		//g2.drawLine((int)anchorPoint.x, (int)anchorPoint.y,
		//		(int)anchorPoint.x+ (int)(speedVector.x*100), (int)anchorPoint.y + (int)(speedVector.y*100));
		
		//g2.setColor(Color.black);
		//g2.drawLine((int)anchorPoint.x, (int)anchorPoint.y,
		//		(int)anchorPoint.x+ (int)(acceleration.x*100), (int)anchorPoint.y + (int)(acceleration.y*100));
	}
	
	//Getters/Setters
	public float getScaleFactor() {return scaleFactor;}
	public void setScaleFactor(float scaleFactor) {this.scaleFactor = scaleFactor;}
	
	//This function checks if two vectors are intersecting to each other 
	public boolean checkIfClose(Bait b,Creature fishRef) {
		PVector distance = new PVector();															//Create a new vector to calculate the distance
		PVector.sub(b.getPos(), fishRef.getPositionVector(), distance);								//Calculates the distance between vectors as a vector
		if(fishRef.getBoundary().intersects(b.getBoundary().getBounds2D()) && 
				b.getBoundary().intersects(fishRef.getBoundary().getBounds2D()))
			return true;
		return false;
	}
	//Justification: This function is used by normal fish for this assignment only. But however, this function has been kept on creature class for future functionality for predator class
	

	
	
	public String getClassName() {
		String non = "N/A";
		return non;
	}
	
	public Bait getBestBait(ArrayList<Bait> baitList) {

		if(baitList.isEmpty()) {System.out.println("No bait found"); return null;}					//Return null if no bait is present
		
		PVector distance = new PVector();															//Setup the distance vector
		double baitAttractPts = 0;																	//Setup the attaction pts
		Bait bestBait = new Bait();																	//Setup the bait
		for(Bait b:baitList) {
			double loopBaitAttPts = 0;
			PVector.sub(b.getPos(),anchorPoint,distance);											//Distance vector = Bait pos vector - creature pos vector 
			loopBaitAttPts = b.getBaitSize()/distance.mag();										//bait attractiveness = size/distance 
			if(loopBaitAttPts > baitAttractPts) {													//Compare to get the the bait with highest points
				baitAttractPts = loopBaitAttPts;
				bestBait = b;
			}
		
		}
		return bestBait;
	}
	//Justification: This function is used by normal fish for this assignment only. But however, this function has been kept on creature class for future functionality for predator class

	
	
}











