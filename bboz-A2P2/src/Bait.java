// IAT 265 - Assignment 3.2
//Primary Programmer: Berke Boz
//
//Class: Bait
//SuperClass: -
//
//
//Assignment 1.2 Change Log
//
// - replaceBait() function added
//		Input: None
//		Output: PVector
//		Code Dependencies:
//			- Bait Class 
//				- Pvector pos
//
// - draw() modified
//		Input: None
//		Output: None
//		Code Dependencies:
//			- Bait Class
// 				- int sinCurveSpeed
//				- int sinValueRadians
//				- double sinValueRadians
//				- float floatingRange
//Assignment 2.1 Change Log
//
//												Bonus Mark Attempted
//
//							 - Hold the mouse button while clicking the bait object to enlarge
//
// highlightBait() function added for Visual Debugging
//
//
// - enlargeFood() function added
//		Input: none
//		Output: none
//
//Assignment 2.2 Change Log
//
//
//	- Area type baitBoundaryBox added
//	- Polygon type innerPoly and outerPoly added
//
//	- Getters and Setters added for baitSize:
//
//		- int getBaitSize() returns the size of bait object as integer
//		- void increaseBaitSize() increases the bait size by 100
//		- void decreaseBaitSize() decreases the bait size by 100
//
//	- setShapeAttributes() added
//		- Sets up outerPoly, innerPoly and the area of the Boundary Box
//
//	- getBoundary() added
//		- Makes the all the object transformations to return bait's boundary box
//
//
//
//Assignment 3.2 Change Log
//
//	- 
//
//
//
//
//Imported Libraries
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.sql.Time;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;

import javax.security.auth.x500.X500Principal;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

import processing.core.PVector;

import java.awt.BasicStroke;
import java.awt.Color;


//Comments for Assignment 2-1 is not added on video recording


//Bait is a class to setup Bait object
public class Bait {

	//pos represents position of the object
	private PVector pos;
	//sinCurveSpeed is a value to control Sinus Curve that is used to give floating effect on the Bait object
	private int sinCurveSpeed;
	//sinValueRadians is a value to increase Sinus value that is used to give floating effect on the Bait object
	private double sinValueRadians;
	//floatingRange is used to control Sinus curve range
	private float floatingRange = 5;
	
	//outerPoly is used to draw outer triangle
	private Polygon outerPoly;
	//outerPoly is used to draw inner triangle
	private Polygon innerPoly;
	
	//baitSize shows the size of the bait
	private int baitSize = 100;
	
	//Width of the bait
	private int width = 40;
	//Height of the bait
	private int height = 40;
	//Scale of the bait
	private float scale = 1F;
	//Selected is used for visual debugging
	private boolean selected = false;
	//baitBoundaryBox is the area of the bait object
	private Area baitBoundaryBox;
	
	//Default Constructor 
	public Bait() {
		pos = new PVector(250,250);
		setShapeAttributes();
		baitSize = 250;
		scale = baitSize/100;
	}

	//Bait class Constructor 
	public Bait(PVector pos) {
		this.pos = pos;
		setShapeAttributes();
		baitSize = (int)(Math.random()*100)+100;
		
		scale = ((float)baitSize)/100;
		
	}
	
	
	
	
	
	
	//Getters/Setters for baitSize
	public int getBaitSize() {return baitSize;}
	public void increaseBaitSize() {baitSize+=100;}
	public void decreaseBaitSize() {baitSize-=100;}
	
	//Setup object visually
	public void setShapeAttributes() {
		
		int[] triangle1X = { 0 ,-width/2,width/2};
		int[] triangle1Y = {-height/2,height/2,height/2};
		outerPoly = new Polygon(triangle1X, triangle1Y, triangle1Y.length);
		
		int[] triangle2X = {0,-width/4,width/4,0};
		int[] triangle2Y = {0,-height/2,- height/2,0};
		
		innerPoly = new Polygon(triangle2X, triangle2Y, triangle2Y.length);
		
		baitBoundaryBox = new Area(outerPoly);
		
		
	}
	//Returns the boundary as a shape object
	public Shape getBoundary() {
		AffineTransform af = new AffineTransform();
		af.translate((int) (pos.x), (int) (pos.y+floatingRange * Math.sin(sinValueRadians)));
		af.scale(scale, scale);
		return af.createTransformedShape(baitBoundaryBox);
	}
	
	//Generates a random PVector point on the Panel.
	public PVector replaceBait() {
		int previousPosY =  (int) this.pos.y;															//Previous Y coordinate is stored
		int newPosY = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150))+150;
		
		
		while(Math.abs((previousPosY - newPosY)) < 150)													//This loop avoids bait respawning close to previous position of the bait
			newPosY = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150))+150;
			
		//Sets new positions
		this.pos.y = newPosY;																			
		this.pos.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150))+150;

		
		return pos;
	}
	

	
	//Getters
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public boolean getSelected() {return selected;}
	public PVector getPos() {return pos;}									
	//Setters
	public void setPos(PVector pos) {this.pos = pos;}						//Manual Setter for Manual Testing
	public void setPos(int x,int y) {this.pos.x = x;this.pos.y = y;}		//Manual Setter for Manual Testing

	//Used for visual debugging
	public void highlightBait(Graphics2D g) {
		if(selected) {
			g.setStroke(new BasicStroke(5));
			g.drawRect(-width/2, -height/2, width, height+3);
			g.setStroke(new BasicStroke(1));
		}
	}
	
	//For Manual Modification
	public void select() {selected = true;}
	public void deselect() {selected = false;}
	public float getScale() {return scale;}
	
	//Enlarges Bait Object instance
	public void enlargeFood() {
		scale *=1.1F;
		increaseBaitSize();
	}
	
	
	//Draws the coordinates of the bait object
	public void draw(Graphics2D g) {
		
	
		AffineTransform af = g.getTransform();								//Setup AffineTransform
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,					//Setup AntiAliasing
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		sinCurveSpeed+=5;													//Increase sin curve by 5 per frame
		sinValueRadians = Math.toRadians(sinCurveSpeed);					//Converts sin curve value to Radians
		
		g.translate((int) (pos.x), (int) (pos.y+floatingRange * Math.sin(sinValueRadians)));	//Translates the bait to its position
		g.scale(scale, scale);												//Change the scale
		
		//Debug this to highlight the bait
//		highlightBait(g);
		g.setStroke(new BasicStroke(1));
		g.setColor(Color.red);

		g.fill(outerPoly);
		//Triangle 2 Points													//Draws inner triangle
		g.setColor(Color.yellow);
		g.rotate(Math.PI);
	
		g.fill(innerPoly);

	
		
		g.setTransform(af);													//Resets the transform

		//Visual Debuggers for Bait Object
		//g.setColor(Color.magenta);
		//g.setStroke(new BasicStroke(5));
		//g.drawLine((int)pos.x, (int)pos.y, 0, 0);
		
		}
		
		

	
	
	
}

