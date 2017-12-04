// IAT 265 - Assignment 3.2
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
//Assignment 3.2 Change Log
//
//	::New Parameters
//	- globalDrowInfo: Boolean	added
//	- creatures: ArrayList<Creature>  added
//		- Holds a copy of current objects on the screen
//	- shiftDown: Boolean	added
//
//	
// - actionPerformed(ActionEvent e) modified
//		- Modified behaviors of both fish types.
//		- Bonus functionality added.							-----------------> See the loop staring from line 453
//			- BUG: Sometimes fish swims into the predator fish instead of going to other direction and doesnt draws FOV/Detection Radius when this happens.
//				
//
//
//	- mouseClicked() edited
//		- now mouseClicked() toggles draw info for all creatures
//	- checkIfOccupiedCreature(), checkIfOccupiedFish() and checkIfOccupiedPredator() added
//	- drawDetectionForPredators() added
//		- Use Shift+Space key combination to test
//
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
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.security.auth.x500.X500Principal;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import processing.core.PVector;

//This class implements main panel for the application
public class EnviromentPanel extends JPanel implements ActionListener,KeyListener {

	public static int FISH_NUMBER = 10;
	public static int PREDATOR_FISH_NUMBER = 2;
	public static int maxBaitNumber = 20;
	
	
	private static ArrayList<Creature> creatures = new ArrayList<Creature>();
	private boolean globalDrawInfo = false;											//Holds a copy of current objects on the screen
	
        private static int addBaitSpeed = 50;
	private static ArrayList<PredatorFish> predatorList = new ArrayList<PredatorFish>();//Array list initialized for PredatorFish objects				
	private static ArrayList<Bait> baitList = new ArrayList<Bait>();				//Array list initialized for bait objects
	private static ArrayList<Fish> fishList = new ArrayList<Fish>();				//Array list initialized for fish objects
	private Bait bait;																//Bait is auto created by this class
	private Timer t;																//Timer decleration
	private java.util.Timer timerIns;												//Timer decleration
	private int manualTimer = 0;													//Manual timer using frames as a value of time
	private static int fps = 33;
        
       
        public static void setFPS(int fps){EnviromentPanel.fps = fps;}
        
        public static void fpsUp(){fps-=10;}
        public static void fpsDown(){fps+=10;}
        public static int getFps(){return fps;}
        
	private static JPanel panelTest = new JPanel();									//Panel is created
	
	public static ArrayList<PredatorFish> getPredatorList() {
		return predatorList;
	}
	
	public static ArrayList<Fish> getFishList() {
		return fishList;
	}
	
	public static ArrayList<Bait> getBaitList() {
		return baitList;
	}
	
	public static JPanel getPanel() {return panelTest;}								//Getter for panel reference
	
	private int deadFishTimer = 0;
	private boolean shiftDown = false;
	
	private static Creature highlightedCreature = new Creature();
	
	public static boolean isPanelDrawn = true;

	private static ControlPanel controlPanel;
	
	public static Creature getHighlightedCreature() {
		return highlightedCreature;
	}

	
	//Getter for middle point of the screen
	public static PVector middlePoint() {
		PVector mid = new PVector((int)panelTest.getWidth()/2,(int)panelTest.getHeight()/2);
		return mid;
	}

	
	//Extends Mouse adapter
	private class MyMouseAdapter extends MouseAdapter {
	    public void mouseClicked(MouseEvent e) {

	    	
	    	Creature tmpFish = checkIfOccupiedCreature(e);
	    	
	    	if(tmpFish != null && shiftDown)
	    		tmpFish.toggleDrawInfo();
	    	else if(tmpFish != null && !shiftDown){
	    		
	    		highlightedCreature = tmpFish;
                       
	    		
	    	}
	    	
	    	else {
	    		if(baitList.size() < maxBaitNumber)
	    			createBait(e);				//Creates bait obj at clicked location
		    	selectBait(e);					//Selects bait obj at clicked location
	    	}	
	    }
	}
	
        public static void setBaitGenerationRate(int rate){addBaitSpeed = rate;}
        public static int getBaitGenerationRate(){return addBaitSpeed;}
	
	//This function checks if the clicked box is empty of not
	public Bait checkIfOccupied(MouseEvent e) {
		for(Bait b:baitList) {
			if((Math.abs(e.getX() - b.getPos().x) < (b.getWidth()/2) * (b.getScale()))&&	//Check object borders
				Math.abs(e.getY() - b.getPos().y) < (b.getWidth()/2) * (b.getScale()))
				return b;
		}
		return null;
	}

