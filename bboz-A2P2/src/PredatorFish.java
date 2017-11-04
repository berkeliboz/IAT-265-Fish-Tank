// IAT 265 - Assignment 3.1
//Primary Programmer: Berke Boz
//
//Class: Predator Fish
//Superclass: Creature
//
//
//Assignment 3.1 Change Log
//
//	- Predator Fish class created
//
//	::.. Added Parameters,
//	-	private boolean fishHunger;
//	-	private Image fishHeadHappyImage;
//	-	private Image fishHeadSadImage;
//	-	private boolean detectionRadiusDrawn = false;
//	-	private ArrayList<Fish> detectedFishList = new ArrayList();
//	-	private int outTimer = 0;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import processing.core.PVector;

public class PredatorFish extends Creature{
	

	private boolean fishHunger;													//Will be used in assignment 3.1
	private Image fishHeadHappyImage;			
	private Image fishHeadSadImage;
	
	private boolean detectionRadiusDrawn = false;								//Visual Debugger
	
	private ArrayList<Fish> detectedFishList = new ArrayList();
	
	private int outTimer = 0;
	
	
	
	public PredatorFish() {
		super();
		maxVelocity = 5f;
		detectionRadius = 1000;
		setShapeAttributes();
		fishHunger = false;
		anchorPoint.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150));
		anchorPoint.y = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150));
		creatureColor = new Color(181,29,126);
		scaleFactor = .75f;
		initialScale = scaleFactor;
		eyeColor = creatureColor;
		detectionRadiusCircle = new Arc2D.Double(-detectionRadius/2, -detectionRadius/2, detectionRadius, detectionRadius, 0, 360,Arc2D.PIE);
		FOV = new Area(detectionRadiusCircle);
		
	}
	
	//Getters/Setters
	public ArrayList<Fish> getTargetList(){return detectedFishList;}
	public int getOutTimer() {return outTimer;}
	public void setOutTimer(int outTimer) {this.outTimer = outTimer;}
	
	
	
	@Override
	protected void setShapeAttributes() {
		super.setShapeAttributes();
		try {
			fishHeadHappyImage = ImageIO.read(new File("Images/happy.png"));
			fishHeadSadImage = ImageIO.read(new File("Images/sad.png"));
		}catch (Exception e) {
			System.out.print("fishHeadNotFound");	
		}
		
		fishHead = new Arc2D.Double(110- fishWidth -85 , 40 - fishHeight -65, 60, 60, 0, 360,Arc2D.PIE);
		fishEyes = new Arc2D.Double(140- fishWidth-85 , 50 - fishHeight-65, 20, 20, 0, 360,Arc2D.PIE);
		fishEyeBall = new Arc2D.Double(147- fishWidth-85 , 57 - fishHeight-65, 12, 13, 0, 360,Arc2D.PIE);
		fishLowerBody = new Arc2D.Double(50- fishWidth-85 , 65 - fishHeight-65, 100, 40, 0, 360,Arc2D.PIE);
		fishUpperBody = new Arc2D.Double(50- fishWidth-85 , 35 - fishHeight-65, 100, 40, 0, 360,Arc2D.PIE);
		fishLowerTail1 = new Arc2D.Double(0- fishWidth-85 , 80 - fishHeight-65, 60, 60, 45, 90,Arc2D.PIE);
		fishLowerTail2 = new Arc2D.Double(0- fishWidth -85, 80 - fishHeight-70, 60, 60, 45, 90,Arc2D.PIE);
		fishLowerTail3 = new Arc2D.Double(0- fishWidth -85, 80 - fishHeight-15-65, 60, 60, 45, 90,Arc2D.PIE);
		fishMidTail1 = new Arc2D.Double(0- fishWidth -85, 40 - fishHeight-65, 60, 60, 135, 90,Arc2D.PIE);
		fishMidTail2 = new Arc2D.Double(50- fishWidth -85, 60 - fishHeight-65, 20, 20, 0, 360,Arc2D.PIE);
		fishUpperTail1 = new Arc2D.Double(0 - fishWidth -85, 0 - fishHeight-65, 60, 60, 225, 90,Arc2D.PIE);
		fishUpperTail2 = new Arc2D.Double(0 - fishWidth -85, 0 - fishHeight+ 5-65, 60, 60, 225, 90,Arc2D.PIE);
		fishUpperTail3 = new Arc2D.Double(0 - fishWidth -85, 0 - fishHeight+ 15-65, 60, 60, 225, 90,Arc2D.PIE);
	
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
	//Justification: Every value had to shifted for accurate Area detection
	
	
	public void grow(float size) {
		if(scaleFactor >= 2)
			return;
		scaleFactor*=1.1;
		//System.out.print(size);
		scaleFactor+=size/20;
	}
	
	
	@Override
	public void shrinkIfHungry() {
		//hungrySinceFrames  modified to demonstrate sickness function faster
		if(hungrySinceFrames >= 900) {
			shrink();
			hungrySinceFrames = 0;
		}
		
		//If fish has shrunk less than its initial size, it gets sick
		if(initialScale*0.9 > (scaleFactor))
			isSick = true;
		
	}
	
	
	//Returns true if the detection radius of Predator intersects Fish
	public boolean hasDetectedFish(Fish f) {
		if(getFOVBoundary().intersects(f.getBoundary().getBounds2D())&&
				f.getBoundary().intersects(getFOVBoundary().getBounds2D()))
			return true;
		return false;
	}
	
	
	
	//Returns FOV transformed shape
	public Shape getFOVBoundary() {
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
		return af.createTransformedShape(FOV);
		
	}
	
	//Swims to target fish
	public void swimToFish(Fish f) {
		
		if(isSick) {
			maxVelocity *= 0.3f;
		}
		
		
		acceleration = PVector.sub(f.getPositionVector(), getPositionVector());
		acceleration.normalize();
		acceleration.limit(MAX_ACCELERATION);
		acceleration.mult(1);
		
		
		speedVector.add(acceleration);
		speedVector.limit(maxVelocity);
		anchorPoint.add(speedVector);
		
	}
	
	//For visual debugging. (Press Space button to toggle Detection Radius)
	public void toggleDetectionRadiusDraw() {
		detectionRadiusDrawn = !detectionRadiusDrawn;
	
	}

	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		
		//System.out.print(totalEnergy);
		//System.out.print(speedVector.mag() + " is the speed ");
		//System.out.print(this + " scale factor is:" + scaleFactor + " initial scale is:"+ initialScale + System.lineSeparator());
		
		
		AffineTransform af = new AffineTransform();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.translate((int)anchorPoint.x, (int)anchorPoint.y);
		
		if(!detectionRadiusDrawn)
			g.draw(detectionRadiusCircle);
		
		
		g.setColor(Color.black);
		g.scale(scaleFactor, scaleFactor);
		float angle = speedVector.heading();									//Point Fish to position vector
		g.rotate(angle);	
		if(speedVector.x < 0)
			g.scale(1, -1);
		//g.draw(boundaryBox);
		
		
		//Fish hunger will be implemented on next assignment
		if(isSick)
			g.drawImage(fishHeadSadImage, 110- fishWidth -85 , 40 - fishHeight -75, 70, 70, null);
		else
			g.drawImage(fishHeadHappyImage, 110- fishWidth -85 , 40 - fishHeight -75, 70, 70, null);

		
		

		g.setTransform(af);
		
		
	}
	
	
	
	
}