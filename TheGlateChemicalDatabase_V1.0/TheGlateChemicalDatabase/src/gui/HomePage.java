package gui;

import databaserunner.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class HomePage extends javax.swing.JFrame implements WindowListener{

    //our fields
    private int numRow;
    private int numCol;
    private int firstValence;

    private String[][] table;
    private String[] header;

    private DatabaseGUI databaseGUI;

    /**
     * Creates new form Home
     */
    public HomePage(DatabaseGUI databaseGUI) {
        this.databaseGUI = databaseGUI;
        this.initComponents();
    }

    //our methods
    public void start(HomePage homePage) {
        this.createTable();
        this.initConstants();
        
        jTablePeriodicTable.setModel(new javax.swing.table.DefaultTableModel(
            this.table,
            this.header
        ));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                homePage.setVisible(true);
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
        this.jTextFieldRemoveChemical.setText(DatabaseGUI.TEXT_FIELD_ENTER_NAME);
        
        this.jLabelCommonName.setText(Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelAtomicSymbol.setText(Element.LABEL_ALT_ATOMIC_SYMBOL);
        this.jLabelNumProton.setText(NuclearProperties.LABEL_PROTONS);
        this.jLabelNumElectron.setText(NuclearProperties.LABEL_ELECTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMassNumber.setText(NuclearProperties.LABEL_MASS_NUMBER);
        this.jLabelElectronegativity.setText(NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION);
        this.jLabelOxidationNum.setText(Element.LABEL_OXIDATION_NUMBER);
    }
    
    private void createTable(){
        this.databaseGUI.updateTable();
        
        this.firstValence = this.databaseGUI.getDatabase().getPeriodicTable().getFirstValence();
        this.numRow = this.databaseGUI.getDatabase().getPeriodicTable().getTable().size();
        this.numCol = this.databaseGUI.getDatabase().getPeriodicTable().getNumCol();
        
        this.table = new String[this.numRow][this.numCol];
        this.header = new String[this.numCol];

        for(int i = 0; i < this.numCol; i++){
            this.header[i] = DatabaseGUI.EMPTY_STRING + (i + 1);
        }
        for(int i = 0; i < this.numRow; i++){
            for(int j = 0; j < this.databaseGUI.getDatabase().getPeriodicTable().getTable().get(i).numItems(); j++){
                this.table[i][j] = this.databaseGUI.getDatabase().getPeriodicTable().getTable().get(i).getPeriodElements()[j].getAtomicSymbol();
                if(this.table[i][j].equals(Element.DEFAULT_ATOMIC_SYMBOL))
                    this.table[i][j] = this.databaseGUI.EMPTY_STRING;
            }
        }
        
        //move relevant items of each row to right end of this.table
        for(int i = 0; i < this.numRow; i++){
            int lastIndex = this.databaseGUI.getDatabase().getPeriodicTable().getTable().get(i).getPeriodElements().length - 1;
            if(lastIndex != this.numCol-1){
                this.table[i][this.numCol-1] = this.table[i][lastIndex];
                this.table[i][lastIndex] = null;
                for (int j = lastIndex - 1 ; j > this.firstValence - 1 ; j--) {
                    this.table[i][this.numCol - lastIndex + j - 1] = this.table[i][j];
                    this.table[i][j] = null;
                }
            }
        }
        for(int i = this.firstValence / 2; i <= this.firstValence - 2; i++){
            this.table[0][this.numCol-this.firstValence+i] = this.table[0][i];
            this.table[0][i] = null;
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
        jLabelAtomicSymbol = new javax.swing.JLabel();
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
        jButtonSortChemicals = new javax.swing.JButton();
        jButtonSimulateReaction = new javax.swing.JButton();
        jButtonListReactions = new javax.swing.JButton();
        jButtonListBinaryCompounds = new javax.swing.JButton();
        jButtonEditChemical = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelOxidationNum = new javax.swing.JLabel();
        jTextFieldRemoveChemical = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonFunButton = new javax.swing.JButton();
        jLabelMassNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setText("Periodic Table of Elements");

        jTablePeriodicTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePeriodicTable.setModel(new javax.swing.table.DefaultTableModel(
            this.table,
            this.header
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

        jLabelAtomicSymbol.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelAtomicSymbol.setText("X");

        jLabelCommonName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCommonName.setText("Name:");

        jLabelNumProton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumProton.setText("Atomic #");

        jLabelNumElectron.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumElectron.setText("Electrons:");

        jLabelNumNeutron.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumNeutron.setText("Neutrons:");

        jLabelMolarMass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMolarMass.setText("Molar Mass (g/mol):");

        jLabelStpState.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelStpState.setText("State @ STP:");

        jLabelStpDensity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelStpDensity.setText("Density @ STP (g/L):");

        jLabelMP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMP.setText("Melting Point (C):");

        jLabelBP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBP.setText("Boiling Point (C):");

        jLabelIonizationEnergy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIonizationEnergy.setText("Ionization Energy:");

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

        jButtonListBinaryCompounds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonListBinaryCompounds.setText("List Compounds");
        jButtonListBinaryCompounds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListBinaryCompoundsActionPerformed(evt);
            }
        });

        jButtonEditChemical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditChemical.setText("Edit Chemical");
        jButtonEditChemical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditChemicalActionPerformed(evt);
            }
        });

        jLabelOxidationNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelOxidationNum.setText("Oxidation #");

        jTextFieldRemoveChemical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRemoveChemical.setText("Chemical Name");

        jLabel1.setText(" > > >");

        jButtonFunButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFunButton.setText("Fun Button :D");
        jButtonFunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFunButtonActionPerformed(evt);
            }
        });

        jLabelMassNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMassNumber.setText("Mass #");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelTitle)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNumProton)
                            .addComponent(jLabelMassNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelAtomicSymbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelOxidationNum))
                    .addComponent(jLabelCommonName)
                    .addComponent(jLabelStpState)
                    .addComponent(jLabelMolarMass)
                    .addComponent(jLabelStpDensity)
                    .addComponent(jLabelNumNeutron)
                    .addComponent(jLabelNumElectron)
                    .addComponent(jLabelColour)
                    .addComponent(jLabelIonizationEnergy)
                    .addComponent(jLabelElectronegativity)
                    .addComponent(jLabelMP)
                    .addComponent(jLabelBP))
                .addGap(246, 246, 246)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAddElement, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRemoveChemical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonSortChemicals, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jTextFieldRemoveChemical)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonListBinaryCompounds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSimulateReaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonListReactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditChemical, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                    .addComponent(jButtonFunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
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
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelOxidationNum)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelAtomicSymbol)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelMassNumber)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelNumProton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCommonName)
                                .addGap(5, 5, 5)
                                .addComponent(jLabelNumElectron)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNumNeutron)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMolarMass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStpState)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStpDensity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIonizationEnergy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelElectronegativity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelColour)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReload)
                            .addComponent(jButtonSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddElement)
                            .addComponent(jButtonSortChemicals))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRemoveChemical)
                            .addComponent(jTextFieldRemoveChemical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonListBinaryCompounds)
                            .addComponent(jButtonListReactions))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSimulateReaction)
                            .addComponent(jButtonEditChemical))
                        .addGap(28, 28, 28)
                        .addComponent(jButtonFunButton)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //runs when user selects element from this.table
    private void jTablePeriodicTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePeriodicTableMousePressed
        //get selected row & column from mouse
        int row = jTablePeriodicTable.rowAtPoint(evt.getPoint());
        int col = jTablePeriodicTable.columnAtPoint(evt.getPoint());
        String selectedString = this.table[row][col];
        
        if(selectedString != null){
            if(selectedString.equals(this.databaseGUI.EMPTY_STRING))
                selectedString = Element.DEFAULT_ATOMIC_SYMBOL;
            
            //display all properties of the element the user clicked on
            Element selectedElement = this.databaseGUI.searchElementByAtomicSymbol(selectedString);
            this.jLabelAtomicSymbol.setText(selectedElement.getAtomicSymbol());
            this.jLabelCommonName.setText(Chemical.LABEL_NAME + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getCommonName());
            this.jLabelNumProton.setText(DatabaseGUI.EMPTY_STRING + selectedElement.getNumProton());
            this.jLabelNumElectron.setText(NuclearProperties.LABEL_ELECTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getNumElectron());
            
            if (selectedElement.getNumNeutron() == NuclearProperties.DEFAULT_NEUTRONS)
                this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelNumNeutron.setText(NuclearProperties.LABEL_NEUTRONS + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getNumNeutron());
            
            this.jLabelMassNumber.setText(DatabaseGUI.EMPTY_STRING + (selectedElement.getNumProton() + selectedElement.getNumNeutron()));
            
            if (selectedElement.getMolarMass() == Chemical.DEFAULT_MOLAR_MASS)
                this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelMolarMass.setText(Chemical.LABEL_MOLAR_MASS + Chemical.LABEL_MOLAR_MASS_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getMolarMass());
            
            if (selectedElement.getStpState() == Chemical.DEFAULT_STATE)
                this.jLabelStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelStpState.setText(Chemical.LABEL_STP_STATE + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getStpState());
            
            if (selectedElement.getStpDensity() == Chemical.DEFAULT_DENSITY)
                this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelStpDensity.setText(Chemical.LABEL_STP_DENSITY + Chemical.LABEL_DENSITY_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getStpDensity());
            
            if (selectedElement.getMP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelMP.setText(Chemical.LABEL_MP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getMP());
            
            if (selectedElement.getBP() == Chemical.DEFAULT_STATE_CHANGE_TEMP)
                this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelBP.setText(Chemical.LABEL_BP + Chemical.LABEL_STATE_CHANGE_UNIT + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getBP());
            
            if (selectedElement.getIonizationEnergy() == NuclearProperties.DEFAULT_IONIZATION_ENERGY)
                this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            else
                this.jLabelIonizationEnergy.setText(NuclearProperties.LABEL_IONIZATION_ENERGY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getIonizationEnergy());
            
            
            this.jLabelColour.setText(Chemical.LABEL_COLOUR + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getColour());
            if(!selectedString.equals(Element.DEFAULT_ATOMIC_SYMBOL)) {
                this.jLabelElectronegativity.setText(NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + selectedElement.getElectronegativity());
                if (selectedElement.getOxidationNum() > 0) 
                    this.jLabelOxidationNum.setText(DatabaseGUI.POSITIVE_CHARGE + selectedElement.getOxidationNum());
                else 
                    this.jLabelOxidationNum.setText(DatabaseGUI.EMPTY_STRING + selectedElement.getOxidationNum());
            }
            else {
                this.jLabelOxidationNum.setText(DatabaseGUI.DEFAULT_STRING);
                this.jLabelElectronegativity.setText(NuclearProperties.LABEL_ELECTRONEGATIVITY + DatabaseGUI.ASSIGNMENT_PUNCTUATION + DatabaseGUI.DEFAULT_STRING);
            }
        }
    }//GEN-LAST:event_jTablePeriodicTableMousePressed

    //Reload button
    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        if (this.databaseGUI.savePrompt(false) != 2) {
            this.databaseGUI.restart();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonReloadActionPerformed

    //Save button
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        this.databaseGUI.saveDialog();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    //Add Element button
    private void jButtonAddElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddElementActionPerformed
        this.databaseGUI.startAddElement();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddElementActionPerformed

    //Remove Chemical button
    private void jButtonRemoveChemicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveChemicalActionPerformed
        String name = jTextFieldRemoveChemical.getText();
        if(this.databaseGUI.removeChemical(name)){
            this.start(this);
            this.setVisible(false);
        }else
            JOptionPane.showMessageDialog(null, name + DatabaseGUI.WARNING_NOT_FOUND + DatabaseGUI.ENDING_PUNCTUATION);
    }//GEN-LAST:event_jButtonRemoveChemicalActionPerformed

    //Sort Chemicals button
    private void jButtonSortChemicalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortChemicalsActionPerformed
        this.databaseGUI.startSortChemicals();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSortChemicalsActionPerformed

    //List Compounds button
    private void jButtonListBinaryCompoundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListBinaryCompoundsActionPerformed
        this.databaseGUI.startListBinaryCompounds();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonListBinaryCompoundsActionPerformed

    //List Reactions button
    private void jButtonListReactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListReactionsActionPerformed
        this.databaseGUI.startListReactions();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonListReactionsActionPerformed

    //Simulate Reaction button
    private void jButtonSimulateReactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimulateReactionActionPerformed
        this.databaseGUI.startSimulateReaction();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSimulateReactionActionPerformed

    //Edit Chemical button
    private void jButtonEditChemicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditChemicalActionPerformed
        this.databaseGUI.startEditChemicals();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEditChemicalActionPerformed

    private void jButtonFunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFunButtonActionPerformed
        this.databaseGUI.startFunButton();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFunButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddElement;
    private javax.swing.JButton jButtonEditChemical;
    private javax.swing.JButton jButtonFunButton;
    private javax.swing.JButton jButtonListBinaryCompounds;
    private javax.swing.JButton jButtonListReactions;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonRemoveChemical;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSimulateReaction;
    private javax.swing.JButton jButtonSortChemicals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAtomicSymbol;
    private javax.swing.JLabel jLabelBP;
    private javax.swing.JLabel jLabelColour;
    private javax.swing.JLabel jLabelCommonName;
    private javax.swing.JLabel jLabelElectronegativity;
    private javax.swing.JLabel jLabelIonizationEnergy;
    private javax.swing.JLabel jLabelMP;
    private javax.swing.JLabel jLabelMassNumber;
    private javax.swing.JLabel jLabelMolarMass;
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