package backend.interfaces;

public class Vehicle {
	double currLat;
	double currLong;
	boolean isFree;
	
	public Vehicle(double lat, double lon, boolean status) {
		this.currLat = lat;
		this.currLong = lon;
		this.isFree = status;
	}

	public double getCurrLat() {
		return currLat;
	}

	public void setCurrLat(double currLat) {
		this.currLat = currLat;
	}

	public double getCurrLong() {
		return currLong;
	}

	public void setCurrLong(double currLong) {
		this.currLong = currLong;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
}
