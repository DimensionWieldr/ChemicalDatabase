package gui;

import databaserunner.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SortChemicals extends javax.swing.JFrame implements WindowListener{

    //our fields
    private static final String NAME = "Name";
    private static final String MOLAR_MASS = "Molar Mass";
    private static final String MELTING_POINT = "Melting Point";
    private static final String BOILING_POINT = "Boiling Point";
    private static final String DENSITY = "Density @ STP";
    private static final String SOLID = "Solid @ STP";
    private static final String LIQUID = "Liquid @ STP";
    private static final String GAS = "Gas @ STP";
    
    private static final String[] FILTERS = {NAME, MOLAR_MASS, MELTING_POINT, BOILING_POINT, DENSITY, SOLID, LIQUID, GAS};
    
    private static List<Chemical> chemicals;
    private static String selectedProperty;
    
    private String[] chemicalNames;
    
    private DatabaseGUI databaseGUI;
    
    /**
     * Creates new form SortChemicals
     */
    public SortChemicals(DatabaseGUI databaseGUI) {
        this.databaseGUI = databaseGUI;
        if (chemicals != null)
            this.createList();
        else
            this.chemicalNames = new String[DatabaseGUI.DEFAULT_ARRAY_SIZE];
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
    
    public void createList() {
        this.chemicalNames = new String[chemicals.size()];
        for(int i = 0; i < this.chemicalNames.length; i++){
            this.chemicalNames[i] = chemicals.get(i).getCommonName();
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
        jComboBoxFilters = new javax.swing.JComboBox<>();
        jButtonSort = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSortedChemicals = new javax.swing.JList<>();
        jLabelCommonName = new javax.swing.JLabel();
        jLabelMolarMass = new javax.swing.JLabel();
        jLabelStpState = new javax.swing.JLabel();
        jLabelStpDensity = new javax.swing.JLabel();
        jLabelBP = new javax.swing.JLabel();
        jLabelMP = new javax.swing.JLabel();
        jLabelColour = new javax.swing.JLabel();
        jLabelMolecularFormula = new javax.swing.JLabel();
        jLabelOxidationNum = new javax.swing.JLabel();
        jLabelCharge = new javax.swing.JLabel();
        jLabelNumProton = new javax.swing.JLabel();
        jLabelNumElectron = new javax.swing.JLabel();
        jLabelNumNeutron = new javax.swing.JLabel();
        jLabelIonizationEnergy = new javax.swing.JLabel();
        jLabelElectronegativity = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setText("Sort Chemicals");

        jComboBoxFilters.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxFilters.setModel(new javax.swing.DefaultComboBoxModel<>(FILTERS));
        jComboBoxFilters.setSelectedItem(selectedProperty);

        jButtonSort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSort.setText("Sort");
        jButtonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortActionPerformed(evt);
            }
        });

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jListSortedChemicals.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jListSortedChemicals.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = chemicalNames;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListSortedChemicals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListSortedChemicalsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListSortedChemicals);

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

        jLabelMolecularFormula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMolecularFormula.setText("Molecular Formula:");

        jLabelOxidationNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelOxidationNum.setText("Oxidation Number:");

        jLabelCharge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCharge.setText("Charge:");

        jLabelNumProton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumProton.setText("Atomic #:");

        jLabelNumElectron.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumElectron.setText("Electrons:");

        jLabelNumNeutron.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumNeutron.setText("Neutrons:");

        jLabelIonizationEnergy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIonizationEnergy.setText("Ionization Energy:");

        jLabelElectronegativity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelElectronegativity.setText("Electronegativity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCommonName)
                            .addComponent(jLabelMolarMass)
                            .addComponent(jLabelStpState)
                            .addComponent(jLabelStpDensity)
                            .addComponent(jLabelBP)
                            .addComponent(jLabelMP)
                            .addComponent(jLabelColour)
                            .addComponent(jLabelMolecularFormula)
                            .addComponent(jLabelNumProton)
                            .addComponent(jLabelNumElectron)
                            .addComponent(jLabelNumNeutron)
                            .addComponent(jLabelIonizationEnergy)
                            .addComponent(jLabelElectronegativity)
                            .addComponent(jLabelOxidationNum)
                            .addComponent(jLabelCharge)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jButtonBack)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitle)
                            .addComponent(jComboBoxFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSort))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCommonName)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelMolecularFormula)
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
                                .addComponent(jLabelColour)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCharge)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelOxidationNum)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNumProton)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNumElectron)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNumNeutron)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelIonizationEnergy)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelElectronegativity))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Sort button
    private void jButtonSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortActionPerformed
        
        selectedProperty = (String)jComboBoxFilters.getSelectedItem();
        
        if (selectedProperty == null) {
            JOptionPane.showMessageDialog(null, "No Property Selected!");
        }else{
            switch(selectedProperty){
                case NAME:
                    chemicals = this.databaseGUI.sortChemicalsByName();
                    break;
                case MOLAR_MASS:
                    chemicals = this.databaseGUI.sortChemicalsByMolarMass();
                    break;
                case MELTING_POINT:
                    chemicals = this.databaseGUI.sortChemicalsByMeltingPoint();
                    break;
                case BOILING_POINT:
                    chemicals = this.databaseGUI.sortChemicalsByBoilingPoint();
                    break;
                case DENSITY:
                    chemicals = this.databaseGUI.sortChemicalsByStpDensity();
                    break;
                case SOLID:
                    chemicals = this.databaseGUI.sortChemicalsByStpState('s');
                    break;
                case LIQUID:
                    chemicals = this.databaseGUI.sortChemicalsByStpState('l');
                    break;
                case GAS:
                    chemicals = this.databaseGUI.sortChemicalsByStpState('g');
                    break;
                default:
                    chemicals = null;
                    this.databaseGUI.startHomePage();
                    this.setVisible(false);
            } 
            this.createList();
            
            this.start();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonSortActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.databaseGUI.startHomePage();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jListSortedChemicalsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSortedChemicalsMousePressed
        //get chemical index
        int index = jListSortedChemicals.getSelectedIndex();
        
        //display chemical information
        if(index != -1){
            
            
            Chemical selectedChemical = chemicals.get(index);
            
            this.jLabelCommonName.setText("Name: " + selectedChemical.getCommonName());
            this.jLabelMolarMass.setText("Molar Mass (g/mol): " + selectedChemical.getMolarMass());
            this.jLabelStpState.setText("State @ STP: " + selectedChemical.getStpState());
            this.jLabelStpDensity.setText("Density @ STP (g/L): " + selectedChemical.getStpDensity());
            this.jLabelBP.setText("Boiling Point (C): " + selectedChemical.getBP());
            this.jLabelMP.setText("Melting Point (C): " + selectedChemical.getMP());
            this.jLabelColour.setText("Colour: " + selectedChemical.getColour());
            
            if(chemicals.get(index) instanceof Element){
                
                Element selectedElement = (Element)chemicals.get(index);
                
                this.jLabelMolecularFormula.setText("Molecular Formula: " + selectedElement.getMolecularFormula());
                this.jLabelOxidationNum.setEnabled(true);
                this.jLabelOxidationNum.setText("Oxidation Number: " + selectedElement.getOxidationNum());
                this.jLabelNumProton.setEnabled(true);
                this.jLabelNumProton.setText("Atomic #: " + selectedElement.getNumProton());
                this.jLabelNumElectron.setEnabled(true);
                this.jLabelNumElectron.setText("Electrons: " + selectedElement.getNumElectron());
                this.jLabelNumNeutron.setEnabled(true);
                this.jLabelNumNeutron.setText("Neutrons: " + selectedElement.getNumNeutron());
                this.jLabelIonizationEnergy.setEnabled(true);
                this.jLabelIonizationEnergy.setText("Ionization Energy: " + selectedElement.getIonizationEnergy());
                this.jLabelElectronegativity.setEnabled(true);
                this.jLabelElectronegativity.setText("Electronegativity: " + selectedElement.getElectronegativity());
                
                this.jLabelCharge.setText("Charge:");
                this.jLabelCharge.setEnabled(false);
                
            }else if(chemicals.get(index) instanceof BinaryCompound){
                
                BinaryCompound selectedBinaryCompound = (BinaryCompound)chemicals.get(index);
                
                this.jLabelMolecularFormula.setText("Molecular Formula: " + selectedBinaryCompound.getMolecularFormula());
                this.jLabelCharge.setEnabled(true);
                this.jLabelCharge.setText("Charge: " + selectedBinaryCompound.getCharge());
                
                this.jLabelOxidationNum.setText("Oxidation Number:");
                this.jLabelOxidationNum.setEnabled(false);
                this.jLabelNumProton.setText("Atomic #:");
                this.jLabelNumProton.setEnabled(false);
                this.jLabelNumElectron.setText("Electrons:");
                this.jLabelNumElectron.setEnabled(false);
                this.jLabelNumNeutron.setText("Neutrons:");
                this.jLabelNumNeutron.setEnabled(false);
                this.jLabelIonizationEnergy.setText("Ionization Energy:");
                this.jLabelIonizationEnergy.setEnabled(false);
                this.jLabelElectronegativity.setText("Electronegativity:");
                this.jLabelElectronegativity.setEnabled(false);
                
            }
        }
    }//GEN-LAST:event_jListSortedChemicalsMousePressed

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
            java.util.logging.Logger.getLogger(SortChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortChemicals(databaseGUI).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSort;
    private javax.swing.JComboBox<String> jComboBoxFilters;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelCharge;
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
    private javax.swing.JList<String> jListSortedChemicals;
    private javax.swing.JScrollPane jScrollPane1;
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
