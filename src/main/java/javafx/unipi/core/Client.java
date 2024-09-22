package javafx.unipi.core;

public class Client {
	
	private String licensenumber; //arithmos taytothtas pelath
	private long afm; //arithmos forologikou mhtrwou pelath
	private String name;	//onoma pelath
	private String surname;	//epitheto pelath
	private String job;	//epaggelma pelath 
	private String adress;	//dieythinsh pelath
	private String email;	//email pelath
	private long phone;	//thlefwno pelath
	
	//Constructor gia arxikopoihsh twn pediwn ths klashs Client
	public Client(String licensenumber, long afm, String name, String surname, String job, String adress, String email,
			long phone) {
		this.licensenumber = licensenumber; //arxikopoihsh tou pediou licensenumber
		this.afm = afm; //arxikopoihsh tou pediou afm
		this.name = name; //arxikopoihsh tou pediou name
		this.surname = surname; //arxikopoihsh tou pediou surname
		this.job = job; //arxikopoihsh tou pediou job
		this.adress = adress; //arxikopoihsh tou pediou adress
		this.email = email; //arxikopoihsh tou pediou email
		this.phone = phone; //arxikopoihsh tou pediou phone
	}
	
	//Getters setters
	public String getLicensenumber() {
		return licensenumber;
	} //epistrofh timhs tou pediou licensenumber

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	} //eisagwgh h ananewsh timhs tou pediou licensenumber

	public long getAfm() {
		return afm;
	} //epistrofh timhs tou pediou afm

	public void setAfm(long afm) {
		this.afm = afm;
	} //eisagwgh h ananewsh timhs tou pediou afm

	public String getName() {
		return name;
	} //epistrofh timhs tou pediou name

	public void setName(String name) {
		this.name = name;
	} //eisagwgh h ananewsh timhs tou pediou name

	public String getSurname() {
		return surname;
	} //epistrofh timhs tou pediou surname

	public void setSurname(String surname) {
		this.surname = surname;
	} //eisagwgh h ananewsh timhs tou pediou surname

	public String getJob() {
		return job;
	} //epistrofh timhs tou pediou job

	public void setJob(String job) {
		this.job = job;
	} //eisagwgh h ananewsh timhs tou pediou job

	public String getAdress() {
		return adress;
	} //epistrofh timhs tou pediou adress

	public void setAdress(String adress) {
		this.adress = adress;
	} //eisagwgh h ananewsh timhs tou pediou adress

	public String getEmail() {
		return email;
	} //epistrofh timhs tou pediou email

	public void setEmail(String email) {
		this.email = email;
	} //eisagwgh h ananewsh timhs tou pediou email

	public long getPhone() {
		return phone;
	} //epistrofh timhs tou pediou phone

	public void setPhone(long phone) {
		this.phone = phone;
	} //eisagwgh h ananewsh timhs tou pediou phone

	//toString
	@Override
	public String toString() {
		return "Client [License number=" + licensenumber + ", A.F.M =" + afm + ", Name=" + name + ", Surname=" + surname
				+ ", Job=" + job + ", Adress=" + adress + ",  e-mail=" + email + ", Phone=" + phone + "]";
	}
	
	

}
