/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author berke
 */
public class AddFishFrame extends javax.swing.JFrame {

    
    //Local variable declerations for saving data
    static float scale = 1f;
    static boolean isAdvanced = false;
    static int xPos = 500;
    static int yPos = 500;
    static int startingEnergy = 1000;
    static Color newCreatureColor = Color.CYAN;
    static int detectionRadius = 550;
    static int energyUsage = 10;
    static float maxVelocity = 10f;
    static boolean isSick = false;
    static int stripeNumber = 0;
    
    private static Formatter formatterX;
    
    /**
     * Creates new form addNormalFishFrame
     */
    public AddFishFrame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanel2.setVisible(false);
        confirmationDialog.setSize(320, 180);
        xPosLabel.setText(String.valueOf(xPos));
        yPosLabel.setText(String.valueOf(yPos));
        energyLabel.setText(String.valueOf(startingEnergy));
        scaleLabel.setText(String.valueOf(scale));

        stripePanel.setVisible(false);
        if("Fish".equals(mainFrame.getChoosenString()))
            stripePanel.setVisible(true);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        confirmationDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        noButton = new javax.swing.JButton();
        yesButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        xPosSlider = new javax.swing.JSlider(150,1800,500);
        yPosSlider = new javax.swing.JSlider(150,900,500);
        jLabel4 = new javax.swing.JLabel();
        colorChooserPanel = new javax.swing.JColorChooser();
        jLabel5 = new javax.swing.JLabel();
        startEnergySlider = new javax.swing.JSlider(0,2000,1000);
        nextButton = new javax.swing.JButton();
        toggleAdvancedButton = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        detectionRadiusField = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        energyUsageField = new javax.swing.JTextField();
        maxVelocitySlider = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        editScale = new javax.swing.JSlider(1,200,100);
        stripePanel = new javax.swing.JPanel();
        stripeNumberButton0 = new javax.swing.JRadioButton();
        stripeNumberButton1 = new javax.swing.JRadioButton();
        stripeNumberButton2 = new javax.swing.JRadioButton();
        stripeNumberButton3 = new javax.swing.JRadioButton();
        stripeNumberLabel = new javax.swing.JLabel();
        scaleLabel = new javax.swing.JLabel();
        xPosLabel = new javax.swing.JLabel();
        yPosLabel = new javax.swing.JLabel();
        energyLabel = new javax.swing.JLabel();

