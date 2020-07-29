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
    
    private List<Chemical> chemicals;
    private String selectedProperty;
    private String[] chemicalNames;
    
    private DatabaseGUI databaseGUI;
    
    /**
     * Creates new form SortChemicals
     */
    public SortChemicals(DatabaseGUI databaseGUI) {
        this.databaseGUI = databaseGUI;
        this.chemicals = new ArrayList();
        this.chemicalNames = new String[DatabaseGUI.EMPTY_ARRAY_SIZE];
        initComponents();  
    }
    
    public void start(SortChemicals sortChemicals) {
        this.createList();
        this.initConstants();
        
        this.jListSortedChemicals.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = chemicalNames;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sortChemicals.setVisible(true);
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
        this.jLabelCommonName.setText(Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelCommonNameExtra.setText(DatabaseGUI.EMPTY_STRING);
        this.jLabelMolecularFormula.setText(Element.LABEL_ATOMIC_SYMBOL + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelNumProton.setText(NuclearProperties.LABEL_PROTONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelNumElectron.setText(NuclearProperties.LABEL_ELECTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelCharge.setText(BinaryCompound.LABEL_CHARGE + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelElectronegativity.setText(NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelColourExtra.setText(DatabaseGUI.EMPTY_STRING);
        this.jLabelOxidationNum.setText(Element.LABEL_OXIDATION_NUMBER + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
    }
    
    private void createList() {
        this.chemicalNames = new String[this.chemicals.size()];
        for(int i = 0; i < this.chemicalNames.length; i++){
            this.chemicalNames[i] = this.chemicals.get(i).getCommonName();
        }
    }

    private String[] stringInHalf(String originalName) {
        String[] fullName = originalName.split(DatabaseGUI.SPACE);
        String name1 = DatabaseGUI.EMPTY_STRING;
        String name2 = DatabaseGUI.EMPTY_STRING;
        
        int charsUsed = 0;
        for (int i = 0 ; i < fullName.length ; i++) {
            if (charsUsed > DatabaseGUI.MAXIMUM_STRING_LENGTH / 2)
                name2 += fullName[i] + DatabaseGUI.SPACE;
            else {
                if (fullName[i].length() > DatabaseGUI.MAXIMUM_STRING_LENGTH / 2) {
                    name1 += fullName[i].substring(DatabaseGUI.BEGINNING_INDEX, (DatabaseGUI.MAXIMUM_STRING_LENGTH / 2) - charsUsed) + DatabaseGUI.WORD_SPLIT;
                    name2 += fullName[i].substring((DatabaseGUI.MAXIMUM_STRING_LENGTH / 2) - charsUsed) + DatabaseGUI.SPACE;
                } else
                    name1 += fullName[i] + DatabaseGUI.SPACE;
            }
            charsUsed += fullName[i].length();
        }
        
        return new String[] {name1, name2};
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
        jLabelCommonNameExtra = new javax.swing.JLabel();
        jLabelColourExtra = new javax.swing.JLabel();

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
        jLabelOxidationNum.setText("Oxidation #:");

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

        jLabelCommonNameExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCommonNameExtra.setText("[]");

        jLabelColourExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelColourExtra.setText("[]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCommonName)
                                    .addComponent(jLabelMolarMass)
                                    .addComponent(jLabelStpDensity)
                                    .addComponent(jLabelBP)
                                    .addComponent(jLabelMP)
                                    .addComponent(jLabelColour)
                                    .addComponent(jLabelMolecularFormula)
                                    .addComponent(jLabelStpState)
                                    .addComponent(jLabelNumProton)
                                    .addComponent(jLabelNumElectron)
                                    .addComponent(jLabelNumNeutron)
                                    .addComponent(jLabelIonizationEnergy)
                                    .addComponent(jLabelOxidationNum)
                                    .addComponent(jLabelCharge)
                                    .addComponent(jLabelElectronegativity)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabelCommonNameExtra))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabelColourExtra)))
                        .addContainerGap(189, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jComboBoxFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSort)
                    .addComponent(jButtonBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCommonName)
                        .addGap(9, 9, 9)
                        .addComponent(jLabelCommonNameExtra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(2, 2, 2)
                        .addComponent(jLabelColourExtra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Sort button
    private void jButtonSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortActionPerformed
        
        selectedProperty = (String)jComboBoxFilters.getSelectedItem();
        
        if (selectedProperty == null) {
            JOptionPane.showMessageDialog(null, DatabaseGUI.WARNING_NO_PROPERTY_SELECTED);
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
                    chemicals = this.databaseGUI.sortChemicalsByStpState(Chemical.SOLID_STATE);
                    break;
                case LIQUID:
                    chemicals = this.databaseGUI.sortChemicalsByStpState(Chemical.LIQUID_STATE);
                    break;
                case GAS:
                    chemicals = this.databaseGUI.sortChemicalsByStpState(Chemical.GASEOUS_STATE);
                    break;
                default:
                    chemicals = null;
                    this.databaseGUI.startHomePage();
                    this.setVisible(false);
            } 
            this.createList();
            
            this.start(this);
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
            
            if (selectedChemical.getCommonName().length() > DatabaseGUI.MAXIMUM_STRING_LENGTH / 2) {
                String[] splitName = this.stringInHalf(selectedChemical.getCommonName());
                this.jLabelCommonName.setText(Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION + splitName[0]);
                this.jLabelCommonNameExtra.setText(splitName[1]);
            } else {
                this.jLabelCommonName.setText(Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getCommonName());
                this.jLabelCommonNameExtra.setText(DatabaseGUI.EMPTY_STRING);
            }
            
            if (selectedChemical.getColour().length() > DatabaseGUI.MAXIMUM_STRING_LENGTH / 2) {
                String[] splitName = this.stringInHalf(selectedChemical.getColour());
                this.jLabelColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION + splitName[0]);
                this.jLabelColourExtra.setText(splitName[1]);
            } else {
                this.jLabelColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getColour());
                this.jLabelColourExtra.setText(DatabaseGUI.EMPTY_STRING);
            }
            
            if (selectedChemical.getMolarMass() == Chemical.DEFAULT_MOLAR_MASS)
                this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getMolarMass());
            
            if (selectedChemical.getStpState() == Chemical.DEFAULT_STATE)
                this.jLabelStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getStpState());
            
            if (selectedChemical.getStpDensity() == Chemical.DEFAULT_DENSITY)
                this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getStpDensity());
            
            if (selectedChemical.getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getMP());
            
            if (selectedChemical.getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedChemical.getBP());
            
            if(chemicals.get(index) instanceof Element){
                Element selectedElement = (Element)chemicals.get(index);
                
                this.jLabelMolecularFormula.setText(Element.LABEL_ATOMIC_SYMBOL + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getAtomicSymbol());
                this.jLabelOxidationNum.setEnabled(true);
                if (selectedElement.getOxidationNum() > 0) 
                    this.jLabelOxidationNum.setText(Element.LABEL_OXIDATION_NUMBER + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.POSITIVE_CHARGE + selectedElement.getOxidationNum());
                else 
                    this.jLabelOxidationNum.setText(Element.LABEL_OXIDATION_NUMBER + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getOxidationNum());
                this.jLabelNumProton.setEnabled(true);
                this.jLabelNumProton.setText(NuclearProperties.LABEL_PROTONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getNumProton());
                this.jLabelNumElectron.setEnabled(true);
                this.jLabelNumElectron.setText(NuclearProperties.LABEL_ELECTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getNumElectron());
                this.jLabelNumNeutron.setEnabled(true);
                if (selectedElement.getNumNeutron() == NuclearProperties.DEFAULT_NEUTRONS)
                    this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
                else
                    this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getNumNeutron());
                this.jLabelIonizationEnergy.setEnabled(true);
                if (selectedElement.getIonizationEnergy() == NuclearProperties.DEFAULT_IONIZATION_ENERGY)
                    this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
                else
                    this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getIonizationEnergy());
                this.jLabelElectronegativity.setEnabled(true);
                this.jLabelElectronegativity.setText(NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getElectronegativity());
                
                this.jLabelCharge.setText(BinaryCompound.LABEL_CHARGE + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelCharge.setEnabled(false);
                
            }else if(chemicals.get(index) instanceof BinaryCompound){
                BinaryCompound selectedBinaryCompound = (BinaryCompound)chemicals.get(index);
                
                this.jLabelMolecularFormula.setText(BinaryCompound.LABEL_MOLECULAR_FORMULA + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedBinaryCompound.getMolecularFormula());
                this.jLabelCharge.setEnabled(true);
                this.jLabelCharge.setText(BinaryCompound.LABEL_CHARGE + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedBinaryCompound.getCharge());
                
                this.jLabelOxidationNum.setText(Element.LABEL_OXIDATION_NUMBER + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelOxidationNum.setEnabled(false);
                this.jLabelNumProton.setText(NuclearProperties.LABEL_PROTONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelNumProton.setEnabled(false);
                this.jLabelNumElectron.setText(NuclearProperties.LABEL_ELECTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelNumElectron.setEnabled(false);
                this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelNumNeutron.setEnabled(false);
                this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelIonizationEnergy.setEnabled(false);
                this.jLabelElectronegativity.setText(NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
                this.jLabelElectronegativity.setEnabled(false); 
            }
        }
    }//GEN-LAST:event_jListSortedChemicalsMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSort;
    private javax.swing.JComboBox<String> jComboBoxFilters;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelCharge;
    private javax.swing.JLabel jLabelColour;
    private javax.swing.JLabel jLabelColourExtra;
    private javax.swing.JLabel jLabelCommonName;
    private javax.swing.JLabel jLabelCommonNameExtra;
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