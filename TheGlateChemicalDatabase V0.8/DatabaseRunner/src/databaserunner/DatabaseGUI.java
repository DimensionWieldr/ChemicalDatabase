package databaserunner;

import gui.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class DatabaseGUI {
    
    ///
    //FIELDS
    ///
    
    public static final String DEFAULT_STRING = "unknown";
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final int DEFAULT_ARRAY_SIZE = 0;
    
    public static final char VALID_FILE = 'V';
    public static final char EMPTY_FILE = 'E';
    public static final char NAME_LENGTH_EXCEEDED = 'L';
    public static final String FILE_EXTENSION = ".txt";
    
    public static final int MAXIMUM_FILE_LENGTH = 256;
    
    public static final String[] ON_CLOSE_OPTIONS = {"Yes", "No"};
    
    private static boolean madeChanges;
    
    private static String elementsFile;
    private static String binaryCompoundsFile;
    private static String reactionsFile;
    private static int firstValence;
    private static int increment;
    private static boolean periodicTrendsChanged;
    
    private ChemicalDatabase database;
    
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
        this.startPage = new StartPage(this); 
        this.homePage = new HomePage(this);
        this.addElement = new AddElement(this);
        this.simulateReaction = new SimulateReaction(this);
        this.editChemicals = new EditChemicals(this);
        this.sortChemicals = new SortChemicals(this);
        this.listBinaryCompounds = new ListBinaryCompounds(this);
        this.listReactions = new ListReactions(this);
        this.funButton = new FunButton(this);
        this.startPage.start();
    }
    
    ///
    //METHODS
    ///
    
    //Start/Submit functionality
    public boolean constructDatabase(String newElementsFile, String newBinaryCompoundsFile, String newReactionsFile, int firstValenceInput, int incrementInput){
        madeChanges = false;
        
        if (elementsFile == null) {
            firstValence = firstValenceInput;
            increment = incrementInput;
            periodicTrendsChanged = false;
        } else if (firstValence != firstValenceInput || increment != incrementInput) {
            firstValence = firstValenceInput;
            increment = incrementInput;
            periodicTrendsChanged = true;
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
        if(fileName.length() > MAXIMUM_FILE_LENGTH)
            return NAME_LENGTH_EXCEEDED;

        char[] tempFileName = fileName.toCharArray();
        
        for(int i = 0; i < tempFileName.length; i++) {
            if(tempFileName[i] == '/'
                || tempFileName[i] == '\\'
                || tempFileName[i] == '?'
                || tempFileName[i] == '%'
                || tempFileName[i] == '*'
                || tempFileName[i] == ':'
                || tempFileName[i] == '|'
                || tempFileName[i] == '\"'
                || tempFileName[i] == '<'
                || tempFileName[i] == '>' 
                || tempFileName[i] == '.') {
                System.out.println(tempFileName[i]);
                return tempFileName[i];
            }
        }
            return VALID_FILE;    
    }
    
    //JOptionPane to prompt save
    public void savePrompt(boolean close) {
        if (madeChanges) {
            int optionNum = JOptionPane.showOptionDialog(null, "Do you want to save?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DatabaseGUI.ON_CLOSE_OPTIONS, DatabaseGUI.ON_CLOSE_OPTIONS[0]);

            if(optionNum == 0) saveFile();
            if(close) System.exit(0);
        }
    }

    // Save current file
    private void saveFile() {
        if(this.save())
            JOptionPane.showMessageDialog(null, "File saved!");
        else
            JOptionPane.showMessageDialog(null, "There was an error saving the file!"); 
    }
    
    public boolean save() {
        madeChanges = false;
        return this.database.save(this.elementsFile, this.binaryCompoundsFile, this.reactionsFile);
    }
    
    public void startHomePage() {
        this.homePage.start();
    }
    
    //Add Element functionality
    public void startAddElement(){
        this.addElement.start();
    }
    public boolean addElement(Element newElement){
        madeChanges = true;
        return this.database.addElement(newElement);
    }
    
    //Remove Chemical functionality
    public boolean removeChemical(String name){
        madeChanges = true;
        return this.database.removeChemical(name);
    }
    public void removeReaction(int index){
        madeChanges = true;
        this.database.removeReaction(index);
        this.listReactions.start();
    }
    
    //Search Chemicals functionality
    public Reaction searchReactionsByID(int id) {
        return this.database.searchReactionsByID(id);
    }
    public int searchReactionIndicesByID(int id) {
        return this.database.searchReactionIndicesByID(id);
    }
    public Chemical searchChemicalsByName(String name) {
        return this.database.searchChemicalsByName(name);
    }
    public int searchChemicalIndicesByName(String name) {
        return this.database.searchChemicalIndicesByName(name);
    }
    public Element searchElementByMolecularFormula(String formula){
        return this.database.searchElementByMolecularFormula(formula);
    }
    public Element searchElementByAtomicNum(int num) {
        return this.database.searchElementByAtomicNum(num);
    }
    public int searchElementIndicesByAtomicNum(int num) {  
        return this.database.searchElementIndicesByAtomicNum(num);
    }
    
    //Sort Chemicals functionality
    public void startSortChemicals(){
        this.sortChemicals.start();
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
        this.listBinaryCompounds.start();
    }
    public List<BinaryCompound> listBinaryCompounds(){
        return this.database.listBinaryCompounds();
    }
    
    //List Reactions functionality
    public void startListReactions(){
        this.listReactions.start();
    }
    public List<Reaction> listReactions(){
        return this.database.listReactions();
    }
    
    //Simulate Reaction functionality
    public void startSimulateReaction(){
        this.simulateReaction.start();
    }
    public Reaction simulateReaction(Element reactant1, Element reactant2){
        madeChanges = true;
        return this.database.simulateReaction(reactant1, reactant2);
    }
    
    //Edit Chemical functionality
    public void startEditChemicals(){
        this.editChemicals.start();
    }
    public boolean editElements(Element elementToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour, String molecularFormula, int numProton, double electronegativity, int numNeutron, double molarMass, double ionizationEnergy){
        madeChanges = true;
        return this.database.editElements(elementToBeEdited, commonName, stpDensity, bp, mp, colour, molecularFormula, numProton, electronegativity, numNeutron, molarMass, ionizationEnergy);
    }
    public boolean editBinaryCompounds(BinaryCompound binaryCompoundToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour){
        madeChanges = true;
        return this.database.editBinaryCompounds(binaryCompoundToBeEdited, commonName, stpDensity, bp, mp, colour);
    }
    
    public void updateTable() {
        madeChanges = true;
        this.database.updateTable();
    }
    
    //Fun Button functionality
    public void startFunButton(){
        this.funButton.start();
    }
    public String[] chemicalNamePermutation(){
        return this.database.chemicalNamePermutation();
    }
}
