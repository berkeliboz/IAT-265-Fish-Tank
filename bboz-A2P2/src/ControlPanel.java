import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import processing.core.PVector;


public class ControlPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Container bottomContainer;
	
	private JPanel fishInfo = new JPanel();
	private JPanel userInfo = new JPanel();
	private JPanel generalControlPanel = new JPanel();
	private JPanel addObjPanel = new JPanel();
	private JPanel discardObjPanel = new JPanel();
	
	private JPanel additionalInfoPanel = new JPanel();
	
	private TextField totalEnergyTF = new TextField(10);
	private TextField hungerTF = new TextField(10);
	private TextField posTF = new TextField(10);
	private TextField classNameTF = new TextField(10);
	
	private JButton addMaxFishButton = new JButton("+");
	private JButton discardMaxFishButton = new JButton("-");
	private JButton addMaxPreFishButton = new JButton("+");
	private JButton discardMaxPreFishButton = new JButton("-");
	private JButton addMaxBaitButton = new JButton("+");
	private JButton discardMaxBaitButton = new JButton("-");
	
	private JLabel maxFishes = new JLabel();
	private JLabel maxPreFishes = new JLabel();
	private JLabel maxBaits = new JLabel();
	
	
	private JButton addFish = new JButton(" Add Fish  ");
	private JButton addPredator = new JButton("Add Predator");
	
	
	private JButton discardFish = new JButton("Delete Fish");
	private JButton discardPredator = new JButton("Delete Predator");
	
	
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	GridBagConstraints gbcInner = new GridBagConstraints();
	
	private Checkbox setSick = new Checkbox(" Get Sick ",false);
	private Checkbox dismissButton = new Checkbox(" Click here to dismiss ",false);

	
	public ControlPanel() {
		super();

		
		setComponentStatus();
		add(bottomContainer,BorderLayout.SOUTH);
		
	}
	
	public void update(EnviromentPanel p) {
		Creature tmp = EnviromentPanel.getHighlightedCreature();
		tmp.setIsChoosenTrue();
		
		for(Fish b: EnviromentPanel.getFishList()) {
			if(b.anchorPoint == tmp.anchorPoint)
				if(setSick.getState())
					b.sickenFish();
		}
	
		for(PredatorFish b: EnviromentPanel.getPredatorList()) {
			if(b.anchorPoint == tmp.anchorPoint)
				if(setSick.getState()){
					b.sickenFish();
			}
		}
		
		int energyTmp = (int) tmp.getEnergy();
		PVector pos = tmp.getPositionVector();
		
		
		
		hungerTF.setFocusable(false);
		
		totalEnergyTF.setText(String.format("%d", energyTmp));
		totalEnergyTF.setFocusable(false);
		
		posTF.setText(String.format("%.02f/%.02f", pos.x,pos.y));
		posTF.setFocusable(false);
		
		classNameTF.setText(tmp.getClassName());
		
		classNameTF.setFocusable(false);
		
		

		
		
		maxBaits.setText("Current " +String.valueOf(EnviromentPanel.maxBaitNumber));
		maxFishes.setText("Current " +String.valueOf(EnviromentPanel.FISH_NUMBER));
		maxPreFishes.setText("Current " +String.valueOf(EnviromentPanel.PREDATOR_FISH_NUMBER));
		
		hungerTF.setText(String.format("%d", tmp.getHunger()));
		
		if(!EnviromentPanel.isPanelDrawn)
			this.setVisible(false);
		else
			this.setVisible(true);
		
		if(classNameTF.getText() == "Super") {
			
			System.err.print(tmp.getClassName());
			
			hungerTF.setText("N/A");
			totalEnergyTF.setText("N/A");
			posTF.setText("N/A");
			classNameTF.setText("N/A");
		}
		
		if(dismissButton.getState())
			additionalInfoPanel.setVisible(false);
		
		
	}
	
	private void setComponentStatus() {

		Creature tmp = EnviromentPanel.getHighlightedCreature();
		tmp.setIsChoosenTrue();
		
		
		
		
		setBorder(new TitledBorder("Control Panel"));
		
		
		bottomContainer = new Container();
		
		bottomContainer.setLayout(new GridBagLayout());
		
	
		userInfo.setBorder(new TitledBorder(" Info "));
		userInfo.setLayout(new GridLayout(10,1,0,0));
		
		userInfo.add(new JLabel("                 Key Bounds"));		
		userInfo.add(new JLabel("                 "));	
		userInfo.add(new JLabel(" • Click on a Fish to Get Info"));
		userInfo.add(new JLabel(" • Enter to Toggle the Control Panel"));
		userInfo.add(new JLabel(" • Shift + D to Toggle Fish Info"));
		userInfo.add(new JLabel(" • Shift + Space to Toggle Predator FOV "));
		userInfo.add(new JLabel(" • Click anywhere to generate a bait "));
		userInfo.add(new JLabel(" • Click and hold bait to increase size "));
		userInfo.add(new JLabel(" • CTRL + Click on bait to delete"));
		userInfo.add(new JLabel("                 "));	
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		
		bottomContainer.add(userInfo,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		
		bottomContainer.add(fishInfo,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		

		bottomContainer.add(generalControlPanel,gbc);
		
		
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		bottomContainer.add(addObjPanel,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		bottomContainer.add(discardObjPanel,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		
		bottomContainer.add(additionalInfoPanel,gbc);
	
		
				
		
		
		fishInfo.setLayout(new GridLayout(6,1));
		fishInfo.setBorder(new TitledBorder("Fish Info"));
		fishInfo.add(new JLabel("Class Name: "));
		fishInfo.add(classNameTF);
	
		
		fishInfo.add(new JLabel("Total Energy: "));
		fishInfo.add(totalEnergyTF);


		fishInfo.add(new JLabel("Position: "));
		fishInfo.add(posTF);
		
		fishInfo.add(new JLabel("Hunger: "));
		fishInfo.add(hungerTF);
		
	
		
		
		
		fishInfo.add(setSick);
		
		generalControlPanel.setBorder(new TitledBorder("Value Control"));
		generalControlPanel.setLayout(new GridBagLayout());
		
		
		
		
		
		
		
		gbcInner.gridx = 0;
		gbcInner.gridy = 0;
		addMaxBaitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.maxBaitNumber+=1;
			}
		});
		generalControlPanel.add(addMaxBaitButton,gbcInner);
		
		gbcInner.gridx = 1;
		gbcInner.gridy = 0;
		generalControlPanel.add(new JLabel("  Max Bait Limit  "),gbcInner);
		gbcInner.gridx = 2;
		gbcInner.gridy = 0;
		
		discardMaxBaitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.maxBaitNumber-=1;
				
			}
		});
		generalControlPanel.add(discardMaxBaitButton,gbcInner);
	
		
		
		gbcInner.gridx = 1;
		gbcInner.gridy = 1;
		generalControlPanel.add( maxBaits,gbcInner);		
		
		
		
		
		
		gbcInner.gridx = 0;
		gbcInner.gridy = 2;
		addMaxFishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.FISH_NUMBER+=1;
				
			}
		});
		generalControlPanel.add(addMaxFishButton,gbcInner);
		gbcInner.gridx = 1;
		gbcInner.gridy = 2;
		generalControlPanel.add(new JLabel("  Max Fish Limit  "),gbcInner);
		gbcInner.gridx = 2;
		gbcInner.gridy = 2;
		discardMaxFishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.FISH_NUMBER-=1;
				
			}
		});
		generalControlPanel.add(discardMaxFishButton,gbcInner);
		
		gbcInner.gridx = 1;
		gbcInner.gridy = 3;
		generalControlPanel.add( maxFishes,gbcInner);		
		
		
		
		gbcInner.gridx = 0;
		gbcInner.gridy = 4;
		addMaxPreFishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.PREDATOR_FISH_NUMBER+=1;
				
			}
		});
		generalControlPanel.add(addMaxPreFishButton,gbcInner);
		gbcInner.gridx = 1;
		gbcInner.gridy = 4;
		generalControlPanel.add(new JLabel("  Max Predator Limit  "),gbcInner);
		gbcInner.gridx = 2;
		gbcInner.gridy = 4;
		discardMaxPreFishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.PREDATOR_FISH_NUMBER-=1;
				
			}
		});
		generalControlPanel.add(discardMaxPreFishButton,gbcInner);
		
		gbcInner.gridx = 1;
		gbcInner.gridy = 5;
		generalControlPanel.add( maxPreFishes,gbcInner);		
		
		
		addFish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				EnviromentPanel.generateFish();
				
			}
		});
		addObjPanel.add(addFish);
		
		addPredator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnviromentPanel.generatePredatorFish();
				
			}
		});
		
		addObjPanel.add(addPredator);
		
		
		discardFish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(EnviromentPanel.FISH_NUMBER > 0) {
					EnviromentPanel.killFish();
						
				}else {
					System.err.print("Please dont try to crush my program, Thank You!");
					System.err.println();
					EnviromentPanel.FISH_NUMBER+=1;
				}
			}
		});
		discardObjPanel.add(discardFish);
		
		discardPredator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(EnviromentPanel.PREDATOR_FISH_NUMBER > 0) {
					EnviromentPanel.killPredatorFish();
						
				}else {
					System.err.print("Please dont try to crush my program, Thank You!");
					System.err.println();
					EnviromentPanel.PREDATOR_FISH_NUMBER+=1;
				}
			}
		});
		discardObjPanel.add(discardPredator);

		additionalInfoPanel.setLayout(new GridLayout(8,1,0,0));
		additionalInfoPanel.setBorder(new TitledBorder("Additional Info"));
		additionalInfoPanel.add(new JLabel("                Known Bugs "));
		additionalInfoPanel.add(new JLabel("                		 "));
		additionalInfoPanel.add(new JLabel(" • After using Panel, Enviromental "));
		additionalInfoPanel.add(new JLabel(" Panel loses focus. To fix, press TAB "));
		additionalInfoPanel.add(new JLabel(" and try clicking again "));
		additionalInfoPanel.add(new JLabel("                		 "));
		additionalInfoPanel.add(dismissButton);
		additionalInfoPanel.add(new JLabel("                		 "));
	}
	
	
}