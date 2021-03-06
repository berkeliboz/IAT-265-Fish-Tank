


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JFrame;


public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    
    private static String choosenClassName = "_";
    
    
    
    
    public static void setChoosenString( String newStr){
        choosenClassName = newStr;
    }
    
    public static String getChoosenString(){
        return choosenClassName;
    }
    
    public mainFrame() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);						//Exits the program when closed
	this.setSize(1920,1080);													//Set frame resolution to 1080p (1920x1080)
	ControlPanel controlPanel = new ControlPanel();
        Dimension panelSize = this.getSize();										//Creates a Dimension type object to pass the screen size values
	EnviromentPanel animPanel = new EnviromentPanel(panelSize,controlPanel);					//Panel size is subject to change
	
	setPreferredSize(panelSize);
		
        
                
	
		
	setLayout(new BorderLayout());
		
	add(animPanel);																//Panel is added
	add(controlPanel,BorderLayout.EAST);
 
	this.setVisible(true);														//Sets the panel visible
		
        
        initComponents();
        
        //Initialize components
        frameTickDialog.setSize(400,200);
        frameTextField.setFocusable(false);
        fpsSliderDialog.setSize(235, 150);
        fpsLabel.setText("Each Frame Rendered in " + String.valueOf(fpsSlider.getValue())+ " ms");
        baitGenerationRateController.setSize(285, 150);
        baitGenerationLabel.setText("Generates Bait once in 50 frames");
        clearDataDialog.setSize(235, 150);
        propertiesDialog.setSize(1015, 433);
        customScaleSliderLabel.setText(String.valueOf(customScaleSlider.getValue()/10));
        customDetectionSlider.setMaximum(10);
        customDetectionSlider.setMaximum(1500);
        customDetectionSlider.setValue(EnviromentPanel.getHighlightedCreature().detectionRadius);
        customEnergySlider.setMaximum(0);
        customEnergySlider.setMaximum(10000);
        customEnergySlider.setValue((int)EnviromentPanel.getHighlightedCreature().totalEnergy);
        
    }

    public void changeRes(int x,int y){this.setSize(x,y);}
    
   // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameTickDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        frameTickButton = new javax.swing.JButton();
        frameTextField = new javax.swing.JTextField();
        fpsSliderDialog = new javax.swing.JDialog();
        fpsSlider = new javax.swing.JSlider(0,400,33);
        fpsLabel = new javax.swing.JLabel();
        defaultButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        baitGenerationRateController = new javax.swing.JDialog();
        baitGenerationSlider = new javax.swing.JSlider(1,500,50);
        baitGenerationLabel = new javax.swing.JLabel();
        DefaultButtonBaitGenerator = new javax.swing.JButton();
        baitGenerationControllerCloseButton = new javax.swing.JButton();
        clearDataDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        deleteDataNoButton = new javax.swing.JButton();
        deleteDataYesButton = new javax.swing.JButton();
        propertiesDialog = new javax.swing.JDialog();
        customScaleSlider = new javax.swing.JSlider(0,20,10);
        jLabel3 = new javax.swing.JLabel();
        customScaleSliderLabel = new javax.swing.JLabel();
        customDetectionSlider = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        customDetectionSliderLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        customEnergySlider = new javax.swing.JSlider();
        customEnergySliderLabel = new javax.swing.JLabel();
        customColorPicker = new javax.swing.JColorChooser();
        propertiesDialogCloseButton = new javax.swing.JButton();
        customSaveButton = new javax.swing.JButton();
        customLoadButton = new javax.swing.JButton();
        customColorPickerButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        clearDataButton = new javax.swing.JMenuItem();
        exitButton = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        createNewTemplateButton = new javax.swing.JMenuItem();
        propertiesMenuButton = new javax.swing.JMenuItem();
        generalMenu = new javax.swing.JMenu();
        increaseFPSMenuItem = new javax.swing.JMenuItem();
        decreaseFPSMenuItem = new javax.swing.JMenuItem();
        openFPSSlider = new javax.swing.JMenuItem();
        baitGeneratorButton = new javax.swing.JMenuItem();
        addMenu = new javax.swing.JMenu();
        addFishButton = new javax.swing.JMenuItem();
        addPredatorFishButton = new javax.swing.JMenuItem();
        addBaitButton = new javax.swing.JMenuItem();

        frameTickDialog.getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel1.setText("Frame Delay Increased To");

        frameTickButton.setText("OK");
        frameTickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameTickButtonActionPerformed(evt);
            }
        });

        frameTextField.setText("33");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(frameTickButton)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(frameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(frameTickButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        frameTickDialog.getContentPane().add(jPanel1);

        fpsSliderDialog.getContentPane().setLayout(new java.awt.FlowLayout());

        int fps_min = 0;
        int fps_max = 400;
        fpsSlider.setMajorTickSpacing(20);
        fpsSlider.setMinorTickSpacing(5);
        fpsSlider.setPaintTicks(true);
        fpsSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fpsSliderStateChanged(evt);
            }
        });
        fpsSliderDialog.getContentPane().add(fpsSlider);

        fpsLabel.setText("FPS: ");
        fpsSliderDialog.getContentPane().add(fpsLabel);

        defaultButton.setText("Default");
        defaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonActionPerformed(evt);
            }
        });
        fpsSliderDialog.getContentPane().add(defaultButton);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        fpsSliderDialog.getContentPane().add(closeButton);

        baitGenerationSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                baitGenerationSliderStateChanged(evt);
            }
        });

        baitGenerationLabel.setText("Generates Bait");

        DefaultButtonBaitGenerator.setText("Default");
        DefaultButtonBaitGenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultButtonBaitGeneratorActionPerformed(evt);
            }
        });

        baitGenerationControllerCloseButton.setText("Close");
        baitGenerationControllerCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baitGenerationControllerCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout baitGenerationRateControllerLayout = new javax.swing.GroupLayout(baitGenerationRateController.getContentPane());
        baitGenerationRateController.getContentPane().setLayout(baitGenerationRateControllerLayout);
        baitGenerationRateControllerLayout.setHorizontalGroup(
            baitGenerationRateControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baitGenerationRateControllerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(baitGenerationRateControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baitGenerationRateControllerLayout.createSequentialGroup()
                        .addComponent(baitGenerationSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(baitGenerationRateControllerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(baitGenerationRateControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baitGenerationRateControllerLayout.createSequentialGroup()
                                .addComponent(baitGenerationLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(baitGenerationRateControllerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(DefaultButtonBaitGenerator)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                .addComponent(baitGenerationControllerCloseButton)
                                .addGap(71, 71, 71))))))
        );
        baitGenerationRateControllerLayout.setVerticalGroup(
            baitGenerationRateControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baitGenerationRateControllerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baitGenerationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(baitGenerationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(baitGenerationRateControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DefaultButtonBaitGenerator)
                    .addComponent(baitGenerationControllerCloseButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setText("Delete All Template Data?");

        deleteDataNoButton.setText("No");
        deleteDataNoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDataNoButtonActionPerformed(evt);
            }
        });

        deleteDataYesButton.setText("Yes");
        deleteDataYesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDataYesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clearDataDialogLayout = new javax.swing.GroupLayout(clearDataDialog.getContentPane());
        clearDataDialog.getContentPane().setLayout(clearDataDialogLayout);
        clearDataDialogLayout.setHorizontalGroup(
            clearDataDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clearDataDialogLayout.createSequentialGroup()
                .addGroup(clearDataDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clearDataDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(deleteDataNoButton)
                        .addGap(60, 60, 60)
                        .addComponent(deleteDataYesButton))
                    .addGroup(clearDataDialogLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clearDataDialogLayout.setVerticalGroup(
            clearDataDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clearDataDialogLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(clearDataDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteDataNoButton)
                    .addComponent(deleteDataYesButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customScaleSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                customScaleSliderStateChanged(evt);
            }
        });

        jLabel3.setText("Scale");

        customScaleSliderLabel.setText("Val");

        customDetectionSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                customDetectionSliderStateChanged(evt);
            }
        });

        jLabel9.setText("Detection");

        customDetectionSliderLabel.setText("Val");

        jLabel11.setText("Energy");

        customEnergySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                customEnergySliderStateChanged(evt);
            }
        });

        customEnergySliderLabel.setText("Val");

        customColorPicker.setPreviewPanel(new javax.swing.JPanel());

        propertiesDialogCloseButton.setText("Close");
        propertiesDialogCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesDialogCloseButtonActionPerformed(evt);
            }
        });

        customSaveButton.setText("Save");
        customSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customSaveButtonActionPerformed(evt);
            }
        });

        customLoadButton.setText("Load");
        customLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customLoadButtonActionPerformed(evt);
            }
        });

        customColorPickerButton.setText("Set Color");
        customColorPickerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customColorPickerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout propertiesDialogLayout = new javax.swing.GroupLayout(propertiesDialog.getContentPane());
        propertiesDialog.getContentPane().setLayout(propertiesDialogLayout);
        propertiesDialogLayout.setHorizontalGroup(
            propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesDialogLayout.createSequentialGroup()
                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(propertiesDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(propertiesDialogLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(24, 24, 24)
                                .addComponent(customEnergySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(propertiesDialogLayout.createSequentialGroup()
                                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addGap(10, 10, 10)
                                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customScaleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customDetectionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customEnergySliderLabel)
                            .addComponent(customDetectionSliderLabel)
                            .addComponent(customScaleSliderLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, propertiesDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customColorPickerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(customColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, propertiesDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(customSaveButton)
                .addGap(18, 18, 18)
                .addComponent(customLoadButton)
                .addGap(18, 18, 18)
                .addComponent(propertiesDialogCloseButton)
                .addGap(60, 60, 60))
        );
        propertiesDialogLayout.setVerticalGroup(
            propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customScaleSliderLabel)
                    .addComponent(jLabel3)
                    .addComponent(customScaleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customDetectionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customDetectionSliderLabel)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(customEnergySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customEnergySliderLabel))
                .addGap(93, 93, 93)
                .addComponent(customColorPickerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(propertiesDialogLayout.createSequentialGroup()
                .addComponent(customColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(propertiesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(propertiesDialogCloseButton)
                    .addComponent(customSaveButton)
                    .addComponent(customLoadButton))
                .addGap(20, 20, 20))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setText("File");

        clearDataButton.setText("Clear Data");
        clearDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataButtonActionPerformed(evt);
            }
        });
        fileMenu.add(clearDataButton);

        exitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        fileMenu.add(exitButton);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        createNewTemplateButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        createNewTemplateButton.setText("New Template");
        createNewTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewTemplateButtonActionPerformed(evt);
            }
        });
        editMenu.add(createNewTemplateButton);

        propertiesMenuButton.setText("Properties");
        propertiesMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesMenuButtonActionPerformed(evt);
            }
        });
        editMenu.add(propertiesMenuButton);

        menuBar.add(editMenu);

        generalMenu.setText("General");
        generalMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalMenuActionPerformed(evt);
            }
        });

        increaseFPSMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, java.awt.event.InputEvent.CTRL_MASK));
        increaseFPSMenuItem.setText("Increase FPS");
        increaseFPSMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseFPSMenuItemActionPerformed(evt);
            }
        });
        generalMenu.add(increaseFPSMenuItem);

        decreaseFPSMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, java.awt.event.InputEvent.CTRL_MASK));
        decreaseFPSMenuItem.setText("Decrease FPS");
        decreaseFPSMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseFPSMenuItemActionPerformed(evt);
            }
        });
        generalMenu.add(decreaseFPSMenuItem);

        openFPSSlider.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        openFPSSlider.setText("FPS Controller");
        openFPSSlider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFPSSliderActionPerformed(evt);
            }
        });
        generalMenu.add(openFPSSlider);

        baitGeneratorButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        baitGeneratorButton.setText("Bait Generation Controller");
        baitGeneratorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baitGeneratorButtonActionPerformed(evt);
            }
        });
        generalMenu.add(baitGeneratorButton);

        menuBar.add(generalMenu);

        addMenu.setText("Add");

        addFishButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        addFishButton.setText("Fish Template");
        addFishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFishButtonActionPerformed(evt);
            }
        });
        addMenu.add(addFishButton);

        addPredatorFishButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        addPredatorFishButton.setText("Predator Template");
        addPredatorFishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPredatorFishButtonActionPerformed(evt);
            }
        });
        addMenu.add(addPredatorFishButton);

        addBaitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        addBaitButton.setText("Bait Template");
        addBaitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBaitButtonActionPerformed(evt);
            }
        });
        addMenu.add(addBaitButton);

        menuBar.add(addMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generalMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalMenuActionPerformed
        // TODO add your handling code here:
        //DELETE
    }//GEN-LAST:event_generalMenuActionPerformed

    //Increases fps, updates Values on jlabel
    private void increaseFPSMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseFPSMenuItemActionPerformed
        EnviromentPanel.fpsUp();
        frameTickDialog.setVisible(true);
        frameTextField.setText(String.valueOf(EnviromentPanel.getFps()));

    }//GEN-LAST:event_increaseFPSMenuItemActionPerformed

    private void decreaseFPSMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseFPSMenuItemActionPerformed
        // TODO add your handling code here:
         EnviromentPanel.fpsDown();
         frameTickDialog.setVisible(true);
         frameTextField.setText(String.valueOf(EnviromentPanel.getFps()));
    }//GEN-LAST:event_decreaseFPSMenuItemActionPerformed

    private void frameTickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameTickButtonActionPerformed
       
        frameTickDialog.setVisible(false);
       
    }//GEN-LAST:event_frameTickButtonActionPerformed

    private void addFishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFishButtonActionPerformed
        // TODO add your handling code here:

        
        Scanner sc = null;
        float scale,maxVelocity;
        int xPos,yPos,stripeNumber,startingEnergy,detectionRadius,energyUsage;
        Color newCreatureColor;
        boolean isSick;
        int r,g,b;
        try {
            sc = new Scanner(new FileReader("normalFishconfig.txt"));
            while(!"Normal_Fish".equals(sc.next())){
                sc.next();
            }
            
            sc.next();
            scale = sc.nextFloat();
            sc.next();
            xPos = sc.nextInt();
            sc.next();
            yPos = sc.nextInt();
            sc.next();
            startingEnergy = sc.nextInt();
            sc.next();
            r= sc.nextInt();
            sc.next();
            g = sc.nextInt();
            sc.next();
            b = sc.nextInt();
            newCreatureColor = new Color(r,g,b);
            sc.next();
            detectionRadius = sc.nextInt();
            sc.next();
            energyUsage = sc.nextInt();
            sc.next();
            maxVelocity = sc.nextFloat();
            sc.next();
            isSick = Boolean.valueOf(sc.next());
            sc.next();
            stripeNumber = sc.nextInt();
            
            xPos = (int)CustomRandomizers.getRandomVectorOnPanel().x;
            yPos = (int)CustomRandomizers.getRandomVectorOnPanel().y;
            
            //Generates a new Fish
            EnviromentPanel.generateParameteredFish(scale, newCreatureColor, stripeNumber, xPos, yPos, startingEnergy, isSick, detectionRadius, energyUsage, maxVelocity);
            
        } catch (Exception e) {
            System.err.println("Template not created");
           
        }
          
        
    }//GEN-LAST:event_addFishButtonActionPerformed

    private void fpsSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fpsSliderStateChanged
       
        fpsLabel.setText("Each Frame Rendered in " + String.valueOf(fpsSlider.getValue())+ " ms");
        EnviromentPanel.setFPS(fpsSlider.getValue());
    }//GEN-LAST:event_fpsSliderStateChanged

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       
        fpsSliderDialog.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void openFPSSliderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFPSSliderActionPerformed
       
        fpsSliderDialog.setVisible(true);
    }//GEN-LAST:event_openFPSSliderActionPerformed

    private void defaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonActionPerformed
        
        fpsSlider.setValue(33);
        EnviromentPanel.setFPS(fpsSlider.getValue());
    }//GEN-LAST:event_defaultButtonActionPerformed

    private void addBaitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBaitButtonActionPerformed
        
        Scanner sc = null;
        int r1,g1,b1,r2,g2,b2;
        int size;
        float floatingRange;
        Color color1,color2;
        try {
            sc = new Scanner(new FileReader("baitConfig.txt"));
          
       
            while(!"Bait".equals(sc.next())){
                sc.next();
            }
            sc.next();
            size = sc.nextInt();
            sc.next();
            floatingRange = sc.nextFloat();
            sc.next();
            r1 = sc.nextInt();
            sc.next();
            g1 = sc.nextInt();
            sc.next();
            b1 = sc.nextInt();
            sc.next();
            r2 = sc.nextInt();
            sc.next();
            g2 = sc.nextInt();
            sc.next();
            b2 = sc.nextInt();
            color1 = new Color(r1,g1,b1);
            color2 = new Color(r2,g2,b2);
            //Generates a Bait
            EnviromentPanel.generateParameteredBait(size, color1, color2, floatingRange);
           
        } catch (Exception e) {
            System.out.print("err");
        }

    }//GEN-LAST:event_addBaitButtonActionPerformed

    private void baitGeneratorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baitGeneratorButtonActionPerformed
        // TODO add your handling code here:
        baitGenerationRateController.setVisible(true);

    }//GEN-LAST:event_baitGeneratorButtonActionPerformed

    private void baitGenerationSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_baitGenerationSliderStateChanged
        // TODO add your handling code here:
        EnviromentPanel.setBaitGenerationRate(baitGenerationSlider.getValue());
        baitGenerationLabel.setText("Generates Bait once in " + EnviromentPanel.getBaitGenerationRate() +  " frames");
         
    }//GEN-LAST:event_baitGenerationSliderStateChanged

    private void baitGenerationControllerCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baitGenerationControllerCloseButtonActionPerformed
        baitGenerationRateController.setVisible(false);
 
    }//GEN-LAST:event_baitGenerationControllerCloseButtonActionPerformed

    private void DefaultButtonBaitGeneratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultButtonBaitGeneratorActionPerformed
        // TODO add your handling code here:
        EnviromentPanel.setBaitGenerationRate(50);
        baitGenerationLabel.setText("Generates Bait once in " + EnviromentPanel.getBaitGenerationRate() +  " frames");
        baitGenerationSlider.setValue(50);
    }//GEN-LAST:event_DefaultButtonBaitGeneratorActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addPredatorFishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPredatorFishButtonActionPerformed
       
        Scanner sc = null;
        int r,g,b;
        try {
            sc = new Scanner(new FileReader("predatorFishconfig.txt"));
          
            float scale,maxVelocity;
            int xPos,yPos,startingEnergy,detectionRadius,energyUsage;
            Color newCreatureColor;
            boolean isSick;
            
            
            while(!"Predator_Fish".equals(sc.next())){
                sc.next();
            }
            sc.next();
            scale = sc.nextFloat();
            sc.next();
            
            xPos = sc.nextInt();
            sc.next();
            yPos = sc.nextInt();
            sc.next();
            startingEnergy = sc.nextInt();
            sc.next();
            r= sc.nextInt();
            sc.next();
            g = sc.nextInt();
            sc.next();
            b = sc.nextInt();
            newCreatureColor = new Color(r,g,b);
            sc.next();
            
            
            detectionRadius = sc.nextInt();
            sc.next();
            energyUsage = sc.nextInt();
            sc.next();
            
            maxVelocity = sc.nextFloat();
            sc.next();
            isSick = sc.nextBoolean();
           
            //Generate Predator Fish
            EnviromentPanel.generateParameteredPredatorFish(scale, newCreatureColor, xPos, yPos, startingEnergy, isSick, detectionRadius, energyUsage, maxVelocity);
          
            
        } catch (Exception e) {
            
            System.err.println("Err");
            
        }
        
        

    }//GEN-LAST:event_addPredatorFishButtonActionPerformed

    private void deleteDataNoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataNoButtonActionPerformed
        // TODO add your handling code here:
        clearDataDialog.setVisible(false);
    }//GEN-LAST:event_deleteDataNoButtonActionPerformed

    private void deleteDataYesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataYesButtonActionPerformed
        // TODO add your handling code here:
        
        //Clear data
        try {
        File file = new File("predatorFishconfig.txt");
        file.delete();
        file = new File("normalFishconfig.txt");
        file.delete();
        file = new File("baitConfig.txt");
        file.delete();
        file = new File("config.txt");
        file.delete();
        
        
        } catch (Exception e) {
       
            System.err.println("files_not_found");
        }
        
        clearDataDialog.setVisible(false);
        
    }//GEN-LAST:event_deleteDataYesButtonActionPerformed

    private void clearDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataButtonActionPerformed
        clearDataDialog.setVisible(true);
    }//GEN-LAST:event_clearDataButtonActionPerformed

    private void createNewTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewTemplateButtonActionPerformed
        CreateTemplateFrame addFrame = new CreateTemplateFrame();
        addFrame.setVisible(true);
    }//GEN-LAST:event_createNewTemplateButtonActionPerformed

    private void customScaleSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_customScaleSliderStateChanged
        EnviromentPanel.getHighlightedCreature().scaleFactor = (float)customScaleSlider.getValue()/10;
        customScaleSliderLabel.setText(String.valueOf((float)customScaleSlider.getValue()/10));
        
        
    }//GEN-LAST:event_customScaleSliderStateChanged

    private void propertiesMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesMenuButtonActionPerformed
        // TODO add your handling code here:
        propertiesDialog.setVisible(true);
        
    }//GEN-LAST:event_propertiesMenuButtonActionPerformed

    private void customDetectionSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_customDetectionSliderStateChanged
        // TODO add your handling code here:
        EnviromentPanel.getHighlightedCreature().detectionRadius = customDetectionSlider.getValue();
        customDetectionSliderLabel.setText(String.valueOf(customDetectionSlider.getValue()));
        
    }//GEN-LAST:event_customDetectionSliderStateChanged

    private void customEnergySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_customEnergySliderStateChanged
        // TODO add your handling code here:
        EnviromentPanel.getHighlightedCreature().totalEnergy = customEnergySlider.getValue();
        customEnergySliderLabel.setText(String.valueOf(customEnergySlider.getValue()));
        
    }//GEN-LAST:event_customEnergySliderStateChanged

    private void customColorPickerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customColorPickerButtonActionPerformed
        // TODO add your handling code here:
        EnviromentPanel.getHighlightedCreature().creatureColor = customColorPicker.getColor();
        
    }//GEN-LAST:event_customColorPickerButtonActionPerformed

    private void customSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customSaveButtonActionPerformed
        // TODO add your handling code here:
      
            int r,g,b;
                r = customColorPicker.getColor().getRed();
                g = customColorPicker.getColor().getGreen();
                b = customColorPicker.getColor().getBlue();
        try {
            Formatter formatterX = new Formatter("config.txt");
            
            formatterX.format("%s", "Saved_Vales \n");
            formatterX.format("%s", "Scale_Saved ");
            formatterX.format("%s\n", customScaleSlider.getValue());
            formatterX.format("%s", "Detection_Radius_Saved ");
            formatterX.format("%s\n", customDetectionSlider.getValue());
            formatterX.format("%s", "Energy_Saved ");
            formatterX.format("%s\n", customEnergySlider.getValue());
   
            formatterX.format("%s", "Color_R ");
            formatterX.format("%s\n", r);
            formatterX.format("%s", "Color_G ");
            formatterX.format("%s\n", g);
            formatterX.format("%s", "Color_B ");
            formatterX.format("%s\n", b);
            
            
            
            
            
            formatterX.close();
        
        } catch (Exception e) {
            System.err.println(r);   
        }
        







    }//GEN-LAST:event_customSaveButtonActionPerformed

    private void customLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customLoadButtonActionPerformed
        // TODO add your handling code here:
        BufferedReader br = null;
        Scanner sc = null;
        int r,g,b;
        try {
            sc = new Scanner(new FileReader("config.txt"));
          
       
            while(!"Saved_Vales".equals(sc.next())){
                sc.next();
            }
            sc.next();
            customScaleSlider.setValue(sc.nextInt());
            sc.next();
            customDetectionSlider.setValue(sc.nextInt());
            sc.next();
            customEnergySlider.setValue(sc.nextInt());
            sc.next();
            r = sc.nextInt();
            sc.next();
            g = sc.nextInt();
            sc.next();
            b = sc.nextInt();
            customColorPicker.setColor(new Color(r,g,b));
            EnviromentPanel.getHighlightedCreature().creatureColor = customColorPicker.getColor();
        } catch (Exception e) {
            
        }








    }//GEN-LAST:event_customLoadButtonActionPerformed

    private void propertiesDialogCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesDialogCloseButtonActionPerformed
        // TODO add your handling code here:
        propertiesDialog.setVisible(false);
    }//GEN-LAST:event_propertiesDialogCloseButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
                
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DefaultButtonBaitGenerator;
    private javax.swing.JMenuItem addBaitButton;
    private javax.swing.JMenuItem addFishButton;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem addPredatorFishButton;
    private javax.swing.JButton baitGenerationControllerCloseButton;
    private javax.swing.JLabel baitGenerationLabel;
    private javax.swing.JDialog baitGenerationRateController;
    private javax.swing.JSlider baitGenerationSlider;
    private javax.swing.JMenuItem baitGeneratorButton;
    private javax.swing.JMenuItem clearDataButton;
    private javax.swing.JDialog clearDataDialog;
    private javax.swing.JButton closeButton;
    private javax.swing.JMenuItem createNewTemplateButton;
    private javax.swing.JColorChooser customColorPicker;
    private javax.swing.JButton customColorPickerButton;
    private javax.swing.JSlider customDetectionSlider;
    private javax.swing.JLabel customDetectionSliderLabel;
    private javax.swing.JSlider customEnergySlider;
    private javax.swing.JLabel customEnergySliderLabel;
    private javax.swing.JButton customLoadButton;
    private javax.swing.JButton customSaveButton;
    private javax.swing.JSlider customScaleSlider;
    private javax.swing.JLabel customScaleSliderLabel;
    private javax.swing.JMenuItem decreaseFPSMenuItem;
    private javax.swing.JButton defaultButton;
    private javax.swing.JButton deleteDataNoButton;
    private javax.swing.JButton deleteDataYesButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel fpsLabel;
    private javax.swing.JSlider fpsSlider;
    private javax.swing.JDialog fpsSliderDialog;
    private javax.swing.JTextField frameTextField;
    private javax.swing.JButton frameTickButton;
    private javax.swing.JDialog frameTickDialog;
    private javax.swing.JMenu generalMenu;
    private javax.swing.JMenuItem increaseFPSMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openFPSSlider;
    private javax.swing.JDialog propertiesDialog;
    private javax.swing.JButton propertiesDialogCloseButton;
    private javax.swing.JMenuItem propertiesMenuButton;
    // End of variables declaration//GEN-END:variables
}


