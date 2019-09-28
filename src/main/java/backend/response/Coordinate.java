package backend.response;

public class Coordinate {
	public double lat;
	public double lon;
	public Coordinate(double glat, double glong) {
		this.lat = glat;
		this.lon = glong;
	}
	public Coordinate() {
		this.lat = 0;
		this.lon = 0;
	}
}
