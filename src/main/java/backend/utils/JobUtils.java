package backend.utils;

import backend.interfaces.Vehicle;

public class JobUtils {
	public static double getDist(double lat1,double long1,double lat2, double long2) {
		double retval;
		//calculate the distance diff in x direction 
		double xDist = Math.abs(lat1 - lat2);
		double yDist = Math.abs(long1 - long2);
		retval = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		return retval;
	}
	
	public static Vehicle find_nearest(double cLat, double cLong) {
		//TODO use rest API for this 
		double vehicleLat = 0;
		double vehicleLong = 0;
		boolean stat = true;
		Vehicle retval = new Vehicle(vehicleLat, vehicleLong, stat);
		return retval;
	}
	
	public static int calculateTokenAmount(double lat1,double long1,double lat2, double long2) {
		int retval;
		retval = (int) (getDist(lat1, long1, lat2, long2) * 1);
		return retval;
	}

}