	//This function checks if the clicked box is empty of not
	public Creature checkIfOccupiedCreature(MouseEvent e) {
		for(Creature b: creatures) {
	
			if((Math.abs(e.getX() - b.getXPos()) < (b.getWidth()/2) * (b.getScaleFactor()))&&	//Check object borders
				Math.abs(e.getY() - b.getYPos()) < (b.getWidth()/2) * (b.getScaleFactor()))
				return b;
		}
		return null;
	}
	
	
	//This function checks if the clicked box is empty of not
	public PredatorFish checkIfOccupiedPredator(MouseEvent e) {
		for(PredatorFish b: predatorList) {
	
			if((Math.abs(e.getX() - b.getXPos()) < (b.getWidth()/2) * (b.getScaleFactor()))&&	//Check object borders
				Math.abs(e.getY() - b.getYPos()) < (b.getWidth()/2) * (b.getScaleFactor()))
				return b;
		}
		return null;
	}
	
	//This function checks if the clicked box is empty of not
	public Fish checkIfOccupiedFish(MouseEvent e) {
		for(Fish b: fishList) {

			if((Math.abs(e.getX() - b.getXPos()) < (b.getWidth()/2) * (b.getScaleFactor()))&&	//Check object borders
				Math.abs(e.getY() - b.getYPos()) < (b.getWidth()/2) * (b.getScaleFactor()))
				return b;
		}
		return null;
	}
	
	//Creates a bait instance if clicked square is empty
	public void createBait(MouseEvent e) {
		Bait baitReference = checkIfOccupied(e);						//Checks if clicked place is not occupied
    	if(baitReference == null && baitList.size()<= maxBaitNumber){	//If clicked place if empty, add new bait obj
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
	public EnviromentPanel(Dimension initialSize,ControlPanel cp) {
		super();
		
		controlPanel = cp;
		
                
                
		addKeyListener(this);										//Add key listener
		setFocusable(true);											//Set focusable
		
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
             
		});
		
		panelTest.setBounds(0,0 , initialSize.width-300, initialSize.height-300);	//Panel uses the same bounds with Frame [Subject to change later]
		t = new Timer(fps, this);													//Used to start timer to generate Frames
		
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
	
	public static void generateParameteredBait(int baitSize,Color color1,Color color2, float floatingRange){
                if(maxBaitNumber > baitList.size()){
                    Bait newBait = new Bait(baitSize, color1, color2, floatingRange);
                    baitList.add(newBait);
                }
            
                
        }
	
	
	//Paint Component is overridden to draw objects into panel
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);													//Calls the super class
		setBackground(Color.cyan);													//Sets the background to Cyan color
		Graphics2D g2 = (Graphics2D)g;
		
                
                
		for(Fish f: fishList) {
			f.draw(g2);
			f.setIsChoosenFalse();		
		}
		for(Bait b: baitList)
			b.draw(g2);
		for(PredatorFish f: predatorList) {
			f.draw(g2);
			f.setIsChoosenFalse();
		}
			
		
		controlPanel.update(this);
		
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
	
	//This function preserves total Fish number by using a timer that works on FPS
	public void preserveFishNumber(ArrayList<Fish> arr) {
		if(arr.size() != FISH_NUMBER) {
			deadFishTimer++;
			if(deadFishTimer >= 100) {
				arr.add(new Fish());
				deadFishTimer = 0;
			}
			
		}
		
	}
	//Toggles detection radius draw for Predators
	//Use Shift+Space key combination to test
	public void drawDetectionForPredators() {
		for(PredatorFish p: predatorList) {
			p.toggleDetectionRadiusDraw();
		}
	}
	


	public static void generatePredatorFish() {
		
		if(predatorList.size() < PREDATOR_FISH_NUMBER) {
			predatorList.add(new PredatorFish());
			creatures.add(predatorList.get(predatorList.size()-1));
		
		}
		
	}

        
        
        public static void generateParameteredFish(float scaleFactor, Color creatureColor,int stripeNumber, int posX,int posY, float totalEnergy, boolean isSick, int detectionRadius,int energyUsage, float maxVelocity) {
		
		if(fishList.size() < FISH_NUMBER) {
			fishList.add(new Fish( scaleFactor,  creatureColor, stripeNumber,  posX, posY,  totalEnergy,  isSick,  detectionRadius, energyUsage,  maxVelocity));
			creatures.add(fishList.get(fishList.size()-1));
		
		}
		
	}
	
        
        
        
        
	public static void generateFish() {
		
		if(fishList.size() < FISH_NUMBER) {
			fishList.add(new Fish());
			creatures.add(fishList.get(fishList.size()-1));		
	
		}
		
		
		
	}
	
