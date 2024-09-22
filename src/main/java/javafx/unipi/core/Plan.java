package javafx.unipi.core;

public class Plan {                 // iperklasi
    private int uniCode ;                                               // monadikos kodikos ths etairias  
    private String company ;                                           // i etairia pou parexei to programma 
    private int callMinutes;                                          // plithos lepton dorean kliseon se stathera kai kinita 
    private double programCost ;                                     //kostos tou programmatos 
    
    Plan(int uniCode , String company , int callMinutes , double programCost) {
        this.uniCode = uniCode ; //arxikopoihsh tou pediou uniCode
        this.company = company ; //arxikopoihsh tou pediou company
        this.callMinutes = callMinutes ; //arxikopoihsh tou pediou callMinutes
        this.programCost = programCost ; //arxikopoihsh tou pediou programCost
    } //constructor gia arxikopoihsh twn pediwn ths klashs Plan
    
    public int getUniCode() {
        return uniCode;
    } //epistrofh timhs tou pediou uniCode
    
    public void setUniCode(int uniCode) {
        this.uniCode = uniCode;
    } //eisagwgh h ananewsh timhs tou pediou uniCode
    
    public String getCompany() {
        return company;
    } //epistrofh timhs tou pediou company
    
    public void setCompany(String company) {
        this.company = company;
    } //eisagwgh h ananewsh timhs tou pediou company
    
    public int getCallMinutes() {
        return callMinutes;
    } //epistrofh timhs tou pediou callMinutes
    
    public void setCallMinutes(int callMinutes) {
        this.callMinutes = callMinutes;
    } //eisagwgh h ananewsh timhs tou pediou callMinutes
    
    public double getProgramCost() {
        return programCost;
    } //epistrofh timhs tou pediou programCost
    
    public void setProgramCost(double programCost) {
        this.programCost = programCost;
    } //eisagwgh h ananewsh tou pediou programCost
    
}