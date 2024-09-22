package javafx.unipi.core;

public class LandlinePlan extends Plan { //klhronomei apo thn yperklash Plan
	
    private int lineSpeed ; //taxythta grammhs
    private String lineType ; //typos taxythtas
    
    public LandlinePlan(int uniCode , String company , int callMinutes , double programCost , int lineSpeed , String lineType) {
        super(uniCode , company , callMinutes , programCost ) ; //arxikopoihsh twn pediwn pou klhronomei apo thn yperklash Plan
        this.lineSpeed = lineSpeed ; //arxikopoihsh tou pediou lineSpeed
        this.lineType = lineType ;  //arxikopoihsh tou pediou lineType
    } //constructor gia arxikopoihsh twn pediwn ths klashs landlidePlan kai oswn klhronomei apo thn yperklash Plan
    
    public int getLineSpeed() {
        return lineSpeed;
    } //epistrofh timhs tou pediou lineSpeed
    
    public void setLineSpeed(int lineSpeed) {
        this.lineSpeed = lineSpeed;
    } //eisagwgh h ananewsh timhs tou pediou lineSpeed
    
    public String getLineType() {
        return lineType;
    } //epistrofh timhs tou pediou lineType
    
    public void setLineType(String lineType) {
        this.lineType = lineType;
    } //eisagwgh h ananewsh timhs tou pediou lineType
    
}  