        jLabel9.setText("Create Fish Instance from Template now ?");

        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Template Saved!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(yesButton)
                        .addGap(68, 68, 68)
                        .addComponent(noButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesButton)
                    .addComponent(noButton))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout confirmationDialogLayout = new javax.swing.GroupLayout(confirmationDialog.getContentPane());
        confirmationDialog.getContentPane().setLayout(confirmationDialogLayout);
        confirmationDialogLayout.setHorizontalGroup(
            confirmationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        confirmationDialogLayout.setVerticalGroup(
            confirmationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Edit Scale");

        jLabel2.setText("X Position");

        jLabel3.setText("Y Position");

        xPosSlider.setPaintTicks(true);

        Hashtable<Integer, JLabel> labelTable =  new Hashtable<Integer, JLabel>();
        labelTable.put(new Integer( 500 ), new JLabel("0") );
        labelTable.put(new Integer( 900 ), new JLabel("1080") );
        xPosSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xPosSliderStateChanged(evt);
            }
        });

        yPosSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                yPosSliderStateChanged(evt);
            }
        });

        jLabel4.setText("Color");

        colorChooserPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorChooserPanel.setPreviewPanel(new javax.swing.JPanel());

        jLabel5.setText("Starting Energy");

        startEnergySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startEnergySliderStateChanged(evt);
            }
        });

        nextButton.setText("Save");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        toggleAdvancedButton.setText("Toggle Advanced");
        toggleAdvancedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleAdvancedButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Detection Radius");

        detectionRadiusField.setText("800");
        detectionRadiusField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                detectionRadiusFieldFocusLost(evt);
            }
        });
        detectionRadiusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectionRadiusFieldActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Spawn Sick");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Energy Usage per frame");

        energyUsageField.setText("1000");
        energyUsageField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                energyUsageFieldFocusLost(evt);
            }
        });

        jLabel6.setText("Max Velocity");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(energyUsageField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(detectionRadiusField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(maxVelocitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(detectionRadiusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(energyUsageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxVelocitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(19, 19, 19))
        );

        editScale.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editScaleStateChanged(evt);
            }
        });

        stripePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        stripeNumberButton0.setText("No Stripes");
        stripeNumberButton0.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stripeNumberButton0StateChanged(evt);
            }
        });

        stripeNumberButton1.setText("1 Stripe");
        stripeNumberButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stripeNumberButton1StateChanged(evt);
            }
        });

        stripeNumberButton2.setText("2 Stripes");
        stripeNumberButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stripeNumberButton2StateChanged(evt);
            }
        });

        stripeNumberButton3.setText("3 Stripes");
        stripeNumberButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stripeNumberButton3StateChanged(evt);
            }
        });

        stripeNumberLabel.setText("Stripe Number");

        javax.swing.GroupLayout stripePanelLayout = new javax.swing.GroupLayout(stripePanel);
        stripePanel.setLayout(stripePanelLayout);
        stripePanelLayout.setHorizontalGroup(
            stripePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stripePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stripeNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(stripePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stripeNumberButton3)
                    .addComponent(stripeNumberButton2)
                    .addComponent(stripeNumberButton1)
                    .addComponent(stripeNumberButton0))
                .addGap(16, 16, 16))
        );
        stripePanelLayout.setVerticalGroup(
            stripePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stripePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stripePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stripeNumberButton0)
                    .addComponent(stripeNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stripeNumberButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stripeNumberButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stripeNumberButton3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        scaleLabel.setText("Scale");

        xPosLabel.setText("X Pos");

        yPosLabel.setText("Y Pos");

        energyLabel.setText("Energy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stripePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colorChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(toggleAdvancedButton)
                                .addGap(18, 18, 18)
                                .addComponent(nextButton))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(editScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(scaleLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(xPosSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(xPosLabel))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(yPosSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(yPosLabel)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startEnergySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(energyLabel)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(startEnergySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(energyLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scaleLabel)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xPosSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(xPosLabel))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yPosLabel)
                            .addComponent(jLabel3)
                            .addComponent(yPosSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextButton)
                            .addComponent(toggleAdvancedButton))
                        .addContainerGap())
                    .addComponent(stripePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        //DELETE
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    //Toggles advanced settings
    private void toggleAdvancedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleAdvancedButtonActionPerformed
       isAdvanced = !isAdvanced;
       if(isAdvanced){
           jPanel2.setVisible(true);
       }else{
           jPanel2.setVisible(false);
       }
       
    }//GEN-LAST:event_toggleAdvancedButtonActionPerformed

    private void xPosSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xPosSliderStateChanged
        xPos = xPosSlider.getValue();                       //Gets the value from the slider
        xPosLabel.setText(String.valueOf(xPos));            //Sets the text

    }//GEN-LAST:event_xPosSliderStateChanged

    private void yPosSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_yPosSliderStateChanged
        yPos = yPosSlider.getValue();                       //Gets the value from the slider
        yPosLabel.setText(String.valueOf(yPos));            //Sets the text
    }//GEN-LAST:event_yPosSliderStateChanged

    private void startEnergySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startEnergySliderStateChanged
        startingEnergy = startEnergySlider.getValue();      //Gets the value from the slider
        energyLabel.setText(String.valueOf(startingEnergy));//Sets the text
        
    }//GEN-LAST:event_startEnergySliderStateChanged

    private void editScaleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editScaleStateChanged
        scale = (float)editScale.getValue()/100;
        scaleLabel.setText(String.valueOf(scale));
        
        
    }//GEN-LAST:event_editScaleStateChanged

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        newCreatureColor = colorChooserPanel.getColor();
        
        confirmationDialog.setVisible(true);
        if("Fish".equals(mainFrame.getChoosenString())) //According to key in mainFrame, Fish or PredatorFish is created
            writeFishToFile();
        else{
            writePreFishToFile();
        }
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void detectionRadiusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectionRadiusFieldActionPerformed
        // TODO add your handling code here:
        //DELETE
    }//GEN-LAST:event_detectionRadiusFieldActionPerformed

    private void detectionRadiusFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detectionRadiusFieldFocusLost
          detectionRadius =  Integer.parseInt(detectionRadiusField.getText());  //Sets value when focus is lost
  

    }//GEN-LAST:event_detectionRadiusFieldFocusLost

    private void energyUsageFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_energyUsageFieldFocusLost
        // TODO add your handling code here:
        energyUsage =  Integer.parseInt(energyUsageField.getText());    //Sets value when focus is lost
  
    }//GEN-LAST:event_energyUsageFieldFocusLost

    private void stripeNumberButton0StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_stripeNumberButton0StateChanged
        // TODO add your handling code here:
        stripeNumberButton1.setSelected(false);
        stripeNumberButton2.setSelected(false);
        stripeNumberButton3.setSelected(false);
        stripeNumber = 0;
        
    }//GEN-LAST:event_stripeNumberButton0StateChanged

    private void stripeNumberButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_stripeNumberButton1StateChanged
        // TODO add your handling code here:
        stripeNumberButton0.setSelected(false);
        stripeNumberButton2.setSelected(false);
        stripeNumberButton3.setSelected(false);
        stripeNumber = 1;
        

    }//GEN-LAST:event_stripeNumberButton1StateChanged

    private static void readFishFromFile(){
        Scanner sc = null;
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
            maxVelocity = sc.nextInt();
            sc.next();
            isSick = sc.nextBoolean();
            sc.next();
            stripeNumber = sc.nextInt();
        
        } catch (Exception e) {
            
        }
        
    }
    
    public static void writeFishToFile(){
        try {
            formatterX = new Formatter("normalFishconfig.txt");
            
            formatterX.format("%s", "Normal_Fish \n");
            formatterX.format("%s", "Normal_Fish_Scale ");
            formatterX.format("%s\n", scale);
            formatterX.format("%s", "Normal_Fish_xPos ");
            formatterX.format("%s\n", xPos);
            formatterX.format("%s", "Normal_Fish_yPos ");
            formatterX.format("%s\n", yPos);
            formatterX.format("%s", "Normal_Fish_startingEnergy ");
            formatterX.format("%s\n", startingEnergy);
            formatterX.format("%s", "Normal_Fish_newCreatureColor_R ");
            formatterX.format("%s\n", newCreatureColor.getRed());
            formatterX.format("%s", "Normal_Fish_newCreatureColor_G ");
            formatterX.format("%s\n", newCreatureColor.getGreen());
            formatterX.format("%s", "Normal_Fish_newCreatureColor_B ");
            formatterX.format("%s\n", newCreatureColor.getBlue());
            formatterX.format("%s", "Normal_Fish_detectionRadius ");
            formatterX.format("%s\n", detectionRadius);
            formatterX.format("%s", "Normal_Fish_energyUsage ");
            formatterX.format("%s\n", energyUsage);
            formatterX.format("%s", "Normal_Fish_maxVelocity ");
            formatterX.format("%s\n", maxVelocity);
            formatterX.format("%s", "Normal_Fish_isSick ");
            formatterX.format("%s\n", isSick);
            formatterX.format("%s", "Normal_Fish_stripeNumber ");
            formatterX.format("%s\n", stripeNumber);
            
            formatterX.close();
            
        
            readFishFromFile();
        
        } catch (Exception e) {
            
        }
        
        
        
    }
    
    
