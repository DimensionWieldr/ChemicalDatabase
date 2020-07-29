/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import databaserunner.*;
import javax.swing.*;

public class SimulateReaction extends javax.swing.JFrame {

    //Our Fields
    private Element reactant1;
    private Element reactant2;
    private BinaryCompound product;
    
    private Reaction reaction;
    
    private boolean sameReactants;
    private boolean productInfoEntered;
    private boolean noProduct;
    
    private DatabaseGUI databaseGUI;
 
    //Accessors & Mutators
    public Reaction getReaction() {
        return this.reaction;
    }
    
    //Constructor
    public SimulateReaction(DatabaseGUI databaseGUI) {
        this.databaseGUI = databaseGUI;
        
        this.initComponents();
        this.setComponentsEnabled(false);
    }
    
    public void start(SimulateReaction simulateReaction) {
        this.sameReactants = false;
        this.noProduct = true;
        this.productInfoEntered = false;
        
        this.setComponentsEnabled(false);
        initConstants();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                simulateReaction.setVisible(true);
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.removeWindowListener(this.databaseGUI.WINDOW_CLOSE);
        this.removeWindowListener(this.databaseGUI.WINDOW_CLOSE_NEW_REACTION);
        
        if (DatabaseGUI.getMadeChanges()) {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.addWindowListener(this.databaseGUI.WINDOW_CLOSE);
        }
    }
    
