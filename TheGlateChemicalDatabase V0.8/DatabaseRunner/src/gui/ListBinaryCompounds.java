package gui;

import databaserunner.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class ListBinaryCompounds extends javax.swing.JFrame implements WindowListener {

    //our fields
    private List<BinaryCompound> compounds;
    private String[] names;
    
    private DatabaseGUI databaseGUI;
    
    /**
     * Creates new form ListBinaryCompounds
     */
    public ListBinaryCompounds(DatabaseGUI databaseGUI) {
        this.databaseGUI = databaseGUI;
        if (this.databaseGUI.getDatabase() != null)
            createList();
        else
            names = new String[DatabaseGUI.DEFAULT_ARRAY_SIZE];
        initComponents();
        
        if (DatabaseGUI.getMadeChanges()) {
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    databaseGUI.savePrompt(true);
                }
            });
        }
    }

    //our methods
    private void createList(){
        this.compounds = this.databaseGUI.listBinaryCompounds();
        this.names = new String[this.compounds.size()];
        
        for(int i = 0; i < names.length; i++){
            this.names[i] = this.compounds.get(i).getCommonName();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jListBinaryCompounds = new javax.swing.JList<>();
        jLabelTitle = new javax.swing.JLabel();
        jLabelCommonName = new javax.swing.JLabel();
        jLabelMolarMass = new javax.swing.JLabel();
        jLabelStpState = new javax.swing.JLabel();
        jLabelStpDensity = new javax.swing.JLabel();
        jLabelBP = new javax.swing.JLabel();
        jLabelMP = new javax.swing.JLabel();
        jLabelColour = new javax.swing.JLabel();
        jLabelCharge = new javax.swing.JLabel();
        jLabelMolecularFormula = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListBinaryCompounds.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jListBinaryCompounds.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = names;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListBinaryCompounds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListBinaryCompoundsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListBinaryCompounds);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setText("List Compounds");

        jLabelCommonName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCommonName.setText("Name:");

        jLabelMolarMass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMolarMass.setText("Molar Mass (g/mol):");

        jLabelStpState.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStpState.setText("State @ STP:");

        jLabelStpDensity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStpDensity.setText("Density @ STP (g/L):");

        jLabelBP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBP.setText("Boiling Point (C):");

        jLabelMP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMP.setText("Melting Point (C):");

        jLabelColour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelColour.setText("Colour:");

        jLabelCharge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCharge.setText("Charge:");

        jLabelMolecularFormula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMolecularFormula.setText("Composition:");

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSearch.setText("Compound Name");

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCommonName)
                            .addComponent(jLabelMolecularFormula)
                            .addComponent(jLabelCharge)
                            .addComponent(jLabelMolarMass)
                            .addComponent(jLabelStpState)
                            .addComponent(jLabelStpDensity)
                            .addComponent(jLabelBP)
                            .addComponent(jLabelMP)
                            .addComponent(jLabelColour)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jButtonBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitle)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBack)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCommonName)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMolecularFormula)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCharge)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMolarMass)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelStpState)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelStpDensity)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelBP)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMP)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelColour)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Back button
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.databaseGUI.startHomePage();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonBackActionPerformed

    //runs when user selects compound from list
    private void jListBinaryCompoundsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListBinaryCompoundsMousePressed
        //get compound index
        int index = jListBinaryCompounds.getSelectedIndex();
        
        //display compound information
        if(index != -1){
            this.jLabelCommonName.setText("Name: " + compounds.get(index).getCommonName());
            this.jLabelMolecularFormula.setText("Composition: " + compounds.get(index).getMolecularFormula());
            this.jLabelCharge.setText("Charge: " + compounds.get(index).getCharge());
            this.jLabelMolarMass.setText("Molar Mass (g/mol): " + compounds.get(index).getMolarMass());
            
            if (compounds.get(index).getStpState() == Chemical.DEFAULT_STATE)
                this.jLabelStpState.setText("State @ STP: " + Chemical.DEFAULT_COMMON_NAME);
            else
                this.jLabelStpState.setText("State @ STP: " + compounds.get(index).getStpState());
            
            if (compounds.get(index).getStpDensity() == Chemical.DEFAULT_DENSITY)
                this.jLabelStpDensity.setText("Density @ STP (g/L): " + Chemical.DEFAULT_COMMON_NAME);
            else
                this.jLabelStpDensity.setText("Density @ STP (g/L): " + compounds.get(index).getStpDensity());
            
            if (compounds.get(index).getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                this.jLabelMP.setText("Melting Point (C): " + Chemical.DEFAULT_COMMON_NAME);
            else
                this.jLabelMP.setText("Melting Point (C): " + compounds.get(index).getMP());
            
            if (compounds.get(index).getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                this.jLabelBP.setText("Boiling Point (C): " + Chemical.DEFAULT_COMMON_NAME);
            else
                this.jLabelBP.setText("Boiling Point (C): " + compounds.get(index).getBP());
            
            this.jLabelColour.setText("Colour: " + compounds.get(index).getColour());
        }
    }//GEN-LAST:event_jListBinaryCompoundsMousePressed

    //Search button
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String name = jTextFieldSearch.getText();
        Chemical search = this.databaseGUI.searchChemicalsByName(name);
        if(search != null && search instanceof BinaryCompound){
            BinaryCompound finalSearch = (BinaryCompound)search;
            this.jLabelCommonName.setText("Name: " + finalSearch.getCommonName());
            this.jLabelMolecularFormula.setText("Composition: " + finalSearch.getMolecularFormula());
            if (finalSearch.getCharge() > 0)
                this.jLabelCharge.setText("Charge: +" + finalSearch.getCharge());
            else
                this.jLabelCharge.setText("Charge: " + finalSearch.getCharge());
            this.jLabelMolarMass.setText("Molar Mass (g/mol): " + finalSearch.getMolarMass());
            this.jLabelStpState.setText("State @ STP: " + finalSearch.getStpState());
            this.jLabelStpDensity.setText("Density @ STP (g/L): " + finalSearch.getStpDensity());
            this.jLabelBP.setText("Boiling Point (C): " + finalSearch.getBP());
            this.jLabelMP.setText("Melting Point (C): " + finalSearch.getMP());
            this.jLabelColour.setText("Colour: " + finalSearch.getColour());
        }else
            JOptionPane.showMessageDialog(null, name + " not found!");
    }//GEN-LAST:event_jButtonSearchActionPerformed

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
            java.util.logging.Logger.getLogger(ListBinaryCompounds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListBinaryCompounds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListBinaryCompounds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListBinaryCompounds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListBinaryCompounds(databaseGUI).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelCharge;
    private javax.swing.JLabel jLabelColour;
    private javax.swing.JLabel jLabelCommonName;
    private javax.swing.JLabel jLabelMP;
    private javax.swing.JLabel jLabelMolarMass;
    private javax.swing.JLabel jLabelMolecularFormula;
    private javax.swing.JLabel jLabelStpDensity;
    private javax.swing.JLabel jLabelStpState;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListBinaryCompounds;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
