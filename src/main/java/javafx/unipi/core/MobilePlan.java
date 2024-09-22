package javafx.unipi.core;

public class MobilePlan extends Plan { //klhronomei apo thn yperklash Plan
	
    private int SMS ;                           // plithos dorean sms ana mina 
    private int GB ;                            // plithos dorean dedomenon ana mina
    
    public MobilePlan (int uniCode , String company , int callMinutes , double programCost , int SMS ,int GB ) {
        super(uniCode , company , callMinutes , programCost); //arxikopoihsh twn pediwn pou klhronomei apo thn yperklash Plan
        this.SMS = SMS ; //arxikopoihsh tou pediou SMS
        this.GB = GB ; //arxikopoihsh tou pediou GB
    } //constructor gia arxikopoihsh twn pediwn ths klashs MobilePlan kai oswn klhronomei apo thn yperklash Plan
    
    public int getSMS() {
        return SMS;
    } //epistrofh timhs tou pediou SMS
    
    public void setSMS(int sMS) {
        SMS = sMS;
    } //eisagwgh h ananewsh timhs tou pediou SMS
    
    public int getGB() {
        return GB;
    } //epistrofh timhs tou pediou GB
    
    public void setGB(int gB) {
        GB = gB;
    } //eisagwgh h ananewsh timhs tou pediou GB
    
    //toString
	@Override
	public String toString() {
		return "MobilePlan [SMS=" + SMS + ", GB=" + GB + ", toString()=" + super.toString() + "]";
	}
    
    
    
}