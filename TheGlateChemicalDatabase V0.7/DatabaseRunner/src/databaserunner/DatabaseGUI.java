package databaserunner;

import gui.*;
import java.io.*;
import java.util.*;

public class DatabaseGUI {
    
    ///
    //FIELDS
    ///
    
    public static final String DEFAULT_STRING = "unknown";
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final int DEFAULT_ARRAY_SIZE = 0;
    
    private ChemicalDatabase database;
    private String elementsFile;
    private String binaryCompoundsFile;
    private String reactionsFile;
    
    private StartPage startPage;
    private HomePage homePage;
    private AddElement addElement;
    private SimulateReaction simulateReaction;
    private EditChemicals editChemicals;
    private SortChemicals sortChemicals;
    private ListBinaryCompounds listBinaryCompounds;
    private ListReactions listReactions;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public ChemicalDatabase getDatabase(){
        return this.database;
    }
    public void setDatabase(ChemicalDatabase newDatabase){
        this.database = newDatabase;
    }
    
    public String getElementsFile() {
        return this.elementsFile;
    }
    public void setElementsFile(String elementsFile) {
        this.elementsFile = elementsFile;
    }
    
    public String getBinaryCompoundsFile() {
        return this.binaryCompoundsFile;
    }
    public void setBinaryCompoundsFile(String binaryCompoundsFile) {
        this.binaryCompoundsFile = binaryCompoundsFile;
    }
    
    public String getReactionsFile() {
        return this.reactionsFile;
    }
    public void setReactionsFile(String reactionsFile) {
        this.reactionsFile = reactionsFile;
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
        this.startPage.start();
    }
    
    ///
    //METHODS
    ///
    
    //Start/Submit functionality
    public boolean constructDatabase(String elementsFile, String binaryCompoundsFile, String reactionsFile, int firstValence, int increment){
        this.elementsFile = elementsFile;
        this.binaryCompoundsFile = binaryCompoundsFile;
        this.reactionsFile = reactionsFile;

        this.database = new ChemicalDatabase();

        return this.database.load(this.elementsFile, this.binaryCompoundsFile, this.reactionsFile, firstValence, increment);
    }
    
    public boolean save(String elementsFile, String binaryCompoundsFile, String reactionsFile) {
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
        return this.database.addElement(newElement);
    }
    
    //Remove Chemical functionality
    public boolean removeChemical(String name){
        return this.database.removeChemical(name);
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
    public void removeReaction(int index){
        this.database.removeReaction(index);
        this.listReactions.start();
    }
    
    //Simulate Reaction functionality
    public void startSimulateReaction(){
        this.simulateReaction.start();
    }
    public Reaction simulateReaction(Element reactant1, Element reactant2){
        return this.database.simulateReaction(reactant1, reactant2);
    }
    
    //Edit Chemical functionality
    public void startEditChemicals(){
        this.editChemicals.start();
    }
    public boolean editElements(Element elementToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour, String molecularFormula, int numProton, double electronegativity, int numNeutron, double molarMass, double ionizationEnergy){
        return this.database.editElements(elementToBeEdited, commonName, stpDensity, bp, mp, colour, molecularFormula, numProton, electronegativity, numNeutron, molarMass, ionizationEnergy);
    }
    public boolean editBinaryCompounds(BinaryCompound binaryCompoundToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour){
        return this.database.editBinaryCompounds(binaryCompoundToBeEdited, commonName, stpDensity, bp, mp, colour);
    }
    
    public void updateTable() {
        this.database.updateTable();
    }
    
}
