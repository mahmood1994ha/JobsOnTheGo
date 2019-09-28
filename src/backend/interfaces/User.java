package backend.interfaces;

public class User 
{
	long ID;
	String Name;
	double userlong;
	double userlat;
	boolean current_status;
	Job curr_job;
	long telefonnummer;
	String feedback;	
	//ClassConstructor
public User( String feedback, String name, long id, double Longitudinal, double Lateral, long telefonnummer, boolean status)
	{
		this.Name=name;
		this.ID=id;
		this.userlong= Longitudinal;
		this.userlat=Lateral;
		this.current_status=status;
		this.telefonnummer=telefonnummer;
		this.feedback = feedback;
	}
public User() {
	this.userlat = 0;
	this.userlong = 0;
	this.curr_job = new Job();
	this.Name = new String ();
	this.feedback= new String();
	this.ID =0;
	current_status = false;
}
public long getID() {
	return ID;
}
public void setID(long iD) {
	ID = iD;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public double getUserlong() {
	return userlong;
}
public void setUserlong(double userlong) {
	this.userlong = userlong;
}
public double getUserlat() {
	return userlat;
}
public void setUserlat(double userlat) {
	this.userlat = userlat;
}
public boolean isCurrent_status() {
	return current_status;
}
public void setCurrent_status(boolean current_status) {
	this.current_status = current_status;
}
public Job getCurr_job() {
	return curr_job;
}
public void setCurr_job(Job curr_job) {
	this.curr_job = curr_job;
}
public long getTelefonnummer() {
	return telefonnummer;
}
public void setTelefonnummer(long telefonnummer) {
	this.telefonnummer = telefonnummer;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}

}