	public static void killFish() {
		fishList.remove(fishList.size()-1);
		creatures.remove(creatures.size()-1);
	}
	public static void killPredatorFish() {
		predatorList.remove(predatorList.size()-1);
		creatures.remove(creatures.size()-1);
	}
	
	
	//Action Performed function is overridden to animate events
	@Override
	public void actionPerformed(ActionEvent e) {

		creatures.removeAll(creatures);								//Empties the list to update in every frame
		creatures.addAll(predatorList);								//Adds predators to list
				
                
                
		preserveFishNumber(fishList);								//Add new fishes if there are missing fishes
		creatures.addAll(fishList);									//Adds fishes to list
		
		if(predatorList.isEmpty()) {								//When there is no fish present, add a fish
			for(int i = 0; i<PREDATOR_FISH_NUMBER;i++)
				predatorList.add(new PredatorFish());
				creatures.add(predatorList.get(predatorList.size()-1));
		}	
		
		
		
		if(fishList.isEmpty()) {								//When there is no fish present, add a fish
			for(int i = 0; i<FISH_NUMBER;i++)
				fishList.add(new Fish());
				creatures.add(fishList.get(fishList.size()-1));
	
		}	
		outer:													//GOTO Label
		for(PredatorFish p: predatorList) {
			//Update functions for predators
			p.checkBoundaries(p);
			p.useEnergy();
			p.updateMaxSpeed();
			p.shrinkIfHungry();
			p.getSick();
		
			Fish tmp = getClosestFish(p);						//Predators swim to the closest fish
			for(Fish f: fishList) {
				if(p.hasDetectedFish(f) ){
                                    p.swimToFish(tmp);   
                                break;
                        }
					
                                        
				
	
			}
			for(Fish f: fishList){
                            if(p.collides(f)) {								//If predator touches the fish
					f.killFish();
					p.grow(f.getScaleFactor());					//Grow	
				}
                        }
                        
                        
			if(p.isIn) {										//If predator is inside boundaries
				
				if(tmp == null) {
					p.swimIdle();
					continue outer;								//This is GOTO control for Java
				}
				
			}
			
			else {
				int fishOutSince = p.getOutTimer(); 			//When fish goes out of screen borders a timer starts. Fish swims to the middle of the screen during the timer.
				p.setOutTimer(++fishOutSince);
				p.swimToMiddle();
				
				if( p.getOutTimer() >= 45) {
					p.isIn = true;
					p.setOutTimer(0);
					p.setAccelerationVector(PVector.random2D().normalize());	//Gives the fish a randomized and normalized vector
				}
			}
			
			if(!p.getLifeStatus()) {
				predatorList.remove(p);							//Kills predator
				break;
				
			}
		}
		
		//															BONUS FUNCTIONALITY CODE IN THIS LOOP
		for(Fish f: fishList) {
			
			//Call frame dependent functions
			f.useEnergy();
			//f.updateMaxSpeed();
			f.shrinkIfHungry();
			f.getSick();
			f.checkBoundaries(f);
			
			for(PredatorFish p:predatorList) {
				if(f.detects(p)) {								//if fish detects a predator, is starts swimming faster to another direction 
					f.setIsEscaping(true);												
					f.swimToEscape(p); 
				}else{f.setIsEscaping(false);}
					
			}
			
			
			for(Fish f2:fishList) 								//This statement can be optimized to lessen the cpu cycles, I have chosen to optimize my time
				if(f2 != f && f2.collides(f)) {
					swapSpeedVectors(f, f2);					//Fish's push each other
				}
					
			
			if(!baitList.isEmpty() && !f.isEscaping()) {
				Bait targetBait = f.getBestBait(baitList);		//Fish swims to best bait
				f.swimToTarget(targetBait);
				f.toggleFOV();
			}
			else if(!f.isEscaping() && baitList.isEmpty()) {
				f.swimIdle();									//Swims idle
				f.toggleFOV();
			}
			
			
			if(!f.getLifeStatus()) {							//Clear dead fish
				fishList.remove(f);
				break;
			}
				
		}
		

		

		
		if(manualTimer %addBaitSpeed == 0 && baitList.size() < maxBaitNumber) {				//Spawn a bait every 100 frame
			spawnBait();
		}
		if(manualTimer >= 30000) manualTimer = 0;									//Resets counter to avoid overflow
		
		
		
		//This next 6 lines are used for toggling information
		if(!shiftDown) {
			
		
		for(PredatorFish c: predatorList) {
			c.infoDrawn = globalDrawInfo;
		}
		for(Fish c: fishList) {
			c.infoDrawn = globalDrawInfo;
		}
		}
		
                try {
                t.setDelay(fps);
                
                } catch (Exception eb) {
                    
                }
                
		
		
                
		manualTimer++;
		repaint();																	//Used to repaint
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE&& e.isShiftDown()) {
			drawDetectionForPredators();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D&& e.isShiftDown()) {
			globalDrawInfo = !globalDrawInfo;
		}
		if(e.isShiftDown())
			shiftDown = true;														//Shift is presseed
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			isPanelDrawn = !isPanelDrawn;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent b) {
		shiftDown = false;															//Shift is released
		}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}


