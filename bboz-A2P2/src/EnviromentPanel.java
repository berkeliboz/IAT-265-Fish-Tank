// IAT 265 - Assignment 2.1
//Primary Programmer: Berke Boz
//
//Class: EnviromentPanel
//Super Class: JPanel
//
//
//Assignment 1.2 Change Log
//
//
//	- PVector middlePoint() was added
//		- Input: None	
//		- Output: PVector
//		- Code Dependencies:
//			- EnviromentPanel Class
//				- JPanel panelTest
//
//	- The statement used to check if the Fish was inside the panel is discarded
//		since fish is guaranteed to never leave the panel borders. 
//		Fish velocity, acceleration and Bait spawn borders are adjusted to avoid this situation
//
//
//Assignment 2.1 Change Log
//
// - ArrayList<Bait> baitList added
// - ArrayList<Fish> fishList added
// - Manual timer that works on delta frames
//
// - PVector middlePoint() added
//		- Input: None
//		- Output: PVector
//
// - Bait checkIfOccupied(MouseEvent e) added
//		- Input: MouseEvent
//		- Output: Bait|null ptr
//
//	- void createBait(MouseEvent e) added
//		- Input: MouseEvent
//		- Output: None
//
//	- void selectBait(MouseEvent e) added
//		- Input: MouseEvent
//		- Output: None
//
//	- void consumeTargetBait(Bait b) added
//		- Input: Bait obj
//		- Output: None
//
//	- void spawnBait() added
//		- Input: None
//		- Output: None
//
//
//	- Bait getClosestBait(Fish fishReference) added
//		- Input: Fish fishReference
//		- Output: Bait object
//
//	- void actionPerformed(ActionEvent e) modified
//		- Now loops through array lists
//		- Now spawns bait object according to frame over time
//
// - New Class Extention added for Mouse Adapter
//
// - addMouseListener(new MyMouseAdapter()) extended for hold functionality				(Bonus Mark Code)
// 
//
//Assignment 2.1 Change Log
//
// - actionPerformed(ActionEvent e) modified
//
//
//
//Imported Libraries
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.security.auth.x500.X500Principal;
import javax.swing.JPanel;
import javax.swing.Timer;

import processing.core.PVector;

//This class implements main panel for the application
public class EnviromentPanel extends JPanel implements ActionListener,KeyListener {

	private static int FISH_NUMBER = 5;
	private static int PREDATOR_FISH_NUMBER = 2;
	
	
			
	private static ArrayList<PredatorFish> predatorList = new ArrayList<PredatorFish>();				
	private static ArrayList<Bait> baitList = new ArrayList<Bait>();				//Array list initialized for bait objects
	private static ArrayList<Fish> fishList = new ArrayList<Fish>();				//Array list initialized for fish objects
	private Bait bait;																//Bait is auto created by this class
	private Timer t;																//Timer decleration
	private java.util.Timer timerIns;												//Timer decleration
	private int manualTimer = 0;													//Manual timer using frames as a value of time
	
	private static JPanel panelTest = new JPanel();									//Panel is created
	
	public static JPanel getPanel() {return panelTest;}								//Getter for panel reference
	
	private int deadFishTimer = 0;
	
	//Getter for middle point of the screen
	public static PVector middlePoint() {
		PVector mid = new PVector((int)panelTest.getWidth()/2,(int)panelTest.getHeight()/2);
		return mid;
	}

	
	//Extends Mouse adapter
	private class MyMouseAdapter extends MouseAdapter {
	    public void mouseClicked(MouseEvent e) {
	    	createBait(e);					//Creates bait obj at clicked location
	    	selectBait(e);					//Selects bait obj at clicked location
	    	
	    }
	}
	
	//This function checks if the clicked box is empty of not
	public Bait checkIfOccupied(MouseEvent e) {
		for(Bait b:baitList) {
			if((Math.abs(e.getX() - b.getPos().x) < (b.getWidth()/2) * (b.getScale()))&&	//Check object borders
				Math.abs(e.getY() - b.getPos().y) < (b.getWidth()/2) * (b.getScale()))
				return b;
		}
		return null;
	}
	