private static void readPredatorFishFromFile(){
        Scanner sc = null;
        int r,g,b;
        try {
            sc = new Scanner(new FileReader("predatorFishconfig.txt"));
          
       
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
            maxVelocity = sc.nextInt();
            sc.next();
            isSick = sc.nextBoolean();
           
        
        } catch (Exception e) {
            
        }
        
    }
    
    

    
    public static void writePreFishToFile(){
        try {
            formatterX = new Formatter("predatorFishconfig.txt");
            
            formatterX.format("%s", "Predator_Fish \n");
            formatterX.format("%s", "Predator_Fish_Scale ");
            formatterX.format("%s\n", scale);
            formatterX.format("%s", "Predator_Fish_xPos ");
            formatterX.format("%s\n", xPos);
            formatterX.format("%s", "Predator_Fish_yPos ");
            formatterX.format("%s\n", yPos);
            formatterX.format("%s", "Predator_Fish_startingEnergy ");
            formatterX.format("%s\n", startingEnergy);
            formatterX.format("%s", "Predator_Fish_newCreatureColor_R ");
            formatterX.format("%s\n", newCreatureColor.getRed());
            formatterX.format("%s", "Predator_Fish_newCreatureColor_G ");
            formatterX.format("%s\n", newCreatureColor.getGreen());
            formatterX.format("%s", "Predator_Fish_newCreatureColor_B ");
            formatterX.format("%s\n", newCreatureColor.getBlue());
            formatterX.format("%s", "Predator_Fish_detectionRadius ");
            formatterX.format("%s\n", detectionRadius);
            formatterX.format("%s", "Predator_Fish_energyUsage ");
            formatterX.format("%s\n", energyUsage);
            formatterX.format("%s", "Predator_Fish_maxVelocity ");
            formatterX.format("%s\n", maxVelocity);
            formatterX.format("%s", "Predator_Fish_isSick ");
            formatterX.format("%s\n", isSick);
            
            formatterX.close();
            
        
            readPredatorFishFromFile();
        
        } catch (Exception e) {
            
        }
        
        
        
    }
    
    private void stripeNumberButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_stripeNumberButton2StateChanged
        // TODO add your handling code here:
        stripeNumberButton1.setSelected(false);
        stripeNumberButton0.setSelected(false);
        stripeNumberButton3.setSelected(false);
        stripeNumber = 2;
        

    }//GEN-LAST:event_stripeNumberButton2StateChanged

    private void stripeNumberButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_stripeNumberButton3StateChanged
        // TODO add your handling code here:
        stripeNumberButton1.setSelected(false);
        stripeNumberButton2.setSelected(false);
        stripeNumberButton0.setSelected(false);
        stripeNumber = 3;
        

    }//GEN-LAST:event_stripeNumberButton3StateChanged

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        // TODO add your handling code here:
        confirmationDialog.setVisible(false);
        this.setVisible(false);
        
                                                          //Sets value according to the key value
        if("Fish".equals(mainFrame.getChoosenString()))
         EnviromentPanel.generateParameteredFish(scale, newCreatureColor, stripeNumber, xPos, yPos, startingEnergy, isSick, detectionRadius, energyUsage, maxVelocity);
        else{
            EnviromentPanel.generateParameteredPredatorFish(scale, newCreatureColor, xPos, yPos, startingEnergy, isSick, detectionRadius, energyUsage, maxVelocity);
        }
    }//GEN-LAST:event_yesButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        this.setVisible(false);
        confirmationDialog.setVisible(false);        
    }//GEN-LAST:event_noButtonActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser colorChooserPanel;
    private javax.swing.JDialog confirmationDialog;
    private javax.swing.JTextField detectionRadiusField;
    private javax.swing.JSlider editScale;
    private javax.swing.JLabel energyLabel;
    private javax.swing.JTextField energyUsageField;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider maxVelocitySlider;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton noButton;
    private javax.swing.JLabel scaleLabel;
    private javax.swing.JSlider startEnergySlider;
    private javax.swing.JRadioButton stripeNumberButton0;
    private javax.swing.JRadioButton stripeNumberButton1;
    private javax.swing.JRadioButton stripeNumberButton2;
    private javax.swing.JRadioButton stripeNumberButton3;
    private javax.swing.JLabel stripeNumberLabel;
    private javax.swing.JPanel stripePanel;
    private javax.swing.JToggleButton toggleAdvancedButton;
    private javax.swing.JLabel xPosLabel;
    private javax.swing.JSlider xPosSlider;
    private javax.swing.JLabel yPosLabel;
    private javax.swing.JSlider yPosSlider;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
