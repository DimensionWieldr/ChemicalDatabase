package databaserunner;

import gui.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DatabaseGUI {
    
    ///
    //FIELDS
    ///
    
    //Global constants
    public static final String DEFAULT_STRING = "unknown";
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final String LINE_BREAK = "\n";
    public static final String CHAR_QUOTE = "'";
    public static final String ASSIGNMENT_PUNCTUATION = ": ";
    public static final String ENDING_PUNCTUATION = "!";
    public static final String REQUIRED_FIELD_SYMBOL = "*";
    public static final String POSITIVE_CHARGE = "+";
    public static final String WORD_SPLIT = "-";
    public static final int BEGINNING_INDEX = 0;
    public static final int EMPTY_ARRAY_SIZE = 0;
    
    //FILE I/O constants
    public static final char VALID_FILE = 'V';
    public static final char EMPTY_FILE = 'E';
    public static final char FILE_NAME_TOO_LONG = 'L';
    public static final String FILE_EXTENSION = ".txt";
    public static final char[] ILLEGAL_CHARS = {'/', '\\', '?', '%', '*', ':', '|', '\"', '<', '>', '.'};
    
    //Length restriction constants
    public static final int MAXIMUM_STRING_LENGTH = 32;
    public static final int MAXIMUM_ATOMIC_SYMBOL_LENGTH = 3;
    public static final int MAXIMUM_ATOMIC_NUM_SIZE = 1000000;
    
    //Save prompt option constants
    public static final String[] SAVE_PROMPT_OPTIONS = {"Yes", "No", "Cancel"};
    public static final int SAVE_PROMPT_YES = 0;
    public static final int SAVE_PROMPT_NO = 1;
    public static final int SAVE_PROMPT_CANCEL = 2;
    public static final String[] NEW_REACTION_PROMPT_OPTIONS = {"Ok", "Cancel"};
    public static final int NEW_REACTION_PROMPT_OK = 0;
    public static final int NEW_REACTION_PROMPT_CANCEL = 1;
     
    //Variable Name Constants
    public static final String ELEMENTS_FILE_NAME = "Elements file name";
    public static final String BINARY_COMPOUNDS_FILE_NAME = "Compounds file name";
    public static final String REACTIONS_FILE_NAME = "Reactions file name";
    public static final String ELEMENTS_FILE = "Elements file";
    public static final String BINARY_COMPOUNDS_FILE = "Compounds file";
    public static final String REACTIONS_FILE = "Reactions file";
    
    public static final String DEFAULT_ELEMENTS_FILE = "elements";
    public static final String DEFAULT_BINARY_COMPOUNDS_FILE = "compounds";
    public static final String DEFAULT_REACTIONS_FILE = "reactions";
    
    public static final String REQUIRED_FIELD = "Required fields";
      
    //Warning message constants
    public static final String WARNING = "WARNING: ";
    public static final String WARNING_CHANGING_PERIODIC_PROPERTY = "If you change this property,"
                                                                    + "\nit will reset a lot of reaction data!";
    public static final String WARNING_NOT_FOUND = " not found!";
    public static final String WARNING_PRODUCT_INFO_ENTERED = "Please name your product!";
    public static final String WARNING_NO_PROPERTY_SELECTED = "No property selected!";
    
    //Error message Constants
    public static final String ERROR = "ERROR: ";
    public static final String ERROR_FIELD_EMPTY = " cannot be blank!";
    public static final String ERROR_TOO_LONG = " too long!";
    public static final String ERROR_TOO_LARGE = " too large!";
    public static final String ERROR_FILE_INVALID = " contains the character: ";   
    public static final String ERROR_FILE_MISMATCH_1 = "The data in ";
    public static final String ERROR_FILE_MISMATCH_2 = " does not match ";
    public static final String ERROR_ILLEGAL_DATA = "Disallowed ";
    public static final String ERROR_BOTCHED_FILE = "There is something wrong with the data in ";
    public static final String ERROR_ERRONEOUS_DATA = "Erroneous data has been entered!";
    public static final String ERROR_REPEAT = "A chemical with that information already exists!";
    public static final String ERROR_SAVE_PROBLEM = "There was a problem in saving the file!";
    public static final String ERROR_REPEATED_REACTION = "Reaction already exists!";
    public static final String ERROR_IMPOSSIBLE_REACTION = "Reaction not possible!";
    
    //Other Prompts
    public static final String SAVE_PROMPT = "Do you want to save?";
    public static final String NEW_REACTION_PROMPT = "You did not submit your product name!\nIt will be deleted. Proceed?";
    public static final String SAVE_SUCCESS = "File Saved!";
    public static final String EDIT_SUCCESS = "Edit Successful!";
    public static final String REACTION_SUCCESS = "New reaction successful!";
    public static final String REACTION_PROPERTIES_SUCCESS = "Properties set succesfully!";
    public static final String CORRECT = "Correct!";
    public static final String WRONG = "Wrong!";
    
    //Misc.
    public static final String TEXT_FIELD_ENTER_NAME = "Enter Name Here";
    
    public static final boolean CLOSE_WINDOW_AFTER_SAVE = true;
    public static final boolean NEW_REACTION_EXISTS = true;
    
    public final WindowAdapter WINDOW_CLOSE = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            savePrompt(CLOSE_WINDOW_AFTER_SAVE);
        }};
    public final WindowAdapter WINDOW_CLOSE_NEW_REACTION = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            int reactionOption = newReactionPrompt();
            if (reactionOption == NEW_REACTION_PROMPT_OK) {
                removeReaction(simulateReaction.getReaction().getID());
                savePrompt(CLOSE_WINDOW_AFTER_SAVE);
            }
        }};
    
    //variables to keep track of if changes have been made
    private static boolean madeChanges;
    private static boolean periodicTrendsChanged;
    
    //Variables for init & reload
    private static String elementsFile;
    private static String binaryCompoundsFile;
    private static String reactionsFile;
    private static int firstValence;
    private static int increment;
    
    //The Database
    private ChemicalDatabase database;
    
    //GUI Pages
    private StartPage startPage;
    private HomePage homePage;
    private AddElement addElement;
    private SimulateReaction simulateReaction;
    private EditChemicals editChemicals;
    private SortChemicals sortChemicals;
    private ListBinaryCompounds listBinaryCompounds;
    private ListReactions listReactions;
    private FunButton funButton;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public static boolean getMadeChanges() {
        return madeChanges;
    }
    public static void setMadeChanges(boolean newMadeChanges) {
        madeChanges = newMadeChanges;
    }
    
    public static String getElementsFile() {
        return elementsFile;
    }
    public static void setElementsFile(String newElementsFile) {
        elementsFile = newElementsFile;
    }
    
    public static String getBinaryCompoundsFile() {
        return binaryCompoundsFile;
    }
    public static void setBinaryCompoundsFile(String newBinaryCompoundsFile) {
       binaryCompoundsFile = newBinaryCompoundsFile;
    }
    public static String getReactionsFile() {
        return reactionsFile;
    }
    public static void setReactionsFile(String newReactionsFile) {
        reactionsFile = newReactionsFile;
    }
    
    public ChemicalDatabase getDatabase(){
        return this.database;
    }
    public void setDatabase(ChemicalDatabase newDatabase){
        this.database = newDatabase;
    }
    
    public StartPage getStartPage() {
        return this.startPage;
    }
    public HomePage getHomePage() {
        return this.homePage;
    }
    public AddElement getAddElement() {
        return this.addElement;
    }
    public SimulateReaction getSimulateReaction() {
        return this.simulateReaction;
    }
    public EditChemicals getEditChemicals() {
        return this.editChemicals;
    }
    public SortChemicals getSortChemicals() {
        return this.sortChemicals;
    }
    public ListBinaryCompounds getListBinaryCompounds() {
        return this.listBinaryCompounds;
    }
    public ListReactions getListReactions() {
        return this.listReactions;
    }
    public FunButton getFunButton() {
        return this.funButton;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public DatabaseGUI(){
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
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>
        //</editor-fold>
        
        this.startPage = new StartPage(this); 
        this.homePage = new HomePage(this);
        this.addElement = new AddElement(this);
        this.simulateReaction = new SimulateReaction(this);
        this.editChemicals = new EditChemicals(this);
        this.sortChemicals = new SortChemicals(this);
        this.listBinaryCompounds = new ListBinaryCompounds(this);
        this.listReactions = new ListReactions(this);
        this.funButton = new FunButton(this);
        this.startPage.start(this.startPage);
    }
    
    ///
    //METHODS
    ///
    
    //Start/Submit functionality
    public boolean constructDatabase(String newElementsFile, String newBinaryCompoundsFile, String newReactionsFile, int firstValenceInput, int incrementInput){
        if (elementsFile == null) {
            firstValence = firstValenceInput;
            increment = incrementInput;
            periodicTrendsChanged = false;
            madeChanges = false;
        } else if (firstValence != firstValenceInput || increment != incrementInput) {
            firstValence = firstValenceInput;
            increment = incrementInput;
            periodicTrendsChanged = true;
            madeChanges = true;
        }

        elementsFile = newElementsFile;
        binaryCompoundsFile = newBinaryCompoundsFile;
        reactionsFile = newReactionsFile;

        this.database = new ChemicalDatabase();
        return this.database.load(elementsFile, binaryCompoundsFile, reactionsFile, firstValence, increment, periodicTrendsChanged);
    }
    
    public char validateFile(String fileName) {
        if(fileName.isEmpty())
            return EMPTY_FILE;
        if(fileName.length() > MAXIMUM_STRING_LENGTH)
            return FILE_NAME_TOO_LONG;

        for (int i = 0 ; i < ILLEGAL_CHARS.length ; i++) {
            if (fileName.contains(ILLEGAL_CHARS[i] + DatabaseGUI.EMPTY_STRING))
                return ILLEGAL_CHARS[i];
        }
        return VALID_FILE;    
    }
    
    public void restart() {
        this.startPage.start(this.startPage);
    }
    
    //JOptionPane to prompt saving a new reaction
    public int newReactionPrompt() {
        int optionNum = JOptionPane.showOptionDialog(null, DatabaseGUI.NEW_REACTION_PROMPT, DatabaseGUI.EMPTY_STRING, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DatabaseGUI.NEW_REACTION_PROMPT_OPTIONS, null);
        return optionNum;
    }
    
    //JOptionPane to prompt save
    public int savePrompt(boolean close) {
        if (madeChanges) {
            int saveOption = JOptionPane.showOptionDialog(null, DatabaseGUI.SAVE_PROMPT, DatabaseGUI.EMPTY_STRING, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DatabaseGUI.SAVE_PROMPT_OPTIONS, null);
            
            if(saveOption == SAVE_PROMPT_YES) 
                saveDialog();
            if(close && saveOption != SAVE_PROMPT_CANCEL)
                System.exit(0);

            return saveOption;
        }
        return SAVE_PROMPT_YES;
    }
    //Display save status to user
    public void saveDialog() {
        if(this.save())
            JOptionPane.showMessageDialog(null, DatabaseGUI.SAVE_SUCCESS);
        else
            JOptionPane.showMessageDialog(null, DatabaseGUI.ERROR_SAVE_PROBLEM); 
    }
    private boolean save() {
        madeChanges = false;
        return this.database.save(this.elementsFile, this.binaryCompoundsFile, this.reactionsFile);
    }
    
    public void startHomePage() {
        this.homePage.start(this.homePage);
    }
    
    //Add Element functionality
    public void startAddElement(){
        this.addElement.start(this.addElement);
    }
    public boolean addElement(Element newElement){
        boolean successful = this.database.addElement(newElement);
        if (successful)
            madeChanges = true;
        return successful;
    }
    
    //Remove Chemical functionality
    public boolean removeChemical(String name){
        boolean successful = this.database.removeChemical(this.searchChemicalsByName(name));
        if (successful)
            madeChanges = true;
        return successful;
    }
    public boolean removeReaction(int index){
        boolean successful = this.database.removeReaction(this.searchReactionsByID(index));
        if (successful)
            madeChanges = true;
        return successful;  
    }
    
    //Search Chemicals functionality
    public Reaction searchReactionsByID(int id) {
        return this.database.searchReactionsByID(id);
    }
    public Chemical searchChemicalsByName(String name) {
        return this.database.searchChemicalsByName(name);
    }
    public int searchChemicalIndicesByName(String name) {
        return this.database.searchChemicalIndicesByName(name);
    }
    public Element searchElementByAtomicSymbol(String symbol){
        return this.database.searchElementByAtomicSymbol(symbol);
    }
    public Element searchElementByAtomicNum(int num) {
        return this.database.searchElementByAtomicNum(num);
    }
    public int searchElementIndicesByAtomicNum(int num) {  
        return this.database.searchElementIndicesByAtomicNum(num);
    }
    
    //Sort Chemicals functionality
    public void startSortChemicals(){
        this.sortChemicals.start(this.sortChemicals);
    }
    public List<Chemical> sortChemicalsByName(){
        return this.database.sortChemicalsByName();
    }
    public List<Chemical> sortChemicalsByMolarMass(){
        return this.database.sortChemicalsByMolarMass();
    }
    public List<Chemical> sortChemicalsByMeltingPoint(){
        return this.database.sortChemicalsByMeltingPoint();
    }
    public List<Chemical> sortChemicalsByBoilingPoint(){
        return this.database.sortChemicalsByBoilingPoint();
    }
    public List<Chemical> sortChemicalsByStpDensity(){
        return this.database.sortChemicalsByStpDensity();
    }
    public List<Chemical> sortChemicalsByStpState(char property){
        return this.database.sortChemicalsByStpState(property);
    }
    
    //List Compounds functionality
    public void startListBinaryCompounds(){
        this.listBinaryCompounds.start(this.listBinaryCompounds);
    }
    public List<BinaryCompound> listBinaryCompounds(){
        return this.database.listBinaryCompounds();
    }
    
    //List Reactions functionality
    public void startListReactions(){
        this.listReactions.start(this.listReactions);
    }
    public List<Reaction> listReactions(){
        return this.database.listReactions();
    }
    
    //Simulate Reaction functionality
    public void startSimulateReaction(){
        this.simulateReaction.start(this.simulateReaction);
    }
    public Reaction simulateReaction(Element reactant1, Element reactant2){
        Reaction newReaction = this.database.simulateReaction(reactant1, reactant2);
        if (newReaction.getProduct() != null)
            this.madeChanges = true;
        return newReaction;
    }
    
    //Edit Chemical functionality
    public void startEditChemicals(){
        this.editChemicals.start(this.editChemicals);
    }
    public boolean editElements(Element elementToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour, String molecularFormula, int numProton, double electronegativity, int numNeutron, double molarMass, double ionizationEnergy){
        boolean successful = this.database.editElements(elementToBeEdited, commonName, stpDensity, bp, mp, colour, molecularFormula, numProton, electronegativity, numNeutron, molarMass, ionizationEnergy);
        if (successful)
            madeChanges = true;
        return successful;
    }
    public boolean editBinaryCompounds(BinaryCompound binaryCompoundToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour){
        boolean successful = this.database.editBinaryCompounds(binaryCompoundToBeEdited, commonName, stpDensity, bp, mp, colour);
        if (successful)
            madeChanges = true;
        return successful;
    }
    
    public void updateTable() {
        this.database.updateTable();
    }
    
    //Fun Button functionality
    public void startFunButton(){
        this.funButton.start(this.funButton);
    }
    public String[] chemicalNamePermutation(){
        return this.database.chemicalNamePermutation();
    }
}