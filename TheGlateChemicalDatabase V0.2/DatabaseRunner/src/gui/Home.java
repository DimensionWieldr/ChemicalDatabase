package gui;

import databaserunner.*;
import javax.swing.*;

public class Home extends javax.swing.JFrame {

    //our fields
    private static int numRow;
    private static int numCol;
    private static int firstValence;
    
    private static String[][] table;
    private static String[] header;
    
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    //our methods
    private static void createTable(){
        firstValence = DatabaseGUI.getDatabase().getPeriodicTable().getFirstValence();
        numRow = DatabaseGUI.getDatabase().getPeriodicTable().getNumRow() - 1;
        numCol = DatabaseGUI.getDatabase().getPeriodicTable().getNumCol();

        table = new String[numRow][numCol];
        header = new String[numCol];

        for(int i = 0; i < numCol; i++){
            header[i] = "" + (i + 1);
        }
        for(int i = 0; i < numRow; i++){
            for(int j = 0; j < DatabaseGUI.getDatabase().getPeriodicTable().getTable().get(i).numItems(); j++){
                table[i][j] = DatabaseGUI.getDatabase().getPeriodicTable().getTable().get(i).getPeriodElements()[j].getMolecularFormula();
            }
        }
        
        //move relevant items of each row to right end of table
        for(int i = 0; i < numRow; i++){
            int lastIndex = DatabaseGUI.getDatabase().getPeriodicTable().getTable().get(i).getPeriodElements().length - 1;
            if(lastIndex != numCol-1){
                table[i][numCol-1] = table[i][lastIndex];
                table[i][lastIndex] = null;
                for (int j = lastIndex - 1 ; j > firstValence - 1 ; j--) {
                    table[i][numCol - lastIndex + j - 1] = table[i][j];
                    table[i][j] = null;
                }
            }
        }
        for(int i = firstValence / 2; i <= firstValence - 2; i++){
            table[0][numCol-firstValence+i] = table[0][i];
            table[0][i] = null;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePeriodicTable = new javax.swing.JTable();
        jLabelMolecularFormula = new javax.swing.JLabel();
        jLabelCommonName = new javax.swing.JLabel();
        jLabelNumProton = new javax.swing.JLabel();
        jLabelNumElectron = new javax.swing.JLabel();
        jLabelNumNeutron = new javax.swing.JLabel();
        jLabelMolarMass = new javax.swing.JLabel();
        jLabelStpState = new javax.swing.JLabel();
        jLabelStpDensity = new javax.swing.JLabel();
        jLabelMP = new javax.swing.JLabel();
        jLabelBP = new javax.swing.JLabel();
        jLabelIonizationEnergy = new javax.swing.JLabel();
        jLabelElectronegativity = new javax.swing.JLabel();
        jLabelColour = new javax.swing.JLabel();
        jButtonReload = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonAddElement = new javax.swing.JButton();
        jButtonRemoveChemical = new javax.swing.JButton();
        jButtonSearchChemical = new javax.swing.JButton();
        jButtonSortChemicals = new javax.swing.JButton();
        jButtonSimulateReaction = new javax.swing.JButton();
        jButtonListReactions = new javax.swing.JButton();
        jButtonListChemicals = new javax.swing.JButton();
        jButtonGenerateChart = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelOxidationNum = new javax.swing.JLabel();
        jButtonAddBinaryCompound = new javax.swing.JButton();
        jTextFieldRemoveChemical = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setText("Periodic Table of Elements");

        jTablePeriodicTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePeriodicTable.setModel(new javax.swing.table.DefaultTableModel(
            table,
            header
        ));
        jTablePeriodicTable.setEnabled(false);
        jTablePeriodicTable.setRowSelectionAllowed(false);
        jTablePeriodicTable.getTableHeader().setResizingAllowed(false);
        jTablePeriodicTable.getTableHeader().setReorderingAllowed(false);
        jTablePeriodicTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePeriodicTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePeriodicTable);

        jLabelMolecularFormula.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMolecularFormula.setText("X");

        jLabelCommonName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCommonName.setText("Name:");

        jLabelNumProton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumProton.setText("Atomic #:");

        jLabelNumElectron.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumElectron.setText("Electrons:");

        jLabelNumNeutron.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumNeutron.setText("Neutrons:");

        jLabelMolarMass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMolarMass.setText("Molar Mass:");

        jLabelStpState.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelStpState.setText("State @ STP:");

        jLabelStpDensity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelStpDensity.setText("Density @ STP:");

        jLabelMP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMP.setText("Melting Point:");

        jLabelBP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBP.setText("Boiling Point:");

        jLabelIonizationEnergy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIonizationEnergy.setText("First Ionization Energy:");

        jLabelElectronegativity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelElectronegativity.setText("Electronegativity:");

        jLabelColour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelColour.setText("Colour: ");

        jButtonReload.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonReload.setText("Reload");
        jButtonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadActionPerformed(evt);
            }
        });

        jButtonSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonAddElement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddElement.setText("Add Element");
        jButtonAddElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddElementActionPerformed(evt);
            }
        });

        jButtonRemoveChemical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRemoveChemical.setText("Remove Chemical");
        jButtonRemoveChemical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveChemicalActionPerformed(evt);
            }
        });

        jButtonSearchChemical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSearchChemical.setText("Search Chemical");
        jButtonSearchChemical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchChemicalActionPerformed(evt);
            }
        });

        jButtonSortChemicals.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSortChemicals.setText("Sort Chemicals");
        jButtonSortChemicals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortChemicalsActionPerformed(evt);
            }
        });

        jButtonSimulateReaction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSimulateReaction.setText("Simulate Reaction");
        jButtonSimulateReaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimulateReactionActionPerformed(evt);
            }
        });

        jButtonListReactions.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonListReactions.setText("List Reactions");
        jButtonListReactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListReactionsActionPerformed(evt);
            }
        });

        jButtonListChemicals.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonListChemicals.setText("List Chemicals");
        jButtonListChemicals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListChemicalsActionPerformed(evt);
            }
        });

        jButtonGenerateChart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonGenerateChart.setText("gEnErAtE ChArT");

        jLabelOxidationNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelOxidationNum.setText("Oxidation Number:");

        jButtonAddBinaryCompound.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddBinaryCompound.setText("Add Compound");
        jButtonAddBinaryCompound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBinaryCompoundActionPerformed(evt);
            }
        });

        jTextFieldRemoveChemical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRemoveChemical.setText("Chemical Name");

        jLabel1.setText(" > > >");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCommonName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNumProton)
                                .addGap(49, 49, 49)
                                .addComponent(jLabelNumElectron)
                                .addGap(55, 55, 55)
                                .addComponent(jLabelNumNeutron))
                            .addComponent(jLabelStpState)
                            .addComponent(jLabelMolarMass)
                            .addComponent(jLabelColour)
                            .addComponent(jLabelStpDensity)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMP)
                                .addGap(68, 68, 68)
                                .addComponent(jLabelBP))
                            .addComponent(jLabelIonizationEnergy)
                            .addComponent(jLabelElectronegativity)
                            .addComponent(jLabelMolecularFormula)
                            .addComponent(jLabelOxidationNum))
                        .addGap(118, 118, 118)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSearchChemical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonListChemicals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSimulateReaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddElement, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRemoveChemical, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonListReactions, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButtonSortChemicals, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButtonGenerateChart, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButtonAddBinaryCompound, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jTextFieldRemoveChemical))
                        .addGap(57, 57, 57))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitle)
                .addGap(301, 301, 301))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabelMolecularFormula)
                                .addGap(14, 14, 14)
                                .addComponent(jLabelCommonName)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNumProton)
                                    .addComponent(jLabelNumElectron)
                                    .addComponent(jLabelNumNeutron))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelMolarMass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStpState)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStpDensity)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelMP)
                                    .addComponent(jLabelBP))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelIonizationEnergy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelElectronegativity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelColour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelOxidationNum)
                                .addContainerGap(32, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReload)
                            .addComponent(jButtonSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddElement)
                            .addComponent(jButtonAddBinaryCompound))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRemoveChemical)
                            .addComponent(jTextFieldRemoveChemical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSearchChemical)
                            .addComponent(jButtonSortChemicals))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonListChemicals)
                            .addComponent(jButtonListReactions))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSimulateReaction)
                            .addComponent(jButtonGenerateChart))
                        .addGap(53, 53, 53))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //runs when user selects element from table
    private void jTablePeriodicTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePeriodicTableMousePressed
        //get selected row & column from mouse
        int row = jTablePeriodicTable.rowAtPoint(evt.getPoint());
        int col = jTablePeriodicTable.columnAtPoint(evt.getPoint());
        
        if(table[row][col] != null){
            //display all properties of the element the user clicked on
            Element selectedElement = DatabaseGUI.getDatabase().searchElementByMolecularFormula(table[row][col]);
            this.jLabelMolecularFormula.setText(selectedElement.getMolecularFormula());
            this.jLabelCommonName.setText("Name: " + selectedElement.getCommonName());
            this.jLabelNumProton.setText("Atomic #: " + selectedElement.getNumProton());
            this.jLabelNumElectron.setText("Electrons: " + selectedElement.getNumElectron());
            this.jLabelNumNeutron.setText("Neutrons: " + selectedElement.getNumNeutron());
            this.jLabelMolarMass.setText("Molar Mass: " + selectedElement.getMolarMass() + " g/mol");
            this.jLabelStpState.setText("State @ STP: " + selectedElement.getStpState());
            this.jLabelStpDensity.setText("Density @ STP: " + selectedElement.getStpDensity() + " g/L");
            this.jLabelMP.setText("Melting Point: " + selectedElement.getMP() + " C");
            this.jLabelBP.setText("Boiling Point: " + selectedElement.getBP() + " C");
            this.jLabelIonizationEnergy.setText("First Ionization Energy: " + selectedElement.getIonizationEnergy());
            this.jLabelElectronegativity.setText("Electronegativity: " + selectedElement.getElectronegativity());
            this.jLabelColour.setText("Colour: " + selectedElement.getColour());
            this.jLabelOxidationNum.setText("Oxidation Number: " + selectedElement.getOxidationNum());
        }
    }//GEN-LAST:event_jTablePeriodicTableMousePressed

    //Reload button
    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        DatabaseGUI databaseGUI = new DatabaseGUI();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonReloadActionPerformed

    //Save button
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if(DatabaseGUI.getDatabase().save(Start.getElementsFile(), Start.getBinaryCompoundsFile(), Start.getReactionsFile()))
            JOptionPane.showMessageDialog(null, "File saved!");
        else
            JOptionPane.showMessageDialog(null, "There was an error saving the file!");
    }//GEN-LAST:event_jButtonSaveActionPerformed

    //Add Element button
    private void jButtonAddElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddElementActionPerformed
        DatabaseGUI.startAddElement();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddElementActionPerformed

    //Remove Chemical button
    private void jButtonRemoveChemicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveChemicalActionPerformed
        String name = jTextFieldRemoveChemical.getText();
        if(DatabaseGUI.removeChemical(name)){
            this.setVisible(false);
        }else
            JOptionPane.showMessageDialog(null, name + " not found!");
    }//GEN-LAST:event_jButtonRemoveChemicalActionPerformed

    //Search Chemical button
    private void jButtonSearchChemicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchChemicalActionPerformed
        DatabaseGUI.startSearchChemical();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSearchChemicalActionPerformed

    //Sort Chemicals button
    private void jButtonSortChemicalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortChemicalsActionPerformed
        DatabaseGUI.startSortChemicals();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSortChemicalsActionPerformed

    //List Chemicals button
    private void jButtonListChemicalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListChemicalsActionPerformed
        DatabaseGUI.startListChemicals();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonListChemicalsActionPerformed

    //List Reactions button
    private void jButtonListReactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListReactionsActionPerformed
        DatabaseGUI.startListReactions();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonListReactionsActionPerformed

    //Add Compound button
    private void jButtonAddBinaryCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddBinaryCompoundActionPerformed
        DatabaseGUI.startAddBinaryCompound();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddBinaryCompoundActionPerformed

    //Simulate Reaction button
    private void jButtonSimulateReactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimulateReactionActionPerformed
        DatabaseGUI.startSimulateReaction();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSimulateReactionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void start() {
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
        
        createTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddBinaryCompound;
    private javax.swing.JButton jButtonAddElement;
    private javax.swing.JButton jButtonGenerateChart;
    private javax.swing.JButton jButtonListChemicals;
    private javax.swing.JButton jButtonListReactions;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonRemoveChemical;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearchChemical;
    private javax.swing.JButton jButtonSimulateReaction;
    private javax.swing.JButton jButtonSortChemicals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelColour;
    private javax.swing.JLabel jLabelCommonName;
    private javax.swing.JLabel jLabelElectronegativity;
    private javax.swing.JLabel jLabelIonizationEnergy;
    private javax.swing.JLabel jLabelMP;
    private javax.swing.JLabel jLabelMolarMass;
    private javax.swing.JLabel jLabelMolecularFormula;
    private javax.swing.JLabel jLabelNumElectron;
    private javax.swing.JLabel jLabelNumNeutron;
    private javax.swing.JLabel jLabelNumProton;
    private javax.swing.JLabel jLabelOxidationNum;
    private javax.swing.JLabel jLabelStpDensity;
    private javax.swing.JLabel jLabelStpState;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePeriodicTable;
    private javax.swing.JTextField jTextFieldRemoveChemical;
    // End of variables declaration//GEN-END:variables
}
