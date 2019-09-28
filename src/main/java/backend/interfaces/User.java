package backend.interfaces;

public class User 
{
	String ID;
	String Name;
	double currLong;
	double currLat;
	boolean current_status;
	Job curr_job;
	long phoneNumber = Integer.MAX_VALUE;
	
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
//ClassConstructor
public User( String name, long phone)
	{
		this.Name=name;
		this.ID= name + Integer.toString((int) (Math.random()%1000));
		this.phoneNumber = phone;
	}
public User() {
	this.currLat = 0;
	this.currLong = 0;
	this.curr_job = new Job();
	this.Name = new String ();
	//this.ID =0;
	current_status = false;
}



public String getID() {
	return ID;
}


public void setID(String iD) {
	ID = iD;
}


public String getName() {
	return Name;
}


public void setName(String name) {
	Name = name;
}


public double getUserlong() {
	return currLong;
}


public void setUserlong(double userlong) {
	this.currLong = userlong;
}


public double getUserlat() {
	return currLat;
}


public void setUserlat(double userlat) {
	this.currLat = userlat;
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
}
