# Fish Tank
Project Fish Tank is designed, programmed, and documented by Berke Boz. 

## Clone
 * Clone this repo to your local machine using https://github.com/berkeliboz/IAT-265-Fish-Tank

## Features 
Project Fish Tank is a Java Swing based simulation programmed in Eclipse, designed in Netbeans 8.2. Project Fish Tank consists of three main components; Environmental Panel, Menu Bar, and Control Panel.
### 1.0 Menu Bar
Consists of four sub-menus, which are File, Edit, General and Add.
### 1.1 File Menu
Holds two menu items, Clear Data , Exit. Clear Data button is linked to clearDataDialog JDialog. Exit button ends the application process.
* Clear Data Dialog: holds two JButtons and one JLabel. deleteDataYesButton wipes all saved data. deleteDataNoButton closes the JDialog.
### 1.2 Edit Menu
Holds two menu items, New Template and Properties.
#### New Template
New Template button instantiates a CreateTemplateFrame type object that instantiates a JFrame in its constructor and sets it visible.
1. Create Template Frame
This class holds a JLabel, three radio buttons inside a JPanel and a Next Button. Radio Buttons assigns key value stored in mainFrame staticly and instantiates a new JPanel accordingly.
2. Add Fish Frame
This JFrame holds five sliders, Edit Scale, X Position Position, Starting Energy, and Max Velocity, one Radio Panel, one Color Chooser and Advanced Control Panel. All values set by the controllers are saved into local variables and are not assigned until Save Button is pressed. Save Button checks for the key stored in mainFrame and writes the values accordingly as Text files. Then save button calls a confirmation dialog to create a new instance of Fish/Predator reading the values from the saved data files. For Fish, the save file is called as normalFishConfig.txt and for Predator, the save file is called as predatorFishConfig.txt. Toggle Advanced button hides/shows advanced options, Detection Radius, Energy Usage Per Frame, Max Velocity and Spawn Sick.
3. Add Bait Frame
This JFrame holds two sliders, two color pickers and a save button. Same as Add Fish Frame, Add Bait Frame stores values locally, then saves them to a file and reads the file. Sliders determine the size and the floating range for the template bait. Color Pickers assigns colors to the local values when save button is pressed. Like Add Fish Frame, Add Bait Frame calls a confirmation dialog to create a new instance of Bait. Bait save file is called as baitConfig.txt
#### Properties Dialog
For properties dialog to function, a fish/predator must be highlighted. To highlight a fish, click on a fish object from mainPanel. Properties dialog holds three sliders; Scale slider, Detection slider and Energy slider, a color picker, color set button, save button, load button and close button. Save button saves chosen values to config.txt file. Load button loads values from config.txt file and assigns values to sliders and color picker. Close button closes properties dialog. Scale value is not saved since it lead to unintended outcomes.
### 1.3 General Menu
General Button holds four menu items, Increase FPS, Decrease FPS, FPS Controller, Bait Generation Controller. Increase FPS button decreases frame tick delay found in Environment Panel by 10 and informs it to user with a dialog box. Decrease FPS button does opposite with Increase FPS button.
1. FPS Controller
FPS Controller button sets fpsSliderDialog visible. FPS Slider Dialog has one slider and two buttons. Slider controls frame tick delay found in Environment Panel. Default button sets frame tick delay to 33 ms, which is approximately 30 frames per second. Close button closes the dialog.
2. Bait Generation Controller
Bait Generation Controller sets baitGenerationRateController visible. The controller has default button, close button and a slider to control Bait Generation Rate found in Environmental Panel. Default button sets the rate to default value, which is 50 frames.
### 1.4 Add Menu
Add menu has three menu items, Fish Template, Predator Template and Bait Template. All items share the same functionality. Menu items, reads .txt data according to type of object to instantiate. Menu buttons instantiate the chosen object if Max Number of Elements are not present on the screen. Max number of items can be accessed via Control Panel -> Value Control.
Notes:
- Since Control Panel remains same from Assignment 4 Part 1, no documentation were added in Assignment 4 Part 2. Documentation written for Control Panel as a part of Assignment 4 Part 1, can be accessed from comments section of ControlPanel.java file
