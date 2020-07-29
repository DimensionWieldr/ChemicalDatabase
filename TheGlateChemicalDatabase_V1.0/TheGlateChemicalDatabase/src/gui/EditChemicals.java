package gui;

import databaserunner.*;
import javax.swing.*;
import java.awt.event.*;

public class EditChemicals extends javax.swing.JFrame implements WindowListener{

    //our fields
    private Chemical chemicalToBeEdited;
    
    private DatabaseGUI databaseGUI;
    
    /**
     * Creates new form EditChemicals
     */
    public EditChemicals(DatabaseGUI databaseGUI) {
        this.databaseGUI = databaseGUI;
        initComponents();
    }
    
    //our methods
    public void start(EditChemicals editChemicals) {
        this.setComponentsEnabled(false);
        this.initConstants();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                editChemicals.setVisible(true);
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if (DatabaseGUI.getMadeChanges()) {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    databaseGUI.savePrompt(true);
                }
            });
        }
        
    }
    
    private void initConstants() {
        this.jTextFieldSearch.setText(DatabaseGUI.TEXT_FIELD_ENTER_NAME);
        
        this.jLabelCommonName.setText(DatabaseGUI.REQUIRED_FIELD_SYMBOL + Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelAtomicSymbol.setText(DatabaseGUI.REQUIRED_FIELD_SYMBOL + Element.LABEL_ATOMIC_SYMBOL + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelNumProton.setText(DatabaseGUI.REQUIRED_FIELD_SYMBOL + NuclearProperties.LABEL_PROTONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelElectronegativity.setText(DatabaseGUI.REQUIRED_FIELD_SYMBOL + NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        
        this.jTextFieldCommonName.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldAtomicSymbol.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldNumProton.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldElectronegativity.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldNumNeutron.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldIonizationEnergy.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldStpDensity.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldMolarMass.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldBP.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldMP.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldColour.setText(DatabaseGUI.EMPTY_STRING);
    }
    
    private void setComponentsEnabled(boolean enabled) {
        this.jTextFieldCommonName.setEnabled(enabled);
        this.jTextFieldStpDensity.setEnabled(enabled);
        this.jTextFieldBP.setEnabled(enabled);
        this.jTextFieldMP.setEnabled(enabled);
        this.jTextFieldColour.setEnabled(enabled);
        this.jTextFieldAtomicSymbol.setEnabled(enabled);
        this.jTextFieldMolarMass.setEnabled(enabled);
        this.jTextFieldNumProton.setEnabled(enabled);
        this.jTextFieldNumNeutron.setEnabled(enabled);
        this.jTextFieldIonizationEnergy.setEnabled(enabled);
        this.jTextFieldElectronegativity.setEnabled(enabled);
        this.jButtonSubmit.setEnabled(enabled);
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
        jButtonBack = new javax.swing.JButton();
        jLabelCommonName = new javax.swing.JLabel();
        jLabelStpDensity = new javax.swing.JLabel();
        jLabelBP = new javax.swing.JLabel();
        jLabelMP = new javax.swing.JLabel();
        jLabelColour = new javax.swing.JLabel();
        jTextFieldCommonName = new javax.swing.JTextField();
        jTextFieldStpDensity = new javax.swing.JTextField();
        jTextFieldMP = new javax.swing.JTextField();
        jTextFieldBP = new javax.swing.JTextField();
        jTextFieldColour = new javax.swing.JTextField();
        jLabelAtomicSymbol = new javax.swing.JLabel();
        jLabelMolarMass = new javax.swing.JLabel();
        jLabelNumProton = new javax.swing.JLabel();
        jLabelNumNeutron = new javax.swing.JLabel();
        jLabelIonizationEnergy = new javax.swing.JLabel();
        jLabelElectronegativity = new javax.swing.JLabel();
        jTextFieldAtomicSymbol = new javax.swing.JTextField();
        jTextFieldNumProton = new javax.swing.JTextField();
        jTextFieldMolarMass = new javax.swing.JTextField();
        jTextFieldNumNeutron = new javax.swing.JTextField();
        jTextFieldIonizationEnergy = new javax.swing.JTextField();
        jTextFieldElectronegativity = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setText("Edit Chemicals");

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelCommonName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCommonName.setText("*Name:");

        jLabelStpDensity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStpDensity.setText("Density @ STP (g/L):");

        jLabelBP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBP.setText("Boiling Point (C):");

        jLabelMP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMP.setText("Melting Point (C):");

        jLabelColour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelColour.setText("Colour:");

        jTextFieldCommonName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldStpDensity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldMP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldBP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldColour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelAtomicSymbol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAtomicSymbol.setText("*Atomic Symbol:");

        jLabelMolarMass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMolarMass.setText("*Molar Mass (g/mol):");

        jLabelNumProton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumProton.setText("*Atomic #:");

        jLabelNumNeutron.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumNeutron.setText("Neutrons:");

        jLabelIonizationEnergy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIonizationEnergy.setText("Ionization Energy:");

        jLabelElectronegativity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelElectronegativity.setText("Electronegativity:");

        jTextFieldAtomicSymbol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNumProton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldMolarMass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNumNeutron.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldIonizationEnergy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldElectronegativity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearch.setText("Chemical Name");

        jButtonSubmit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSubmit.setText("SUBMIT");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelInfo.setText("* = required fields");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jButtonSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTitle)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInfo)
                                .addGap(316, 316, 316))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelStpDensity)
                                    .addComponent(jLabelColour, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCommonName, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldCommonName)
                                            .addComponent(jTextFieldStpDensity)
                                            .addComponent(jTextFieldColour, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextFieldBP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldMP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelNumNeutron)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNumNeutron, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelAtomicSymbol)
                                                .addComponent(jLabelMolarMass))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelNumProton)
                                                .addGap(58, 58, 58)))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldAtomicSymbol)
                                            .addComponent(jTextFieldNumProton)
                                            .addComponent(jTextFieldMolarMass, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelElectronegativity)
                                                .addGap(38, 38, 38))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelIonizationEnergy)
                                                .addGap(37, 37, 37)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldIonizationEnergy)
                                            .addComponent(jTextFieldElectronegativity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabelInfo)
                    .addComponent(jButtonBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAtomicSymbol)
                            .addComponent(jTextFieldAtomicSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMolarMass)
                            .addComponent(jTextFieldMolarMass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumProton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumProton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNumNeutron)
                            .addComponent(jTextFieldNumNeutron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIonizationEnergy)
                            .addComponent(jTextFieldIonizationEnergy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCommonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCommonName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldStpDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStpDensity))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBP))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMP))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelColour))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelElectronegativity)
                    .addComponent(jTextFieldElectronegativity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButtonSubmit)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.databaseGUI.startHomePage();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        //declare variables
        String commonName;
        String atomicSymbol;
        int numProton;
        int numNeutron;
        double stpDensity;
        double molarMass;
        double bp;
        double mp;
        String colour;
        double ionizationEnergy;
        double electronegativity;
        
        try {
            //Checks for all chemicals
            //read required fields
            commonName = this.jTextFieldCommonName.getText();
            
            //read optional fields
            if(!this.jTextFieldStpDensity.getText().equals(DatabaseGUI.EMPTY_STRING)){
                if (!this.jTextFieldStpDensity.getText().equals(DatabaseGUI.DEFAULT_STRING))
                    stpDensity = Double.parseDouble(this.jTextFieldStpDensity.getText());
                else
                    stpDensity = Chemical.DEFAULT_DENSITY;
            }else
                stpDensity = Chemical.DEFAULT_DENSITY;
            
            if(!this.jTextFieldBP.getText().equals(DatabaseGUI.EMPTY_STRING)){
                if (!this.jTextFieldBP.getText().equals(DatabaseGUI.DEFAULT_STRING))
                    bp = Double.parseDouble(this.jTextFieldBP.getText());
                else
                    bp = Chemical.DEFAULT_STATE_CHANGE_TEMP;
            }else
                bp = Chemical.DEFAULT_STATE_CHANGE_TEMP;
            
            if(!this.jTextFieldMP.getText().equals(DatabaseGUI.EMPTY_STRING)){
                if (!this.jTextFieldMP.getText().equals(DatabaseGUI.DEFAULT_STRING))
                    mp = Double.parseDouble(this.jTextFieldMP.getText());
                else
                    mp = Chemical.DEFAULT_STATE_CHANGE_TEMP;
            }else
                mp = Chemical.DEFAULT_STATE_CHANGE_TEMP;
            
            if(!this.jTextFieldColour.getText().equals(DatabaseGUI.EMPTY_STRING))
                colour = this.jTextFieldColour.getText();
            else
                colour = Chemical.DEFAULT_COLOUR;
            
            //create temporary Chemical
            Chemical newChemical = null;
            if(this.chemicalToBeEdited instanceof Element)
                newChemical = new Element();
            else if(this.chemicalToBeEdited instanceof BinaryCompound)
                newChemical = new BinaryCompound();
            
            //checkfields and edit chemical only if all checks are passed
            if(commonName.equals(DatabaseGUI.EMPTY_STRING))
                JOptionPane.showMessageDialog(null, DatabaseGUI.REQUIRED_FIELD + DatabaseGUI.ERROR_FIELD_EMPTY);
            
            else if(!newChemical.setCommonName(commonName))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_NAME.toLowerCase());
            
            else if(commonName.length() > DatabaseGUI.MAXIMUM_STRING_LENGTH)
                JOptionPane.showMessageDialog(null, Chemical.LABEL_NAME + DatabaseGUI.ERROR_TOO_LONG);
            
            else if(!newChemical.setStpDensity(stpDensity))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_STP_DENSITY.toLowerCase());
            
            else if(!newChemical.setBP(bp))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_BP.toLowerCase());
            
            else if(!newChemical.setMP(mp))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_MP.toLowerCase());
            
            else if(colour.length() > DatabaseGUI.MAXIMUM_STRING_LENGTH)
                JOptionPane.showMessageDialog(null, Chemical.LABEL_COLOUR + DatabaseGUI.ERROR_TOO_LONG);
            
            else{
                
                if(this.chemicalToBeEdited instanceof BinaryCompound){
                    
                    if(this.databaseGUI.editBinaryCompounds((BinaryCompound)this.chemicalToBeEdited, commonName, stpDensity, bp, mp, colour)){
                        JOptionPane.showMessageDialog(null, DatabaseGUI.EDIT_SUCCESS);
                        this.setVisible(false);
                        this.start(this);
                    }else
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_REPEAT);
                    
                }else if(this.chemicalToBeEdited instanceof Element){
                    
                    //read required fields
                    atomicSymbol = this.jTextFieldAtomicSymbol.getText();
                    numProton = Integer.parseInt(this.jTextFieldNumProton.getText());
                    electronegativity = Double.parseDouble(this.jTextFieldElectronegativity.getText());
                    
                    //read optional fields
                    if(!jTextFieldNumNeutron.getText().equals(DatabaseGUI.EMPTY_STRING)){
                        if (!this.jTextFieldNumNeutron.getText().equals(DatabaseGUI.DEFAULT_STRING))
                            numNeutron = Integer.parseInt(this.jTextFieldNumNeutron.getText());
                        else
                            numNeutron = NuclearProperties.DEFAULT_NEUTRONS;
                    }else
                        numNeutron = NuclearProperties.DEFAULT_NEUTRONS;
                    
                    if(!this.jTextFieldMolarMass.getText().equals(DatabaseGUI.EMPTY_STRING)){
                        if (!this.jTextFieldMolarMass.getText().equals(DatabaseGUI.DEFAULT_STRING))
                            molarMass = Double.parseDouble(this.jTextFieldMolarMass.getText());
                        else
                            molarMass = Chemical.DEFAULT_MOLAR_MASS;
                    }else
                        molarMass = Chemical.DEFAULT_MOLAR_MASS;
                    
                    if(!this.jTextFieldIonizationEnergy.getText().equals(DatabaseGUI.EMPTY_STRING)){
                        if (!this.jTextFieldIonizationEnergy.getText().equals(DatabaseGUI.DEFAULT_STRING))
                            ionizationEnergy = Double.parseDouble(this.jTextFieldIonizationEnergy.getText());
                        else
                            ionizationEnergy = NuclearProperties.DEFAULT_IONIZATION_ENERGY;
                    }else
                        ionizationEnergy = NuclearProperties.DEFAULT_IONIZATION_ENERGY;
                    
                    //create temp Element
                    Element newElement = new Element();
                    
                    //check fields and edit element only if all checks are passed
                    if(this.jTextFieldAtomicSymbol.getText().equals(DatabaseGUI.EMPTY_STRING) || this.jTextFieldNumProton.getText().equals(DatabaseGUI.EMPTY_STRING) || this.jTextFieldElectronegativity.getText().equals(DatabaseGUI.EMPTY_STRING))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.REQUIRED_FIELD + DatabaseGUI.ERROR_FIELD_EMPTY);
                    
                    else if(!newElement.setAtomicSymbol(atomicSymbol))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Element.LABEL_ATOMIC_SYMBOL.toLowerCase());
                    
                    else if(atomicSymbol.length() > DatabaseGUI.MAXIMUM_ATOMIC_SYMBOL_LENGTH)
                        JOptionPane.showMessageDialog(null, Element.LABEL_ATOMIC_SYMBOL + DatabaseGUI.ERROR_TOO_LONG);
                    
                    else if(!newElement.setNumProton(numProton))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + NuclearProperties.LABEL_PROTONS.toLowerCase());
                    
                    else if(!newElement.setElectronegativity(electronegativity))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + NuclearProperties.LABEL_ELECTRONEGATIVITY.toLowerCase());
                    
                    else if(!newElement.setNumNeutron(numNeutron))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + NuclearProperties.LABEL_NEUTRONS.toLowerCase());
                    
                    else if(!newElement.setMolarMass(molarMass))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_MOLAR_MASS.toLowerCase());
                    
                    else if(!newElement.setIonizationEnergy(ionizationEnergy))
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + NuclearProperties.LABEL_IONIZATION_ENERGY.toLowerCase());
                    
                    else if(this.databaseGUI.editElements((Element)this.chemicalToBeEdited, commonName, stpDensity, bp, mp, colour, atomicSymbol, numProton, electronegativity, numNeutron, molarMass, ionizationEnergy)) {
                        JOptionPane.showMessageDialog(null, DatabaseGUI.EDIT_SUCCESS);
                        this.setVisible(false);
                        this.start(this);
                        
                    }else
                        JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_REPEAT);
                } 
            }

        }catch(NumberFormatException nfx){
            JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ERRONEOUS_DATA);
        }
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        
        String name = jTextFieldSearch.getText();
        this.chemicalToBeEdited = this.databaseGUI.searchChemicalsByName(name);
        
        if(this.chemicalToBeEdited != null){
            
            if(this.chemicalToBeEdited instanceof BinaryCompound){
            
                BinaryCompound binaryCompoundToBeEdited = (BinaryCompound)this.chemicalToBeEdited;

                this.jTextFieldCommonName.setText(binaryCompoundToBeEdited.getCommonName());
                
                if (binaryCompoundToBeEdited.getStpDensity() == Chemical.DEFAULT_DENSITY)
                    this.jTextFieldStpDensity.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldStpDensity.setText(DatabaseGUI.EMPTY_STRING + binaryCompoundToBeEdited.getStpDensity());

                if (binaryCompoundToBeEdited.getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldMP.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldMP.setText(DatabaseGUI.EMPTY_STRING + binaryCompoundToBeEdited.getMP());

                if (binaryCompoundToBeEdited.getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldBP.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldBP.setText(DatabaseGUI.EMPTY_STRING + binaryCompoundToBeEdited.getBP());
                
                this.jTextFieldColour.setText(binaryCompoundToBeEdited.getColour());

                this.setComponentsEnabled(true);
                
                this.jTextFieldAtomicSymbol.setEnabled(false);
                this.jTextFieldMolarMass.setEnabled(false);
                this.jTextFieldNumProton.setEnabled(false);
                this.jTextFieldNumNeutron.setEnabled(false);
                this.jTextFieldIonizationEnergy.setEnabled(false);
                this.jTextFieldElectronegativity.setEnabled(false);

            } else if(this.chemicalToBeEdited instanceof Element) {

                Element elementToBeEdited = (Element)this.chemicalToBeEdited;
                
                this.jTextFieldCommonName.setText(elementToBeEdited.getCommonName());
                
                if (elementToBeEdited.getStpDensity() == Chemical.DEFAULT_DENSITY)
                    this.jTextFieldStpDensity.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldStpDensity.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getStpDensity());

                if (elementToBeEdited.getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldMP.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldMP.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getMP());

                if (elementToBeEdited.getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldBP.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldBP.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getBP());
                
                this.jTextFieldColour.setText(elementToBeEdited.getColour());

                this.jTextFieldAtomicSymbol.setText(elementToBeEdited.getAtomicSymbol());
                
                if (elementToBeEdited.getNumNeutron() == NuclearProperties.DEFAULT_NEUTRONS)
                    this.jTextFieldNumNeutron.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldNumNeutron.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getNumNeutron());
            
                this.jTextFieldNumProton.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getNumProton());
                
                if (elementToBeEdited.getMolarMass() == Chemical.DEFAULT_MOLAR_MASS)
                    this.jTextFieldMolarMass.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldMolarMass.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getMolarMass());
                
                if (elementToBeEdited.getIonizationEnergy() == NuclearProperties.DEFAULT_IONIZATION_ENERGY)
                    this.jTextFieldIonizationEnergy.setText(DatabaseGUI.DEFAULT_STRING);
                else
                    this.jTextFieldIonizationEnergy.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getIonizationEnergy());
                
                this.jTextFieldElectronegativity.setText(DatabaseGUI.EMPTY_STRING + elementToBeEdited.getNuclearProp().getElectronegativity());
                
                this.setComponentsEnabled(true);

            }
            
        }else
            JOptionPane.showMessageDialog(null, name + DatabaseGUI.WARNING_NOT_FOUND);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelAtomicSymbol;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelColour;
    private javax.swing.JLabel jLabelCommonName;
    private javax.swing.JLabel jLabelElectronegativity;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelIonizationEnergy;
    private javax.swing.JLabel jLabelMP;
    private javax.swing.JLabel jLabelMolarMass;
    private javax.swing.JLabel jLabelNumNeutron;
    private javax.swing.JLabel jLabelNumProton;
    private javax.swing.JLabel jLabelStpDensity;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldAtomicSymbol;
    private javax.swing.JTextField jTextFieldBP;
    private javax.swing.JTextField jTextFieldColour;
    private javax.swing.JTextField jTextFieldCommonName;
    private javax.swing.JTextField jTextFieldElectronegativity;
    private javax.swing.JTextField jTextFieldIonizationEnergy;
    private javax.swing.JTextField jTextFieldMP;
    private javax.swing.JTextField jTextFieldMolarMass;
    private javax.swing.JTextField jTextFieldNumNeutron;
    private javax.swing.JTextField jTextFieldNumProton;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldStpDensity;
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