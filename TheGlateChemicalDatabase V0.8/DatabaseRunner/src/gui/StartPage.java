package gui;

import javax.swing.*;
import databaserunner.*;

public class StartPage extends javax.swing.JFrame {

    //our fields
    private String elementsFile;
    private String binaryCompoundsFile;
    private String reactionsFile;
    
    private static int firstValence;
    private static int increment;
    private static boolean notFirstRun;
    
    private DatabaseGUI databaseGUI;
    
    //our accessors & mutators
    public String getElementsFile(){
        return this.elementsFile;
    }
    public void setElementsFile(String elementsFile){
        this.elementsFile = elementsFile;
    }
    
    public String getBinaryCompoundsFile(){
        return this.binaryCompoundsFile;
    }
    public void setBinaryCompoundsFile(String binaryCompoundsFile){
        this.binaryCompoundsFile = binaryCompoundsFile;
    }
    
    public String getReactionsFile(){
        return this.reactionsFile;
    }
    public void setReactionsFile(String reactionsFile){
        this.reactionsFile = reactionsFile;
    }
    
    /**
     * Creates new form Start
     */
    public StartPage(DatabaseGUI databaseGUI) {
        if (notFirstRun == false) {
            firstValence = PeriodicTable.DEFAULT_FIRST_VALENCE;
            increment = PeriodicTable.DEFAULT_INCREMENT;
        }
        this.databaseGUI = databaseGUI;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel("TITLE", SwingConstants.CENTER);
        jTextFieldElementsFileName = new javax.swing.JTextField();
        jComboBoxFirstValence = new javax.swing.JComboBox<>();
        jComboBoxIncrement = new javax.swing.JComboBox<>();
        jLabelIncrement = new javax.swing.JLabel();
        jLabelFirstValence = new javax.swing.JLabel();
        jLabelElementsFileName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelBinaryCompoundsFileName = new javax.swing.JLabel();
        jTextFieldBinaryCompoundsFileName = new javax.swing.JTextField();
        jLabelReactionsFileName = new javax.swing.JLabel();
        jTextFieldReactionsFileName = new javax.swing.JTextField();
        jLabelInfo1 = new javax.swing.JLabel();
        jLabelFirstValence1 = new javax.swing.JLabel();
        jLabelFirstValence2 = new javax.swing.JLabel();
        jLabelFirstValence3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setText("Welcome to The Chemical Database!");

        jTextFieldElementsFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldElementsFileName.setText("elements");

        jComboBoxFirstValence.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxFirstValence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBoxFirstValence.setSelectedItem("2");
        jComboBoxFirstValence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFirstValenceActionPerformed(evt);
            }
        });

        jComboBoxIncrement.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxIncrement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBoxIncrement.setSelectedItem("4");
        jComboBoxIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIncrementActionPerformed(evt);
            }
        });

        jLabelIncrement.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelIncrement.setText("Increment");

        jLabelFirstValence.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFirstValence.setText(".txt");

        jLabelElementsFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelElementsFileName.setText("*Elements File Name");

        jButtonSubmit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSubmit.setText("SUBMIT");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("INSTRUCTIONS");
        jScrollPane1.setViewportView(jTextArea1);

        jLabelBinaryCompoundsFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelBinaryCompoundsFileName.setText("Compounds File Name");

        jTextFieldBinaryCompoundsFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldBinaryCompoundsFileName.setText("compounds");

        jLabelReactionsFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelReactionsFileName.setText("Reactions File Name");

        jTextFieldReactionsFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldReactionsFileName.setText("reactions");

        jLabelInfo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelInfo1.setText("* = required field");

        jLabelFirstValence1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFirstValence1.setText("First Valence");

        jLabelFirstValence2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFirstValence2.setText(".txt");

        jLabelFirstValence3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFirstValence3.setText(".txt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabelTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInfo1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelElementsFileName)
                                    .addComponent(jLabelReactionsFileName)
                                    .addComponent(jLabelBinaryCompoundsFileName)
                                    .addComponent(jTextFieldBinaryCompoundsFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(jTextFieldElementsFileName)
                                    .addComponent(jTextFieldReactionsFileName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelFirstValence)
                                        .addGap(120, 120, 120)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxFirstValence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelFirstValence1))
                                        .addGap(86, 86, 86)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelIncrement)))
                                    .addComponent(jLabelFirstValence2)
                                    .addComponent(jLabelFirstValence3))))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIncrement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelElementsFileName)
                            .addComponent(jLabelFirstValence1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldElementsFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFirstValence)
                            .addComponent(jComboBoxFirstValence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelBinaryCompoundsFileName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBinaryCompoundsFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFirstValence3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelReactionsFileName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldReactionsFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFirstValence2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubmit)
                    .addComponent(jLabelInfo1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //SUBMIT button
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        if (notFirstRun == false)
            notFirstRun = true;
        
        this.elementsFile = this.jTextFieldElementsFileName.getText();
        this.binaryCompoundsFile = this.jTextFieldBinaryCompoundsFileName.getText();
        this.reactionsFile = this.jTextFieldReactionsFileName.getText();
        this.firstValence = Integer.parseInt((String)(this.jComboBoxFirstValence.getSelectedItem()));
        this.increment = Integer.parseInt((String)(this.jComboBoxIncrement.getSelectedItem()));
        
        char elementsFileCheck = this.databaseGUI.validateFile(elementsFile);
        char binaryCompoundFileCheck = this.databaseGUI.validateFile(binaryCompoundsFile);
        char reactionsFileCheck = this.databaseGUI.validateFile(reactionsFile);
        
        if(elementsFileCheck == DatabaseGUI.VALID_FILE && binaryCompoundFileCheck == DatabaseGUI.VALID_FILE && reactionsFileCheck == DatabaseGUI.VALID_FILE) {
            elementsFile = elementsFile + ".txt";
            binaryCompoundsFile = binaryCompoundsFile + ".txt";
            reactionsFile = reactionsFile + ".txt";
            
            this.databaseGUI.constructDatabase(elementsFile, binaryCompoundsFile, reactionsFile, firstValence, increment);       
            this.databaseGUI.startHomePage();
            this.setVisible(false);
        } else {
            String errorMessage = "";
            if(elementsFileCheck == DatabaseGUI.EMPTY_FILE){
                errorMessage = errorMessage + ("Elements File name cannot be blank!");
                errorMessage = errorMessage + ("\n");
            } else if(elementsFileCheck == DatabaseGUI.NAME_LENGTH_EXCEEDED) {
                errorMessage = errorMessage + ("Elements File name is too long!");
                errorMessage = errorMessage + ("\n");
            } else if (elementsFileCheck != DatabaseGUI.VALID_FILE) {
                errorMessage = errorMessage + ("Elements File name contains invalid character: '" + String.valueOf(elementsFileCheck) + "'");
                errorMessage = errorMessage + ("\n");
            }

            if(binaryCompoundFileCheck == DatabaseGUI.EMPTY_FILE){
                errorMessage = errorMessage + ("Compounds File name cannot be blank!");
                errorMessage = errorMessage + ("\n");
            } else if(binaryCompoundFileCheck == DatabaseGUI.NAME_LENGTH_EXCEEDED) {
                errorMessage = errorMessage + ("Compounds File name is too long!");
                errorMessage = errorMessage + ("\n");
            } else if (binaryCompoundFileCheck != DatabaseGUI.VALID_FILE) {
                errorMessage = errorMessage + ("Compounds File name contains invalid character: '" + String.valueOf(binaryCompoundFileCheck) + "'");
                errorMessage = errorMessage + ("\n");
            }  
            
            if(reactionsFileCheck == DatabaseGUI.EMPTY_FILE){
                errorMessage = errorMessage + ("Reactions File name cannot be blank!");
                errorMessage = errorMessage + ("\n");
            } else if(reactionsFileCheck == DatabaseGUI.NAME_LENGTH_EXCEEDED) {
                errorMessage = errorMessage + ("Reactions File name is too long!");
                errorMessage = errorMessage + ("\n");
            } else if (reactionsFileCheck != DatabaseGUI.VALID_FILE){
                errorMessage = errorMessage + ("Reactions File name contains invalid character: '" + String.valueOf(reactionsFileCheck) + "'");
                errorMessage = errorMessage + ("\n");
            }  
            JOptionPane.showMessageDialog(null, errorMessage);
        }
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jComboBoxFirstValenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFirstValenceActionPerformed
        if (notFirstRun == true)
            JOptionPane.showMessageDialog(null, "WARNING: If you change this property,\nit will reset a lot of reaction data!");
    }//GEN-LAST:event_jComboBoxFirstValenceActionPerformed

    private void jComboBoxIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIncrementActionPerformed
        if (notFirstRun == true)
            JOptionPane.showMessageDialog(null, "WARNING: If you change this property,\nit will reset a lot of reaction data!");
    }//GEN-LAST:event_jComboBoxIncrementActionPerformed

    public void start() {
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
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartPage(databaseGUI).setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox<String> jComboBoxFirstValence;
    private javax.swing.JComboBox<String> jComboBoxIncrement;
    private javax.swing.JLabel jLabelBinaryCompoundsFileName;
    private javax.swing.JLabel jLabelElementsFileName;
    private javax.swing.JLabel jLabelFirstValence;
    private javax.swing.JLabel jLabelFirstValence1;
    private javax.swing.JLabel jLabelFirstValence2;
    private javax.swing.JLabel jLabelFirstValence3;
    private javax.swing.JLabel jLabelIncrement;
    private javax.swing.JLabel jLabelInfo1;
    private javax.swing.JLabel jLabelReactionsFileName;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldBinaryCompoundsFileName;
    private javax.swing.JTextField jTextFieldElementsFileName;
    private javax.swing.JTextField jTextFieldReactionsFileName;
    // End of variables declaration//GEN-END:variables
}