    //Our methods
    private void initConstants() {
        this.jTextFieldReactant1.setText(DatabaseGUI.TEXT_FIELD_ENTER_NAME);
        this.jTextFieldReactant2.setText(DatabaseGUI.TEXT_FIELD_ENTER_NAME);
        
        this.jTextFieldProductName.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldProductDensity.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldProductBP.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldProductMP.setText(DatabaseGUI.EMPTY_STRING);
        this.jTextFieldProductColour.setText(DatabaseGUI.EMPTY_STRING);
        
        this.jLabelMassNumberReactant1.setText(NuclearProperties.LABEL_MASS_NUMBER);
        this.jLabelMassNumberReactant2.setText(NuclearProperties.LABEL_MASS_NUMBER);
        this.jLabelOxNumReactant1.setText(Element.LABEL_OXIDATION_NUMBER);
        this.jLabelOxNumReactant2.setText(Element.LABEL_OXIDATION_NUMBER);
        this.jLabelProtonsReactant1.setText(NuclearProperties.LABEL_PROTONS);
        this.jLabelProtonsReactant2.setText(NuclearProperties.LABEL_PROTONS);
        
        this.jLabelMolecularFormulaReactant1.setText(BinaryCompound.LABEL_ELEMENT_1);
        this.jLabelMolecularFormulaReactant2.setText(BinaryCompound.LABEL_ELEMENT_2);
        this.jLabelEquationReactant1.setText(BinaryCompound.LABEL_ELEMENT_1);
        this.jLabelEquationReactant2.setText(BinaryCompound.LABEL_ELEMENT_2);
        this.jLabelProductA.setText(BinaryCompound.LABEL_ELEMENT_1);
        this.jLabelProductB.setText(BinaryCompound.LABEL_ELEMENT_2);
        this.jLabelProductSubscriptA.setText(BinaryCompound.LABEL_SUBSCRIPT_1);
        this.jLabelProductSubscriptB.setText(BinaryCompound.LABEL_SUBSCRIPT_2);
        this.jLabelEquationProductA.setText(BinaryCompound.LABEL_ELEMENT_1);
        this.jLabelEquationProductB.setText(BinaryCompound.LABEL_ELEMENT_2);
        this.jLabelEquationProductSubscriptA.setText(BinaryCompound.LABEL_SUBSCRIPT_1);
        this.jLabelEquationProductSubscriptB.setText(BinaryCompound.LABEL_SUBSCRIPT_2);

        this.jLabelProductCharge.setText(BinaryCompound.LABEL_CHARGE);
        this.jLabelEquationProductCharge.setText(BinaryCompound.LABEL_CHARGE);
        this.jLabelProductName.setText(DatabaseGUI.REQUIRED_FIELD_SYMBOL + Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelProductMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelProductStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelProductStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelProductBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelProductMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelProductColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
    }
    
    private void setComponentsEnabled(boolean enabled) {
        this.jButtonSubmitProductProperties.setEnabled(enabled);
        this.jButtonTryAnother.setEnabled(enabled);
        this.jButtonSubmitReactants.setEnabled(!enabled);
        this.jTextFieldReactant1.setEnabled(!enabled);
        this.jTextFieldReactant2.setEnabled(!enabled);
        this.setProductTextFieldsEnabled(enabled);
    };
    
    private void setProductTextFieldsEnabled(boolean enabled) {
        this.jTextFieldProductName.setEnabled(enabled);
        this.jTextFieldProductDensity.setEnabled(enabled);
        this.jTextFieldProductBP.setEnabled(enabled);
        this.jTextFieldProductMP.setEnabled(enabled);
        this.jTextFieldProductColour.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabelReactant1 = new javax.swing.JLabel();
        jLabelReactant2 = new javax.swing.JLabel();
        jLabelProduct = new javax.swing.JLabel();
        jLabelEquation = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jButtonSubmitReactants = new javax.swing.JButton();
        jLabelInfo2 = new javax.swing.JLabel();
        jTextFieldReactant1 = new javax.swing.JTextField();
        jTextFieldReactant2 = new javax.swing.JTextField();
        jButtonTryAnother = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelEquationPlus = new javax.swing.JLabel();
        jLabelEquationArrow = new javax.swing.JLabel();
        jLabelEquationProductA = new javax.swing.JLabel();
        jLabelProductName = new javax.swing.JLabel();
        jLabelProductMolarMass = new javax.swing.JLabel();
        jLabelProductStpState = new javax.swing.JLabel();
        jLabelProductStpDensity = new javax.swing.JLabel();
        jLabelProductMP = new javax.swing.JLabel();
        jLabelProductBP = new javax.swing.JLabel();
        jLabelProductColour = new javax.swing.JLabel();
        jLabelProductCharge = new javax.swing.JLabel();
        jTextFieldProductName = new javax.swing.JTextField();
        jLabelEquationReactant2 = new javax.swing.JLabel();
        jLabelEquationReactant1 = new javax.swing.JLabel();
        jLabelEquationProductB = new javax.swing.JLabel();
        jLabelEquationProductSubscriptA = new javax.swing.JLabel();
        jLabelEquationProductSubscriptB = new javax.swing.JLabel();
        jLabelMolecularFormulaReactant1 = new javax.swing.JLabel();
        jLabelProtonsReactant1 = new javax.swing.JLabel();
        jLabelMassNumberReactant1 = new javax.swing.JLabel();
        jLabelProductSubscriptB = new javax.swing.JLabel();
        jLabelProductA = new javax.swing.JLabel();
        jLabelProductB = new javax.swing.JLabel();
        jLabelProductSubscriptA = new javax.swing.JLabel();
        jLabelOxNumReactant1 = new javax.swing.JLabel();
        jLabelMolecularFormulaReactant2 = new javax.swing.JLabel();
        jLabelProtonsReactant2 = new javax.swing.JLabel();
        jLabelMassNumberReactant2 = new javax.swing.JLabel();
        jLabelOxNumReactant2 = new javax.swing.JLabel();
        jButtonSubmitProductProperties = new javax.swing.JButton();
        jLabelEquationProductCharge = new javax.swing.JLabel();
        jTextFieldProductDensity = new javax.swing.JTextField();
        jTextFieldProductColour = new javax.swing.JTextField();
        jTextFieldProductBP = new javax.swing.JTextField();
        jTextFieldProductMP = new javax.swing.JTextField();
        jLabelInfoRequiredFields = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelReactant1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelReactant1.setText("Reactant 1");

        jLabelReactant2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelReactant2.setText("Reactant 2");

        jLabelProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelProduct.setText("Product");

        jLabelEquation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEquation.setText("Overall Equation:");

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Simulate Reaction");

        jButtonSubmitReactants.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSubmitReactants.setText("SUBMIT");
        jButtonSubmitReactants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitReactantsActionPerformed(evt);
            }
        });

        jLabelInfo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelInfo2.setText("Please specify names of elements for reactants");

        jTextFieldReactant1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldReactant1.setText("Enter Name Here");

        jTextFieldReactant2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldReactant2.setText("Enter Name Here");

        jButtonTryAnother.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTryAnother.setText("Try Another");
        jButtonTryAnother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTryAnotherActionPerformed(evt);
            }
        });

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonBack.setText("BACK");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelEquationPlus.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabelEquationPlus.setText("+");

        jLabelEquationArrow.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabelEquationArrow.setText("→");

        jLabelEquationProductA.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelEquationProductA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquationProductA.setText("A");

        jLabelProductName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductName.setText("*Name:");

        jLabelProductMolarMass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductMolarMass.setText("Molar Mass (g/mol):");

        jLabelProductStpState.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductStpState.setText("State @ STP:");

        jLabelProductStpDensity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductStpDensity.setText("Density @ STP (g/L):");

        jLabelProductMP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductMP.setText("Melting Point (C):");

        jLabelProductBP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductBP.setText("Boiling Point (C):");

        jLabelProductColour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProductColour.setText("Colour: ");

        jLabelProductCharge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductCharge.setText("Charge");

        jLabelEquationReactant2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelEquationReactant2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquationReactant2.setText("B");

        jLabelEquationReactant1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelEquationReactant1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquationReactant1.setText("A");

        jLabelEquationProductB.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelEquationProductB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquationProductB.setText("B");

        jLabelEquationProductSubscriptA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEquationProductSubscriptA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquationProductSubscriptA.setText("a");

        jLabelEquationProductSubscriptB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEquationProductSubscriptB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquationProductSubscriptB.setText("b");

        jLabelMolecularFormulaReactant1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMolecularFormulaReactant1.setText("A");

        jLabelProtonsReactant1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProtonsReactant1.setText("Atomic #");

        jLabelMassNumberReactant1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMassNumberReactant1.setText("Mass #");

        jLabelProductSubscriptB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProductSubscriptB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductSubscriptB.setText("b");

        jLabelProductA.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelProductA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductA.setText("A");

        jLabelProductB.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelProductB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductB.setText("B");

        jLabelProductSubscriptA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProductSubscriptA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductSubscriptA.setText("a");

        jLabelOxNumReactant1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelOxNumReactant1.setText("Oxidation #");

        jLabelMolecularFormulaReactant2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMolecularFormulaReactant2.setText("B");

        jLabelProtonsReactant2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProtonsReactant2.setText("Atomic #");

        jLabelMassNumberReactant2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMassNumberReactant2.setText("Mass #");

        jLabelOxNumReactant2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelOxNumReactant2.setText("Oxidation #");

        jButtonSubmitProductProperties.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSubmitProductProperties.setText("SUBMIT");
        jButtonSubmitProductProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitProductPropertiesActionPerformed(evt);
            }
        });

        jLabelEquationProductCharge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEquationProductCharge.setText("Charge");

        jLabelInfoRequiredFields.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelInfoRequiredFields.setText("* = required fields");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldReactant1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelProtonsReactant1)
                            .addComponent(jLabelMassNumberReactant1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMolecularFormulaReactant1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelOxNumReactant1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelReactant1)
                        .addGap(41, 41, 41)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldReactant2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelProtonsReactant2)
                                    .addComponent(jLabelMassNumberReactant2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelMolecularFormulaReactant2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelOxNumReactant2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabelReactant2)))
                .addGap(0, 172, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jButtonSubmitProductProperties)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelInfoRequiredFields))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabelProduct))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEquation)
                            .addComponent(jLabelEquationReactant1))
                        .addGap(49, 49, 49)
                        .addComponent(jLabelEquationPlus)
                        .addGap(68, 68, 68)
                        .addComponent(jLabelEquationReactant2)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelEquationArrow)
                        .addGap(54, 54, 54)
                        .addComponent(jLabelEquationProductA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEquationProductSubscriptA)
                        .addGap(3, 3, 3)
                        .addComponent(jLabelEquationProductB)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEquationProductSubscriptB))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabelEquationProductCharge)))))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSubmitReactants)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelInfo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTryAnother))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProductA)
                        .addGap(4, 4, 4)
                        .addComponent(jLabelProductSubscriptA)
                        .addGap(3, 3, 3)
                        .addComponent(jLabelProductB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProductSubscriptB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProductCharge))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProductName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelProductMolarMass)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProductStpDensity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldProductDensity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProductColour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldProductColour, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProductMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductBP))
                    .addComponent(jLabelProductStpState)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProductBP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldProductMP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jButtonBack))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTextFieldReactant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelMolecularFormulaReactant1)
                                .addComponent(jLabelMassNumberReactant1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelOxNumReactant1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelProtonsReactant1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelReactant2)
                            .addComponent(jLabelReactant1))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldReactant2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelMolecularFormulaReactant2)
                                .addComponent(jLabelMassNumberReactant2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelOxNumReactant2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelProtonsReactant2))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubmitReactants)
                    .addComponent(jLabelInfo2)
                    .addComponent(jButtonTryAnother))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProduct)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabelProductMolarMass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelProductStpDensity)
                                    .addComponent(jTextFieldProductDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelProductA)
                                                .addComponent(jLabelProductB))
                                            .addGap(4, 4, 4))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabelProductSubscriptB)
                                                .addComponent(jLabelProductSubscriptA))))
                                    .addComponent(jLabelProductCharge))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProductColour)
                            .addComponent(jTextFieldProductColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelProductName)
                            .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelProductStpState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProductBP)
                            .addComponent(jTextFieldProductMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProductMP)
                            .addComponent(jTextFieldProductBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubmitProductProperties)
                    .addComponent(jLabelInfoRequiredFields))
                .addGap(18, 18, 18)
                .addComponent(jLabelEquation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEquationProductB)
                                    .addGap(4, 4, 4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelEquationProductSubscriptB)
                                        .addComponent(jLabelEquationProductSubscriptA)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabelEquationProductCharge)
                            .addGap(37, 37, 37)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEquationPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelEquationArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelEquationProductA)
                        .addComponent(jLabelEquationReactant2)
                        .addComponent(jLabelEquationReactant1)))
                .addGap(0, 60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        if(this.productInfoEntered || this.noProduct){
            this.databaseGUI.startHomePage();
            this.setVisible(false);
        } else if (this.databaseGUI.newReactionPrompt() == DatabaseGUI.NEW_REACTION_PROMPT_OK) { 
            if (!this.noProduct) {
                this.databaseGUI.removeReaction(this.reaction.getID());
            }
            this.databaseGUI.startHomePage();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonSubmitReactantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitReactantsActionPerformed
        this.jButtonTryAnother.setEnabled(true);
        this.jButtonSubmitReactants.setEnabled(false);
        this.jTextFieldReactant1.setEnabled(false);
        this.jTextFieldReactant2.setEnabled(false);
        
        Chemical tempChemical1 = this.databaseGUI.searchChemicalsByName(this.jTextFieldReactant1.getText());
        Chemical tempChemical2 = this.databaseGUI.searchChemicalsByName(this.jTextFieldReactant2.getText());
        
        if (tempChemical1 instanceof Element && tempChemical2 instanceof Element) {
            this.reactant1 = (Element)tempChemical1;
            this.reactant2 = (Element)tempChemical2;
            
            if (this.reactant1 == this.reactant2)
                this.sameReactants = true;
            
            //Reactant 1
            this.jLabelMassNumberReactant1.setText(DatabaseGUI.EMPTY_STRING + (this.reactant1.getNumProton() + this.reactant1.getNumNeutron()));
            this.jLabelProtonsReactant1.setText(DatabaseGUI.EMPTY_STRING + this.reactant1.getNumProton());
            this.jLabelMolecularFormulaReactant1.setText(this.reactant1.getAtomicSymbol());
            this.jLabelOxNumReactant1.setText(DatabaseGUI.EMPTY_STRING + this.reactant1.getOxidationNum());
            
            //Reactant 2
            this.jLabelMassNumberReactant2.setText(DatabaseGUI.EMPTY_STRING + (this.reactant2.getNumProton() + this.reactant2.getNumNeutron()));
            this.jLabelProtonsReactant2.setText(DatabaseGUI.EMPTY_STRING + this.reactant2.getNumProton());
            this.jLabelMolecularFormulaReactant2.setText(this.reactant2.getAtomicSymbol());
            this.jLabelOxNumReactant2.setText(DatabaseGUI.EMPTY_STRING + this.reactant2.getOxidationNum());
            
            this.reaction = this.databaseGUI.simulateReaction(this.reactant1, this.reactant2);
  
            switch (this.reaction.getID()) {
                case Reaction.REPEATED_REACTION_ID:
                    JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_REPEATED_REACTION);
                    break;
                case Reaction.IMPOSSIBLE_REACTION_ID:
                    JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_IMPOSSIBLE_REACTION);
                    break;
                default:
                    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    this.removeWindowListener(this.databaseGUI.WINDOW_CLOSE);
                    this.addWindowListener(this.databaseGUI.WINDOW_CLOSE_NEW_REACTION);
                    
                    JOptionPane.showMessageDialog(null, DatabaseGUI.REACTION_SUCCESS);
                    this.setComponentsEnabled(true);
                    
                    this.noProduct = false;
                    this.product = this.reaction.getProduct();
                    //Check if Reactants are the same
                    if (!this.sameReactants) {
                        //Product Formulas
                        this.jLabelProductA.setText(this.product.getComponent1().getElement().getAtomicSymbol());
                        this.jLabelProductB.setText(this.product.getComponent2().getElement().getAtomicSymbol());
                        this.jLabelEquationProductA.setText(this.product.getComponent1().getElement().getAtomicSymbol());
                        this.jLabelEquationProductB.setText(this.product.getComponent2().getElement().getAtomicSymbol());
                        
                        //Subscripts
                        if (this.product.getComponent1().getNumOccurrence() > 1) {
                            this.jLabelProductSubscriptA.setText(DatabaseGUI.EMPTY_STRING + this.product.getComponent1().getNumOccurrence());
                            this.jLabelEquationProductSubscriptA.setText(DatabaseGUI.EMPTY_STRING + this.product.getComponent1().getNumOccurrence());
                        } else {
                            this.jLabelProductSubscriptA.setText(DatabaseGUI.EMPTY_STRING);
                            this.jLabelEquationProductSubscriptA.setText(DatabaseGUI.EMPTY_STRING);
                        }
                        if (this.product.getComponent2().getNumOccurrence() > 1) {
                            this.jLabelProductSubscriptB.setText(DatabaseGUI.EMPTY_STRING + this.product.getComponent2().getNumOccurrence());
                            this.jLabelEquationProductSubscriptB.setText(DatabaseGUI.EMPTY_STRING + this.product.getComponent2().getNumOccurrence());
                        } else {
                            this.jLabelProductSubscriptB.setText(DatabaseGUI.EMPTY_STRING);
                            this.jLabelEquationProductSubscriptB.setText(DatabaseGUI.EMPTY_STRING);
                        }
                    } else {
                        this.jLabelProductA.setText(DatabaseGUI.EMPTY_STRING);
                        this.jLabelProductSubscriptA.setText(DatabaseGUI.EMPTY_STRING);
                        this.jLabelEquationProductA.setText(DatabaseGUI.EMPTY_STRING);
                        this.jLabelEquationProductSubscriptA.setText(DatabaseGUI.EMPTY_STRING);
                        
                        this.jLabelProductB.setText(this.product.getComponent2().getElement().getAtomicSymbol());
                        this.jLabelProductSubscriptB.setText(DatabaseGUI.EMPTY_STRING + (this.product.getComponent1().getNumOccurrence() + this.product.getComponent2().getNumOccurrence()));
                        this.jLabelEquationProductB.setText(this.product.getComponent2().getElement().getAtomicSymbol());
                        this.jLabelEquationProductSubscriptB.setText(DatabaseGUI.EMPTY_STRING + (this.product.getComponent1().getNumOccurrence() + this.product.getComponent2().getNumOccurrence()));
                    }   

                    //Reactants in Equation
                    this.jLabelEquationReactant1.setText(this.reactant1.getAtomicSymbol());
                    this.jLabelEquationReactant2.setText(this.reactant2.getAtomicSymbol());
                    
                    //Product Properties
                    this.jLabelProductMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + this.product.getMolarMass());
                    if (this.product.getStpState() == Chemical.DEFAULT_STATE)
                        this.jLabelProductStpState.setText(Chemical.LABEL_STP_STATE + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + Chemical.DEFAULT_COMMON_NAME);
                    else
                        this.jLabelProductStpState.setText(Chemical.LABEL_STP_STATE + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + this.product.getStpState());
                    
                    //Set Charges for both
                    int charge = this.product.getCharge();
                    if (charge != 0) {
                        if (charge > 0) {
                            this.jLabelProductCharge.setText(DatabaseGUI.POSITIVE_CHARGE + charge);
                            this.jLabelEquationProductCharge.setText(DatabaseGUI.POSITIVE_CHARGE + charge);
                        } else {
                            this.jLabelProductCharge.setText(DatabaseGUI.EMPTY_STRING + charge);
                            this.jLabelEquationProductCharge.setText(DatabaseGUI.EMPTY_STRING + charge);
                        }
                    } else {
                        this.jLabelProductCharge.setText(DatabaseGUI.EMPTY_STRING);
                        this.jLabelEquationProductCharge.setText(DatabaseGUI.EMPTY_STRING);
                    }   
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, Reaction.LABEL_REACTANT + DatabaseGUI.WARNING_NOT_FOUND);
        }
    }//GEN-LAST:event_jButtonSubmitReactantsActionPerformed

    private void jButtonTryAnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTryAnotherActionPerformed
        if(this.productInfoEntered || this.noProduct){
            this.start(this);
        }else if (this.databaseGUI.newReactionPrompt() == DatabaseGUI.NEW_REACTION_PROMPT_OK) {
            if (!this.noProduct) {
                this.databaseGUI.removeReaction(this.reaction.getID());
            }
            this.start(this);
        }
    }//GEN-LAST:event_jButtonTryAnotherActionPerformed

    private void jButtonSubmitProductPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitProductPropertiesActionPerformed
        String commonName; 
        double bp;
        double mp;
        double density;
        String colour;
        
        try {
            //read required fields
            commonName = jTextFieldProductName.getText();
            
            //read optional fields
            if (!this.jTextFieldProductDensity.getText().equals(DatabaseGUI.EMPTY_STRING))
                density = Double.parseDouble(this.jTextFieldProductDensity.getText());
            else
                density = Chemical.DEFAULT_DENSITY;
            
            if (!this.jTextFieldProductBP.getText().equals(DatabaseGUI.EMPTY_STRING))
                bp = Double.parseDouble(this.jTextFieldProductBP.getText());
            else
                bp = Chemical.DEFAULT_STATE_CHANGE_TEMP;
            
            if (!this.jTextFieldProductMP.getText().equals(DatabaseGUI.EMPTY_STRING))
                mp = Double.parseDouble(this.jTextFieldProductMP.getText());
            else
                mp = Chemical.DEFAULT_STATE_CHANGE_TEMP;
            
            if (!this.jTextFieldProductColour.getText().equals(DatabaseGUI.EMPTY_STRING))
                colour = this.jTextFieldProductColour.getText();
            else
                colour = Chemical.DEFAULT_COLOUR;
            
            //create temp BinaryCompound
            BinaryCompound newBinaryCompound = new BinaryCompound();
            
            //check fields
            if(commonName.equals(DatabaseGUI.EMPTY_STRING))
                JOptionPane.showMessageDialog(null, DatabaseGUI.REQUIRED_FIELD + DatabaseGUI.ERROR_FIELD_EMPTY);
            
            else if(!newBinaryCompound.setCommonName(commonName))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_NAME.toLowerCase());
            
            else if(commonName.length() > DatabaseGUI.MAXIMUM_STRING_LENGTH)
                JOptionPane.showMessageDialog(null, Chemical.LABEL_NAME + DatabaseGUI.ERROR_TOO_LONG);
            
            else if(!newBinaryCompound.setStpDensity(density))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_STP_DENSITY.toLowerCase());
            
            else if(!newBinaryCompound.setBP(bp))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_BP.toLowerCase());
            
            else if(!newBinaryCompound.setMP(mp))
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ILLEGAL_DATA + Chemical.LABEL_MP.toLowerCase());
            
            else if (this.databaseGUI.editBinaryCompounds(this.product, commonName, density, bp, mp, colour)) {
                this.removeWindowListener(this.databaseGUI.WINDOW_CLOSE_NEW_REACTION);
                this.addWindowListener(this.databaseGUI.WINDOW_CLOSE);
                
                this.product = (BinaryCompound)this.databaseGUI.searchChemicalsByName(commonName);
                this.jLabelProductStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION + this.product.getStpState());
                this.productInfoEntered = true;
                JOptionPane.showMessageDialog(null, DatabaseGUI.REACTION_PROPERTIES_SUCCESS); 
                
            }else
                JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_REPEAT);
            
        } catch(NumberFormatException nfx) {
            JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_ERRONEOUS_DATA);
        }
    }//GEN-LAST:event_jButtonSubmitProductPropertiesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSubmitProductProperties;
    private javax.swing.JButton jButtonSubmitReactants;
    private javax.swing.JButton jButtonTryAnother;
    private javax.swing.JLabel jLabelEquation;
    private javax.swing.JLabel jLabelEquationArrow;
    private javax.swing.JLabel jLabelEquationPlus;
    private javax.swing.JLabel jLabelEquationProductA;
    private javax.swing.JLabel jLabelEquationProductB;
    private javax.swing.JLabel jLabelEquationProductCharge;
    private javax.swing.JLabel jLabelEquationProductSubscriptA;
    private javax.swing.JLabel jLabelEquationProductSubscriptB;
    private javax.swing.JLabel jLabelEquationReactant1;
    private javax.swing.JLabel jLabelEquationReactant2;
    private javax.swing.JLabel jLabelInfo2;
    private javax.swing.JLabel jLabelInfoRequiredFields;
    private javax.swing.JLabel jLabelMassNumberReactant1;
    private javax.swing.JLabel jLabelMassNumberReactant2;
    private javax.swing.JLabel jLabelMolecularFormulaReactant1;
    private javax.swing.JLabel jLabelMolecularFormulaReactant2;
    private javax.swing.JLabel jLabelOxNumReactant1;
    private javax.swing.JLabel jLabelOxNumReactant2;
    private javax.swing.JLabel jLabelProduct;
    private javax.swing.JLabel jLabelProductA;
    private javax.swing.JLabel jLabelProductB;
    private javax.swing.JLabel jLabelProductBP;
    private javax.swing.JLabel jLabelProductCharge;
    private javax.swing.JLabel jLabelProductColour;
    private javax.swing.JLabel jLabelProductMP;
    private javax.swing.JLabel jLabelProductMolarMass;
    private javax.swing.JLabel jLabelProductName;
    private javax.swing.JLabel jLabelProductStpDensity;
    private javax.swing.JLabel jLabelProductStpState;
    private javax.swing.JLabel jLabelProductSubscriptA;
    private javax.swing.JLabel jLabelProductSubscriptB;
    private javax.swing.JLabel jLabelProtonsReactant1;
    private javax.swing.JLabel jLabelProtonsReactant2;
    private javax.swing.JLabel jLabelReactant1;
    private javax.swing.JLabel jLabelReactant2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldProductBP;
    private javax.swing.JTextField jTextFieldProductColour;
    private javax.swing.JTextField jTextFieldProductDensity;
    private javax.swing.JTextField jTextFieldProductMP;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldReactant1;
    private javax.swing.JTextField jTextFieldReactant2;
    // End of variables declaration//GEN-END:variables
}