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
        this.setComponentsEnabled(false);
        
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
    public void setComponentsEnabled(boolean enabled) {
        this.jTextFieldCommonName.setEnabled(enabled);
        this.jTextFieldStpDensity.setEnabled(enabled);
        this.jTextFieldBP.setEnabled(enabled);
        this.jTextFieldMP.setEnabled(enabled);
        this.jTextFieldColour.setEnabled(enabled);
        this.jTextFieldMolecularFormula.setEnabled(enabled);
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
        jLabelMolecularFormula = new javax.swing.JLabel();
        jLabelMolarMass = new javax.swing.JLabel();
        jLabelNumProton = new javax.swing.JLabel();
        jLabelNumNeutron = new javax.swing.JLabel();
        jLabelIonizationEnergy = new javax.swing.JLabel();
        jLabelElectronegativity = new javax.swing.JLabel();
        jTextFieldMolecularFormula = new javax.swing.JTextField();
        jTextFieldNumProton = new javax.swing.JTextField();
        jTextFieldMolarMass = new javax.swing.JTextField();
        jTextFieldNumNeutron = new javax.swing.JTextField();
        jTextFieldIonizationEnergy = new javax.swing.JTextField();
        jTextFieldElectronegativity = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();

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
        jLabelCommonName.setText("Name:");

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

        jLabelMolecularFormula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMolecularFormula.setText("Atomic Symbol:");

        jLabelMolarMass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMolarMass.setText("Molar Mass (g/mol):");

        jLabelNumProton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumProton.setText("Protons (Atomic #):");

        jLabelNumNeutron.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumNeutron.setText("Neutrons:");

        jLabelIonizationEnergy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIonizationEnergy.setText("Ionization Energy:");

        jLabelElectronegativity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelElectronegativity.setText("Electronegativity:");

        jTextFieldMolecularFormula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelStpDensity)
                            .addComponent(jLabelColour, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCommonName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldColour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStpDensity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCommonName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMolecularFormula)
                                    .addComponent(jLabelMolarMass))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMolecularFormula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMolarMass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelElectronegativity)
                                .addGap(38, 38, 38)
                                .addComponent(jTextFieldElectronegativity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelNumProton)
                                .addGap(22, 22, 22)
                                .addComponent(jTextFieldNumProton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelNumNeutron)
                                .addGap(84, 84, 84)
                                .addComponent(jTextFieldNumNeutron, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelIonizationEnergy)
                                .addGap(34, 34, 34)
                                .addComponent(jTextFieldIonizationEnergy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSubmit)
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
                        .addGap(34, 34, 34)
                        .addComponent(jLabelTitle)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMolecularFormula)
                            .addComponent(jTextFieldMolecularFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMolarMass)
                            .addComponent(jTextFieldMolarMass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNumProton)
                            .addComponent(jTextFieldNumProton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jButtonSubmit)
                .addContainerGap())
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
        String molecularFormula;
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
                if (!this.jTextFieldStpDensity.getText().equals(Chemical.DEFAULT_COMMON_NAME))
                    stpDensity = Double.parseDouble(this.jTextFieldStpDensity.getText());
                else
                    stpDensity = Chemical.getDEFAULT_DENSITY();
            }else
                stpDensity = Chemical.getDEFAULT_DENSITY();
            
            if(!this.jTextFieldBP.getText().equals(DatabaseGUI.EMPTY_STRING)){
                if (!this.jTextFieldBP.getText().equals(Chemical.DEFAULT_COMMON_NAME))
                    bp = Double.parseDouble(this.jTextFieldBP.getText());
                else
                    bp = Chemical.getDEFAULT_STATE_CHANGE_TEMP();
            }else
                bp = Chemical.getDEFAULT_STATE_CHANGE_TEMP();
            
            if(!this.jTextFieldMP.getText().equals(DatabaseGUI.EMPTY_STRING)){
                if (!this.jTextFieldMP.getText().equals(Chemical.DEFAULT_COMMON_NAME))
                    mp = Double.parseDouble(this.jTextFieldMP.getText());
                else
                    mp = Chemical.getDEFAULT_STATE_CHANGE_TEMP();
            }else
                mp = Chemical.getDEFAULT_STATE_CHANGE_TEMP();
            
            if(!this.jTextFieldColour.getText().equals(DatabaseGUI.EMPTY_STRING))
                colour = this.jTextFieldColour.getText();
            else
                colour = Chemical.getDEFAULT_COLOUR();
            
            //create temporary Chemical
            Chemical newChemical = null;
            if(this.chemicalToBeEdited instanceof Element)
                newChemical = new Element();
            else if(this.chemicalToBeEdited instanceof BinaryCompound)
                newChemical = new BinaryCompound();
            
            //checkfields and edit chemical only if all checks are passed
            if(commonName.equals(DatabaseGUI.EMPTY_STRING))
                JOptionPane.showMessageDialog(null, "A required field is blank!");
            
            else if(!newChemical.setCommonName(commonName))
                JOptionPane.showMessageDialog(null, "Illegal name!");
            
            else if(!newChemical.setStpDensity(stpDensity))
                JOptionPane.showMessageDialog(null, "Illegal density!");
            
            else if(!newChemical.setBP(bp))
                JOptionPane.showMessageDialog(null, "Illegal boiling point!");
            
            else if(!newChemical.setMP(mp))
                JOptionPane.showMessageDialog(null, "Illegal melting point!");
            
            else{
                
                if(this.chemicalToBeEdited instanceof BinaryCompound){
                    
                    if(this.databaseGUI.editBinaryCompounds((BinaryCompound)this.chemicalToBeEdited, commonName, stpDensity, bp, mp, colour)){
                        JOptionPane.showMessageDialog(null, "Edit successful!");
                        this.setVisible(false);
                        this.start();
                    }else
                        JOptionPane.showMessageDialog(null, "An element with that information already exists!");
                    
                }else if(this.chemicalToBeEdited instanceof Element){
                    
                    //read required fields
                    molecularFormula = this.jTextFieldMolecularFormula.getText();
                    numProton = Integer.parseInt(this.jTextFieldNumProton.getText());
                    electronegativity = Double.parseDouble(this.jTextFieldElectronegativity.getText());
                    
                    //read optional fields
                    if(!jTextFieldNumNeutron.getText().equals(DatabaseGUI.EMPTY_STRING)){
                        if (!this.jTextFieldNumNeutron.getText().equals(Chemical.DEFAULT_COMMON_NAME))
                            numNeutron = Integer.parseInt(this.jTextFieldNumNeutron.getText());
                        else
                            numNeutron = NuclearProperties.DEFAULT_NEUTRONS;
                    }else
                        numNeutron = NuclearProperties.DEFAULT_NEUTRONS;
                    
                    if(!this.jTextFieldMolarMass.getText().equals(DatabaseGUI.EMPTY_STRING)){
                        if (!this.jTextFieldMolarMass.getText().equals(Chemical.DEFAULT_COMMON_NAME))
                            molarMass = Double.parseDouble(this.jTextFieldMolarMass.getText());
                        else
                            molarMass = Chemical.DEFAULT_MOLAR_MASS;
                    }else
                        molarMass = Chemical.DEFAULT_MOLAR_MASS;
                    
                    if(!this.jTextFieldIonizationEnergy.getText().equals(DatabaseGUI.EMPTY_STRING)){
                        if (!this.jTextFieldIonizationEnergy.getText().equals(Chemical.DEFAULT_COMMON_NAME))
                            ionizationEnergy = Double.parseDouble(this.jTextFieldIonizationEnergy.getText());
                        else
                            ionizationEnergy = NuclearProperties.DEFAULT_IONIZATION_ENERGY;
                    }else
                        ionizationEnergy = NuclearProperties.DEFAULT_IONIZATION_ENERGY;
                    
                    //create temp Element
                    Element newElement = new Element();
                    
                    //check fields and edit element only if all checks are passed
                    if(!newElement.setMolecularFormula(molecularFormula))
                        JOptionPane.showMessageDialog(null, "Illegal molecular formula!");
                    
                    else if(!newElement.setNumProton(numProton))
                        JOptionPane.showMessageDialog(null, "Illegal atomic number!");
                    
                    else if(!newElement.setElectronegativity(electronegativity))
                        JOptionPane.showMessageDialog(null, "Illegal electronegativity!");
                    
                    else if(!newElement.setNumNeutron(numNeutron))
                        JOptionPane.showMessageDialog(null, "Illegal neutron quantity!");
                    
                    else if(!newElement.setMolarMass(molarMass))
                        JOptionPane.showMessageDialog(null, "Illegal molar mass!");
                    
                    else if(!newElement.setIonizationEnergy(ionizationEnergy))
                        JOptionPane.showMessageDialog(null, "Illegal ionization energy!");
                    
                    else if(this.databaseGUI.editElements((Element)this.chemicalToBeEdited, commonName, stpDensity, bp, mp, colour, molecularFormula, numProton, electronegativity, numNeutron, molarMass, ionizationEnergy)) {
                        JOptionPane.showMessageDialog(null, "Edit successful!");
                        this.setVisible(false);
                        this.start();
                        
                    }else
                        JOptionPane.showMessageDialog(null, "An element with that information already exists!");
                } 
            }

        }catch(NumberFormatException nfx){
            JOptionPane.showMessageDialog(null, "Erroneous data has been entered!");
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
                    this.jTextFieldStpDensity.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldStpDensity.setText("" + binaryCompoundToBeEdited.getStpDensity());

                if (binaryCompoundToBeEdited.getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldMP.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldMP.setText("" + binaryCompoundToBeEdited.getMP());

                if (binaryCompoundToBeEdited.getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldBP.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldBP.setText("" + binaryCompoundToBeEdited.getBP());
                
                this.jTextFieldColour.setText(binaryCompoundToBeEdited.getColour());

                this.setComponentsEnabled(true);
                
                this.jTextFieldMolecularFormula.setEnabled(false);
                this.jTextFieldMolarMass.setEnabled(false);
                this.jTextFieldNumProton.setEnabled(false);
                this.jTextFieldNumNeutron.setEnabled(false);
                this.jTextFieldIonizationEnergy.setEnabled(false);
                this.jTextFieldElectronegativity.setEnabled(false);

            } else if(this.chemicalToBeEdited instanceof Element) {

                Element elementToBeEdited = (Element)this.chemicalToBeEdited;
                
                this.jTextFieldCommonName.setText(elementToBeEdited.getCommonName());
                
                if (elementToBeEdited.getStpDensity() == Chemical.DEFAULT_DENSITY)
                    this.jTextFieldStpDensity.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldStpDensity.setText("" + elementToBeEdited.getStpDensity());

                if (elementToBeEdited.getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldMP.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldMP.setText("" + elementToBeEdited.getMP());

                if (elementToBeEdited.getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                    this.jTextFieldBP.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldBP.setText("" + elementToBeEdited.getBP());
                
                this.jTextFieldColour.setText(elementToBeEdited.getColour());

                this.jTextFieldMolecularFormula.setText(elementToBeEdited.getMolecularFormula());
                
                if (elementToBeEdited.getNumNeutron() == NuclearProperties.DEFAULT_NEUTRONS)
                    this.jTextFieldNumNeutron.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldNumNeutron.setText("" + elementToBeEdited.getNumNeutron());
            
                this.jTextFieldNumProton.setText("" + elementToBeEdited.getNumProton());
                
                if (elementToBeEdited.getMolarMass() == Chemical.DEFAULT_MOLAR_MASS)
                    this.jTextFieldMolarMass.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldMolarMass.setText("" + elementToBeEdited.getMolarMass());
                
                if (elementToBeEdited.getIonizationEnergy() == NuclearProperties.DEFAULT_IONIZATION_ENERGY)
                    this.jTextFieldIonizationEnergy.setText("" + Chemical.DEFAULT_COMMON_NAME);
                else
                    this.jTextFieldIonizationEnergy.setText("" + elementToBeEdited.getIonizationEnergy());
                
                this.jTextFieldElectronegativity.setText("" + elementToBeEdited.getNuclearProp().getElectronegativity());
                
                this.setComponentsEnabled(true);

            }
            
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
            java.util.logging.Logger.getLogger(EditChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditChemicals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditChemicals(databaseGUI).setVisible(true);
            }
        });
        this.setComponentsEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelColour;
    private javax.swing.JLabel jLabelCommonName;
    private javax.swing.JLabel jLabelElectronegativity;
    private javax.swing.JLabel jLabelIonizationEnergy;
    private javax.swing.JLabel jLabelMP;
    private javax.swing.JLabel jLabelMolarMass;
    private javax.swing.JLabel jLabelMolecularFormula;
    private javax.swing.JLabel jLabelNumNeutron;
    private javax.swing.JLabel jLabelNumProton;
    private javax.swing.JLabel jLabelStpDensity;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldBP;
    private javax.swing.JTextField jTextFieldColour;
    private javax.swing.JTextField jTextFieldCommonName;
    private javax.swing.JTextField jTextFieldElectronegativity;
    private javax.swing.JTextField jTextFieldIonizationEnergy;
    private javax.swing.JTextField jTextFieldMP;
    private javax.swing.JTextField jTextFieldMolarMass;
    private javax.swing.JTextField jTextFieldMolecularFormula;
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