	//Creates a bait instance if clicked square is empty
	public void createBait(MouseEvent e) {
		Bait baitReference = checkIfOccupied(e);						//Checks if clicked place is not occupied
    	if(baitReference == null){										//If clicked place if empty, add new bait obj
    		PVector position = new PVector(e.getX(), e.getY());
    		Bait bait = new Bait(position);
    		baitList.add(bait);
    			
    	}
		
		
	}
	//This function is used to change size or delete the object
	public void selectBait(MouseEvent e) {
		Bait b = checkIfOccupied(e);
		if(b != null) {
				b.enlargeFood();					//Enlarge the bait

				if(b.getSelected())
					b.deselect();
				else {
					b.select();
				}
				if(e.isControlDown())
					consumeTargetBait(b);			//Delete bait obj
			
		}
	}
		
	
	
	
	//Setup Main Panel for the application
	public EnviromentPanel(Dimension initialSize) {
		
		
		addKeyListener(this);
		setFocusable(true);
		
		addMouseListener(new MyMouseAdapter() {						//Extend mouse adapter
	
             public void mousePressed(MouseEvent e)
             {
            	 Bait b = checkIfOccupied(e);						//Checks if empty
            	 	if(b != null) {
            	 
            	 if(timerIns == null){								//If timer doesnt exist, add timer
            		 timerIns = new java.util.Timer();
                 }
            	 
            	 TimerTask timerTask = new TimerTask()				//Setup new timer
                 {
                     public void run(){
                    	 b.enlargeFood();							
                     }
                 };
                 timerIns.schedule(timerTask,50,100);				//100ms delay, used for 200ms
            	 }
             }
             
             public void mouseReleased(MouseEvent e)				//If released
             {
                 if(timerIns != null){								
                	 timerIns.cancel();								//Cancel timer
                	 timerIns = null;								//Delete timer
                 }
             }
             
		}
		);


		
		panelTest.setBounds(0,0 , initialSize.width-300, initialSize.height-300);	//Panel uses the same bounds with Frame [Subject to change later]
		t = new Timer(33, this);													//Used to start timer to generate Frames
		t.start();																	//Runs the timer
		spawnBait();														

	}
	//Deletes bait obj 
	public static void consumeTargetBait(Bait b) {
		baitList.remove(b);
	}
	
