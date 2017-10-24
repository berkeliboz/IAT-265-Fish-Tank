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
	

	private boolean fishHunger;
	private Image fishHeadHappyImage;
	private Image fishHeadSadImage;
	
	private ArrayList<Fish> detectedFishList = new ArrayList();
	
	public PredatorFish() {
		super();
		maxVelocity = 5f;
		detectionRadius = 1000;
		setShapeAttributes();
		fishHunger = false;
		anchorPoint.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150));
		anchorPoint.y = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150));
		creatureColor = new Color(181,29,126);
		scaleFactor = 1f;
		eyeColor = creatureColor;
		detectionRadiusCircle = new Arc2D.Double(-detectionRadius/2, -detectionRadius/2, detectionRadius, detectionRadius, 0, 360,Arc2D.PIE);
		FOV = new Area(detectionRadiusCircle);
		
	}
	
	public ArrayList<Fish> getTargetList(){return detectedFishList;}
	
	
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
	
	public boolean hasTouchedFish(Fish f) {
		if(this.getBoundary().intersects(f.getBoundary().getBounds2D())&&
				f.getBoundary().intersects(this.getBoundary().getBounds2D()))
			return true;
		return false;
	}
	
	
	public boolean hasDetectedFish(Fish f) {
		if(getFOVBoundary().intersects(f.getBoundary().getBounds2D())&&
				f.getBoundary().intersects(getFOVBoundary().getBounds2D()))
			return true;
		return false;
	}
	
	
	
	
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
	
	
	public void swimToFish(Fish f) {
		acceleration = PVector.sub(f.getPositionVector(), getPositionVector());
		acceleration.normalize();
		acceleration.limit(MAX_ACCELERATION);
		acceleration.mult(1);
		
		
		speedVector.add(acceleration);
		speedVector.limit(maxVelocity);
		anchorPoint.add(speedVector);
		
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		
		
		
		
		AffineTransform af = new AffineTransform();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		

	
		g.translate((int)anchorPoint.x, (int)anchorPoint.y);
		
		
		g.draw(detectionRadiusCircle);
		
		
		g.setColor(Color.black);
		
		
		g.scale(scaleFactor, scaleFactor);
		
		float angle = speedVector.heading();									//Point Fish to position vector
		g.rotate(angle);	
		
		if(speedVector.x < 0)
			g.scale(1, -1);
				
		
		//g.draw(boundaryBox);
		
		if(fishHunger)
			g.drawImage(fishHeadSadImage, 110- fishWidth -85 , 40 - fishHeight -75, 70, 70, null);
		else
			g.drawImage(fishHeadHappyImage, 110- fishWidth -85 , 40 - fishHeight -75, 70, 70, null);

		
		//g.fill(detectionRadiusCircle);
		
		

		g.setTransform(af);
		
		
	}
	
	
	
	
}