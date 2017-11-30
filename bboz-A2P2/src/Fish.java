// IAT 265 - Assignment 3.2
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
//Assignment 3.1 Change Log
//
//	- Carried parameters

//	::.. To Creature class
//	-	protected PVector acceleration;														
//	-	protected float scaleFactor;												
//	-	protected Color creatureColor;															
//	-	protected boolean isSick = false;
//	-	protected boolean isAlive = true;
//	-	protected Arc2D fishHead;
//	-	protected Arc2D fishEyes;
//	-	protected Arc2D fishEyeBall;
//	-	protected Arc2D fishLowerBody;
//	-	protected Arc2D fishUpperBody;
//	-	protected Arc2D fishLowerTail1;
//	-	protected Arc2D fishLowerTail2;
//	-	protected Arc2D fishLowerTail3;
//	-	protected Arc2D fishMidTail1;
//	-	protected Arc2D fishMidTail2;
//	-	protected Arc2D fishUpperTail1;
//	-	protected Arc2D fishUpperTail2;
//	-	protected Arc2D fishUpperTail3;
//	-	protected Arc2D detectionRadiusCircle;
//	-	protected boolean hasEnergy;
//	-	protected int detectionRadius 
//	-	protected boolean isIn
//
//	- Carried linked setters/getters into Creature class	
//
//
//
//Assignment 3.2 Change Log
//
//	- isEscaping: Boolean added
//
//	- New Getters and Setters added
//	- toggleFOV() added
//	- swimToEscape() added
//
//	- Draw info added
//
//Imported Libraries

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import processing.core.PVector;


public class Fish extends Creature{

	private int stripeNumber;																	//Indicates number of Stripes on fish
	private boolean isEscaping;
	private boolean FOVDrawn = false;


	
	protected Arc2D FOVCircle;
	
         public Fish(float scaleFactor, Color creatureColor,int stripeNumber, int posX,int posY, float totalEnergy, boolean isSick, int detectionRadius,int energyUsage, float maxVelocity){
            super();
            this.maxVelocity = maxVelocity;
            this.energyUsageOverTime = energyUsage;
            fishHeight = 70;
            fishWidth = 175;	
            isEscaping = false;
            this.detectionRadius = detectionRadius;
            FOVCircle = new Arc2D.Double(-detectionRadius/2, -detectionRadius/2, detectionRadius, detectionRadius, 0, 360,Arc2D.PIE);
            FOV = new Area(FOVCircle);
            anchorPoint.x = posX;
            anchorPoint.y = posY;
            this.stripeNumber = stripeNumber;
            this.creatureColor = creatureColor;
            this.scaleFactor = scaleFactor;
            initialScale = scaleFactor;	
            extraForce = new PVector(0,0);
		
            updateMaxSpeed();																			//Update the speed of the fish reversely proportional to its size
            this.isSick = isSick;																			//Fish's are born healthy
            setShapeAttributes();																		//Draw the fish

            FOV = new Area(detectionRadiusCircle);
            
        }
        
        
       
        
        
        
        
