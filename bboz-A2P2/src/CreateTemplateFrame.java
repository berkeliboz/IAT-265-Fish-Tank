
import javax.swing.JFrame;


public class CreateTemplateFrame extends javax.swing.JFrame {

    /**
     * Creates new form addFishFrame
     */
    public CreateTemplateFrame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nextKey = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        templateRadio2 = new javax.swing.JRadioButton();
        templateRadio3 = new javax.swing.JRadioButton();
        templateRadio1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nextKey.setText("Next");
        nextKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextKeyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Choose Type");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        templateRadio2.setText("Predator Fish");
        templateRadio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templateRadio2ActionPerformed(evt);
            }
        });

        templateRadio3.setText("Bait");
        templateRadio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templateRadio3ActionPerformed(evt);
            }
        });

        templateRadio1.setText("Vegeterian Fish");
        templateRadio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templateRadio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(templateRadio2)
                    .addComponent(templateRadio3)
                    .addComponent(templateRadio1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(templateRadio1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(templateRadio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(templateRadio3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextKey, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(nextKey)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void templateRadio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templateRadio3ActionPerformed
        // TODO add your handling code here:
        templateRadio1.setSelected(false);
        templateRadio2.setSelected(false);
        mainFrame.setChoosenString("Bait"); //Sets the key

    }//GEN-LAST:event_templateRadio3ActionPerformed

    private void templateRadio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templateRadio2ActionPerformed
        // TODO add your handling code here:
        templateRadio3.setSelected(false);
        templateRadio1.setSelected(false);
        
        mainFrame.setChoosenString("PredatorFish");//Sets the key

    }//GEN-LAST:event_templateRadio2ActionPerformed

    private void templateRadio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templateRadio1ActionPerformed
        // TODO add your handling code here:
        templateRadio3.setSelected(false);
        templateRadio2.setSelected(false);
        mainFrame.setChoosenString("Fish");//Sets the key
    }//GEN-LAST:event_templateRadio1ActionPerformed

    private void nextKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextKeyActionPerformed

        //Corresponding Frame is created according to the key values
        String objType = mainFrame.getChoosenString();
        if(objType == "Fish"){
            AddFishFrame fishFrame = new AddFishFrame();
            fishFrame.setVisible(true);
            this.setVisible(false);
        }
        else if(objType == "PredatorFish"){
            AddFishFrame fishFrame = new AddFishFrame();
            fishFrame.setVisible(true);
            this.setVisible(false);
        }
        else if(objType == "Bait"){
            this.setVisible(false);
            AddBaitFrame baitFrame = new AddBaitFrame();
            baitFrame.setVisible(true);
        }
        else{
            this.setVisible(true);
        }
        
        
    }//GEN-LAST:event_nextKeyActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nextKey;
    private javax.swing.JRadioButton templateRadio1;
    private javax.swing.JRadioButton templateRadio2;
    private javax.swing.JRadioButton templateRadio3;
    // End of variables declaration//GEN-END:variables
}
