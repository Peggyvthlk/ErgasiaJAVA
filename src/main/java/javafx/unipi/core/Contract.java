package javafx.unipi.core;

public class Contract {
	
	private String code; //monadikos kwdikos
	private long phoneNumber; //arithmos thlefwnou pou antistoixei to symbolaio
	private long afm; //afm pelath 
	private String programType; //programma pou afora to symbolaio
	private long startDate; //hmeromhnia epithymhths enarkshs symbolaiou
	private int contractDuration; //diarkeia symbolaiou
	private float discount; //ekptwsh
	private float finalCost; //kostos symbolaiou meta thn ekptwsh
	private String accountType; //typos logariasmou
	private String paymentMethod; //typos plhrwmhs
	private float cancellationCost; //kostos akyrwshs symbolaiou
	private boolean activeContract; //an to symbolaio einai energo h oxi
	
	public Contract(String code, long phoneNumber, long afm, String programType, long startDate, int contractDuration,
			float discount, float finalCost, String accountType, String paymentMethod, float cancellationCost,
			boolean activeContract) {
		this.code = code; //arxikopoihsh tou pediou code
		this.phoneNumber = phoneNumber; //arxikopoihsh tou pediou phoneNumber
		this.afm = afm; //arxikopoihsh tou pediou afm
		this.programType = programType; //arxikopoihsh tou pediou programType
		this.startDate = startDate; //arxikopoihsh tou pediou startDate
		this.contractDuration = contractDuration; //arxikopoihsh tou pediou contractDuration
		this.discount = discount; //arxikopoihsh tou pediou discount
		this.finalCost = finalCost; //arxikopoihsh tou pediou finalCost
		this.accountType = accountType; //arxikopoihsh tou pediou accountType
		this.paymentMethod = paymentMethod; //arxikopoihsh tou pediou paymentMethod
		this.cancellationCost = cancellationCost; //arxikopoihsh tou pediou cancellationCost
		this.activeContract = activeContract; //arxikopoihsh tou pediou activeContract
	} //constructor gia arxikopoihsh twn pediwn ths klashs Contract

	public String getCode() {
		return code;
	} //epistrofh timhs tou pediou code

	public void setCode(String code) {
		this.code = code;
	} //eisagwgh h ananewsh timhs tou pediou code

	public long getPhoneNumber() {
		return phoneNumber;
	} //epistrofh timhs tou pediou phoneNumber

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	} //eisagwgh h ananewsh timhs tou pediou phoneNumber

	public long getAfm() {
		return afm;
	} //epistrofh timhs tou pediou afm

	public void setAfm(long afm) {
		this.afm = afm;
	} //eisagwgh h ananewsh timhs tou pediou afm

	public String getProgramType() {
		return programType;
	} //epistrofh timhs tou pediou programType

	public void setProgramType(String programType) {
		this.programType = programType;
	} //eisagwgh h ananewsh timhs tou pediou programType

	public long getStartDate() {
		return startDate;
	} //epistrofh timhs tou pediou startDate

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	} //eisagwgh h ananewsh tou pediou startDate

	public int getContractDuration() {
		return contractDuration;
	} //epistrofh timhs tou pediou contractDuration

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	} //eisagwgh h ananewsh timhs tou pediou contractDuration

	public float getDiscount() {
		return discount;
	} //epistrofh timhs tou pediou discount

	public void setDiscount(float discount) {
		this.discount = discount;
	} //eisagwgh h ananewsh timhs tou pediou discount

	public float getFinalCost() {
		return finalCost;
	} //epistrofh timhs tou pediou finalCost

	public void setFinalCost(float finalCost) {
		this.finalCost = finalCost;
	} //eisagwgh h ananewsh timhs tou pediou finalCost

	public String getAccountType() {
		return accountType;
	} //epistrofh timhs tou pediou accountType

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	} //eisagwgh h ananewsh timhs tou pediou accountType

	public String getPaymentMethod() {
		return paymentMethod;
	} //epistrofh timhs tou pediou paymentMethod

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	} //eisagwgh h ananewsh timhs tou pediou paymentMethod

	public float getCancellationCost() {
		return cancellationCost;
	} //epistrofh timhs tou pediou cancellationCost

	public void setCancellationCost(float cancellationCost) {
		this.cancellationCost = cancellationCost;
	} //eisagwgh h ananewsh timhs tou pediou cancellationCost

	public boolean isActiveContract() {
		return activeContract;
	} //epistrofh timhs tou pediou activeContract

	public void setActiveContract(boolean activeContract) {
		this.activeContract = activeContract;
	} //eisagwh h ananewsh timhs tou pediou activeContract
	
	
	
	

}