	//Default constructor for the fish class
	public Fish() {
		super();																					//Call default constructor from upper class
		fishHeight = 70;
		fishWidth = 175;
		
		isEscaping = false;
		anchorPoint.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150))+150;		//Generate coordinates random
		anchorPoint.y = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150))+150;	//Generate coordinates random
		creatureColor = getRandomColor();

		FOVCircle = new Arc2D.Double(-detectionRadius/2, -detectionRadius/2, detectionRadius, detectionRadius, 0, 360,Arc2D.PIE);
		FOV = new Area(FOVCircle);
		
		stripeNumber = (int)(Math.random()*4);
		scaleFactor = (float) (Math.random()*(0.5f))+0.3f;
		
		initialScale = scaleFactor;																	//Previous scale needed for sickness feature
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
	
	//When fish eats bait, fish gains energy based on size
	public void gainEnergy(Bait b) {
		totalEnergy+= b.getBaitSize();
	}
	
	public void setIsEscaping(boolean isEscaping) {this.isEscaping = isEscaping;}
	public boolean isEscaping() {return isEscaping;}
	

	public void toggleFOV() {
		FOVDrawn = false;
	}
	
	@Override
	public void useEnergy() {
		if(totalEnergy >=5) {
			totalEnergy-=10*scaleFactor*maxVelocity/10f;
			hasEnergy = true;
		}
		else {
			hungrySinceFrames+=10*scaleFactor;
			hasEnergy = false;		
		}
	}

	@Override 
	public String getClassName() {
		String non = "Fish";
		return non;
	}
	
	//Fish swims to the other direction of Predator fish
	public void swimToEscape(PredatorFish fishRef) {
		if(isEscaping) {
			
			//Draw FOV
			//FOVDrawn = true;
			
			float sumVectorLen = acceleration.add(fishRef.acceleration).magSq();
			float absoluteSumVectorLen = acceleration.magSq()+fishRef.acceleration.magSq();
			
			//Compare absolute sum of vectors to normal sum to determine the acceleration direction
			if(absoluteSumVectorLen > sumVectorLen) {
				this.acceleration = fishRef.getAccelerationVector().mult(2);
			}else {
				this.acceleration = fishRef.getAccelerationVector().mult(-2);
			}
			
			acceleration.normalize();
			acceleration.limit(MAX_ACCELERATION*2);
			speedVector.add(acceleration);
			maxVelocity = MAX_VELOCITY*2;
			speedVector.limit(maxVelocity);
			anchorPoint.add(speedVector);
		}
		
	}
	
	//Returns true if Fish detects a predator fish
	public boolean detects(PredatorFish fishRef) {
	return (this.getFOVBoundary().intersects(fishRef.getBoundary().getBounds2D())&&
				fishRef.getBoundary().intersects(this.getFOVBoundary().getBounds2D()));
		
	}

	

	//Return true if both objects collide
	public boolean collides(Bait b) {
		return (this.getBoundary().intersects(b.getBoundary().getBounds2D())&&
				b.getBoundary().intersects(this.getBoundary().getBounds2D()));
	}
	
	protected Shape getFOVBoundary() {
		AffineTransform af = new AffineTransform();
		af.translate((int)anchorPoint.x, (int)anchorPoint.y);
			
		return af.createTransformedShape(FOV);
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
				
				acceleration.setMag(10f);										//Sets magnitude of Acceleration
				
				speedVector.add(acceleration);									//Adds Acceleration to Speed Vector
				speedVector.setMag(10f);
				speedVector.limit(maxVelocity);								//Limits speed vector
				anchorPoint.add(extraForce);
				
				anchorPoint.add(speedVector);									//Adds speed vector to position vector
				extraForce = new PVector(0,0);
			}
			else {	
				gainEnergy(baitObj);
				EnviromentPanel.consumeTargetBait(baitObj);						//Consume bait if Fish is considered close
				grow();
				
				hungrySinceFrames = 0;
				randomAcceleration = PVector.random2D().normalize();
			}
				
			
		}
		
	}

	
@Override
	public void draw(Graphics2D g2) {
		super.draw(g2);
		
		AffineTransform af = new AffineTransform();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		

		g2.translate((int)anchorPoint.x, (int)anchorPoint.y);
		
		
		float angle = speedVector.heading();									//Point Fish to position vector
		g2.rotate(angle);														//Rotate Fish
		
		if(FOVDrawn)
			g2.draw(FOVCircle);
		
		
		g2.scale(scaleFactor, scaleFactor);
		
		
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
		
		if(infoDrawn) {
		
			AffineTransform at = new AffineTransform();
			
			Color defaultColor = g2.getColor();
			g2.setColor(Color.BLACK);
			g2.translate((int)anchorPoint.x, (int)anchorPoint.y);
			
			Font f = new Font("Arial", Font.BOLD, 12); //NEW LINE
		    g2.setFont(f); //NEW LINE
		    String energyInfo =String.format("%.2f", totalEnergy);
		    String SpeedInfo =String.format("%.2f", speedVector.mag());
		    
		    
		    if(hungrySinceFrames <= 15)hungrySinceFrames = 0;
			g2.drawString("Total Energy is:" +energyInfo, -fishHeight, -50);  //-Float.toString(totalEnergy).length()/2
			g2.drawString("Fish is hungry since:" +hungrySinceFrames + " frames", -fishHeight, -65);  //-Float.toString(totalEnergy).length()/2
			g2.drawString("Fish speed is:" + SpeedInfo, -fishHeight, -80);  //-Float.toString(totalEnergy).length()/2
			
		
			
			g2.setColor(defaultColor);
			
			
			
			
			}
		g2.setTransform(af);	
	}
	
	
	
	
	
}