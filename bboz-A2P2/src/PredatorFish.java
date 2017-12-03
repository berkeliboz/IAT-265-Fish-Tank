// IAT 265 - Assignment 3.2
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
//
//Assignment 3.2 Change Log
//
//	- grow() added
//	- Bug Fixed: Creature class draw wasn't inherited correctly because of the absence of required data
//		- now inherits draw() correctly from Creature class 
//

import java.awt.Color;
import java.awt.Font;
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
	
        
        
	//Default constructor
	public PredatorFish() {
		super();
                
		maxVelocity = 5f;
		detectionRadius = 750;
		setShapeAttributes();
		fishHunger = false;
		anchorPoint.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150));
		anchorPoint.y = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150));
		creatureColor = new Color(181,29,126);
		scaleFactor = .25f;
		initialScale = scaleFactor;
		eyeColor = creatureColor;
		detectionRadiusCircle = new Arc2D.Double(-detectionRadius/2, -detectionRadius/2, detectionRadius, detectionRadius, 0, 360,Arc2D.PIE);
		FOV = new Area(detectionRadiusCircle);
		
	}

    PredatorFish(float scaleFactor, Color creatureColor, float scaleFactor0, int posX, int posY, float totalEnergy, boolean sick, int detectionRadius, int energyUsage, float maxVelocity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	//Getters/Setters
	public ArrayList<Fish> getTargetList(){return detectedFishList;}
	public int getOutTimer() {return outTimer;}
	public void setOutTimer(int outTimer) {this.outTimer = outTimer;}
	
	
	
	@Override
	protected void setShapeAttributes() {
		super.setShapeAttributes();
		try {
			fishHeadHappyImage = ImageIO.read(new File("Images/happy.png"));				//Fetch icons
			fishHeadSadImage = ImageIO.read(new File("Images/sad.png"));					//Fetch icons
		}catch (Exception e) {
			System.out.print("fishHeadNotFound");	
		}
	}
	//Justification: Fish is a creature of creature class
	
	//When Predator eats a fish, it grows and gains energy according to the size of the fish
	public void grow(float size) {
		hungrySinceFrames = 0;
		totalEnergy+=size*1000;				
		//Limit grow
		if(scaleFactor >= 1.7f)
			return;
		scaleFactor*=1.1;
		scaleFactor+=size/20;
	}
	
	@Override 
	public String getClassName() {
		String non = "Predator Fish";
		return non;
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
            try {
            if(getFOVBoundary().intersects(f.getBoundary().getBounds2D())&&
				f.getBoundary().intersects(getFOVBoundary().getBounds2D()))
			return true;
		return false;
	    
            } catch (Exception e) {
                return false;
            }
            
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
		
		//If fish is sick, swims slow
		if(isSick) {
			maxVelocity *= 0.3f;
		}
		try {
			acceleration = PVector.sub(f.getPositionVector(), getPositionVector());
			acceleration.normalize();
			acceleration.mult(1);
                        acceleration.limit(MAX_ACCELERATION);
			speedVector.limit(maxVelocity);
                        speedVector.add(acceleration);
			speedVector.limit(maxVelocity);
			anchorPoint.add(speedVector);
		} catch (Exception e) {
                   
		}
	}
	
	//For visual debugging. (Press Space button to toggle Detection Radius)
	public void toggleDetectionRadiusDraw() {
		detectionRadiusDrawn = !detectionRadiusDrawn;
	}

	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		
	
		
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
		
		//If fish is sick, fish uses sad image
		if(isSick)
			g.drawImage(fishHeadSadImage, 110- fishWidth +65 , 40 - fishHeight -11, 70, 70, null);
		else
			g.drawImage(fishHeadHappyImage, 110- fishWidth +65 , 40 - fishHeight -11, 70, 70, null);

		g.setTransform(af);

		if(infoDrawn) {

			g.translate((int)anchorPoint.x, (int)anchorPoint.y);

			Color defaultColor = g.getColor();
			g.setColor(Color.black);
			Font f = new Font("Arial", Font.BOLD, 12); //NEW LINE
		    g.setFont(f); 
		    String energyInfo =String.format("%.2f", totalEnergy);					//Print out energy info
		    String SpeedInfo =String.format("%.2f", speedVector.mag());				//Print out speed info
		    
		    
		   
			g.drawString("Total Energy is:" +energyInfo, -fishHeight, -50);  
			g.drawString("Fish is hungry since:" +hungrySinceFrames + " frames", -fishHeight, -65);  
			g.drawString("Fish speed is:" + SpeedInfo, -fishHeight, -80); 
			
			g.setColor(defaultColor);
			
		}
		g.setTransform(af);
	}
	
	

	
	
}