	//Spawns bait instance
	public void spawnBait() {
		Bait newBait = new Bait(CustomRandomizers.getRandomVectorOnPanel());
		baitList.add(newBait);
	}
	
	
	
	
	//Paint Component is overridden to draw objects into panel
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);													//Calls the super class
		setBackground(Color.cyan);													//Sets the background to Cyan color
		Graphics2D g2 = (Graphics2D)g;
		
		for(Fish f: fishList)
			f.draw(g2);
		for(Bait b: baitList)
			b.draw(g2);
		for(PredatorFish f: predatorList)
			f.draw(g2);
	}
	

	

	//When two fish collide, they push each other to opposite directions, bigger one is pushed less compared to smaller one.
	//If the force fish applies to other fish isn't strong enough, bigger fish wont be able to move smaller one
	public void swapSpeedVectors(Fish f1, Fish f2) {
		PVector tmp = f2.getSpeedVector();
	
		//Force is calculated according to F = m*a, however bigger fish is assumed to apply 4 times bigger vector to the smaller one.
		//Applied force is calculated by cross product of two speed vectors
		if(f1.getScaleFactor() > f2.getScaleFactor()) {
			f2.setExtraForce(f1.getSpeedVector().cross(f2.getSpeedVector()).mult(f2.getScaleFactor()*2));
			f1.setExtraForce(tmp.cross(f1.getSpeedVector().mult((float) (f1.getScaleFactor()*0.5))));
		}
	}
	

	public Fish getClosestFish(PredatorFish predator) {
		Fish closestOne = null;																//Sets closest bait to null
		float closestDistance = 3000F;														//Fish's max detection radius
		for(Fish f: fishList) {																//Loops through every bait in array list
			PVector distanceVector = new PVector();
			
			PVector.sub(predator.getPositionVector(), f.getPositionVector(), distanceVector);
			float distance = distanceVector.mag();
			if(distance < closestDistance) {												//Closest one is updated
				closestDistance = distance;
				closestOne = f;
			}
				
		}
		
		if(predator.hasDetectedFish(closestOne))
			return closestOne;
		return null;
	}
	
	//BONUS FUNCTIONALITY HERE
	public void preserveFishNumber(ArrayList<Fish> arr) {
		if(arr.size() != FISH_NUMBER) {
			deadFishTimer++;
			if(deadFishTimer >= 100) {
				arr.add(new Fish());
				deadFishTimer = 0;
			}
			
		}
		
	}
	
	public void drawDetectionForPredators() {
		for(PredatorFish p: predatorList) {
			p.toggleDetectionRadiusDraw();
		}
	}
	


	
	
	//Action Performed function is overridden to animate events
	@Override
	public void actionPerformed(ActionEvent e) {

		
		
		preserveFishNumber(fishList);
		
		if(predatorList.isEmpty()) {								//When there is no fish present, add a fish
			for(int i = 0; i<PREDATOR_FISH_NUMBER;i++)
				predatorList.add(new PredatorFish());
			
		}	
		
		
		
		if(fishList.isEmpty()) {								//When there is no fish present, add a fish
			for(int i = 0; i<FISH_NUMBER;i++)
				fishList.add(new Fish());
			
		}	
		outer:
		for(PredatorFish p: predatorList) {
			p.checkBoundaries(p);
			
			
			
			
			Fish tmp = getClosestFish(p);
			
			for(Fish f: fishList) {
				if(p.hasDetectedFish(f) && tmp != null)
					p.swimToFish(tmp);
				if(p.collides(f)) {
					f.killFish();
					
					break;
				}
				
	
			}
			
			if(p.isIn) {
				
				if(tmp == null) {
					p.swimIdle();
					continue outer;
				}
				
			}
			
			else {
				int fishOutSince = p.getOutTimer(); 
				p.setOutTimer(++fishOutSince);
				
				p.swimToMiddle();
			
				System.out.print(p.getOutTimer());
				
				if( p.getOutTimer() >= 50) {
					p.isIn = true;
					p.setOutTimer(0);
					p.setAccelerationVector(PVector.random2D().normalize());
				}
			}
			
			
		}
		
		for(Fish f: fishList) {
			//Call frame dependent functions
			f.useEnergy();
			f.updateMaxSpeed();
			f.shrinkIfHungry();
			f.getSick();
			f.checkBoundaries(f);
			
			
			
			
			for(Fish f2:fishList) 								//This statement can be optimized to lessen the cpu cycles, I have chosen to optimize my time
				if(f2 != f && f2.collides(f)) {
					swapSpeedVectors(f, f2);					//Fish's push each other
				}
					
			
			if(!baitList.isEmpty()) {
				Bait targetBait = f.getBestBait(baitList);		//Fish swims to best bait
				f.swimToTarget(targetBait);
			}
			else {f.swimIdle();}
			
			
			if(!f.getLifeStatus()) {							//Clear dead fish
				fishList.remove(f);
				break;
			}
				
		}
		

		

		
		if(manualTimer %85 == 0) {													//Spawn a bait every 100 frame
			spawnBait();
		}
		if(manualTimer >= 30000) manualTimer = 0;									//Resets counter to avoid overflow
		
		
		manualTimer++;
		repaint();																	//Used to repaint
		
		//System.out.println(baitList.size());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			drawDetectionForPredators();
			System.out.print("Pressed");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			
		}
		
		
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


