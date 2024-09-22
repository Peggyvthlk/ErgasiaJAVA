package javafx.unipi.core;

public class TelecommunicationCompany {

	private int companycode; //monadikos kwdikos etaireias
	private int companyphone;	//thlefwno etaireias
	private String email;	//e-mail
	private String companyname;	//epwnymia etaireias
	
	//Constructor gia arxikopoihsh twn pediwn ths klashs TelecommunicationCompany
	public TelecommunicationCompany(int companycode, int companyphone, String email, String companyname) {
		this.companycode = companycode; //arxikopoihsh tou pediou companycode
		this.companyphone = companyphone; //arxikopoihsh tou pediou companyphone
		this.email = email; //arxikopoihsh tou pediou email
		this.companyname = companyname; //arxikopoihsh tou pediou companyname
	}
	
	//Getters setters
	public int getCompanycode() {
		return companycode;
	} //epistrofh timhs tou pediou companycode

	public void setCompanycode(int companycode) {  				
		this.companycode = companycode;
	} //eisagwgh h ananewsh timhs tou pediou companycode

	public int getPhone() {
		return companyphone;
	} //epistrofh timhs tou pediou companyphone

	public void setPhone(int phone) {
		this.companyphone = phone;
	} //eisagwgh h ananewsh timhs tou pediou companyphone

	public String getEmail() {
		return email;
	} //epistrofh timhs tou pediou email

	public void setEmail(String email) {
		this.email = email;
	} //eisagwgh h ananewsh timhs tou pediou email

	public String getCompanyname() {
		return companyname;
	} //epistrofh timhs tou pediou companyname

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	} //eisagwgh h ananewsh timhs tou pediou companyname

	//toString
	@Override
	public String toString() {
		return "Telecommunication Company [Company code=" + companycode + ", Company phone=" + companyphone + ", email=" + email
				+ ", Company name=" + companyname + "]";
	}
	
	

}