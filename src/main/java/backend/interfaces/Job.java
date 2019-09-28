package backend.interfaces;

import org.springframework.web.bind.annotation.RequestParam;

public class Job {
	//fields required by FE
	double lsrcLat;
	double lsrcLong;
	double ldstLat;
	double ldstLong;
	String ltitle;
	String ldescription;
	int ltokenCount;
	String lproducerID;
	String lConsumerID;
	String lchannelID;
	boolean lisActive;
	boolean lisAssigned;
	String jobID;
	String srcStreet;
	int srcStreetNo; 
	int srcZIP;
	String srcAddressLine;
	String srcCity;
	String dstStreet; 
	int dstStreetNo;
	int dstZIP;
	String dstAddressLine;
	String dstCity; 
	
	
	
	
	
	
	
	
	
	//constructor with defaults 
	public Job(){
		this.lsrcLat = 0;
		this.lsrcLong = 0;
		this.ldstLat = 0;
		this.ldstLong = 0;
		this.ldescription = new String ("");
		this.ltokenCount = 0;
		this.lproducerID = new String ("");
		this.lConsumerID = new String ("");
		this.lchannelID = new String ("");
	}
	//constructor from FE
	public Job(double srcLat,
			double srcLong,
			double dstLat,
			double dstLong,
			String title,
			String description,
			boolean isTokenCalculated,
			int tokenCount,
			String producerID,
			String ConsumerID,
			String channelID, long id,
			String srcStreet,
			int srcStreetNo, 
			int srcZIP,
			String srcAddressLine,
			String srcCity,
			String dstStreet, 
			int dstStreetNo,
			int dstZIP,
			String dstAddressLine,
			String dstCity){
		this.lsrcLat = srcLat;
		this.lsrcLong = srcLong;
		this.ldstLat = dstLat;
		this.ldstLong = dstLong;
		this.ltitle = new String(title);
		this.ldescription = new String ("").concat(description);
		if (isTokenCalculated == true) {
			this.ltokenCount = tokenCount;
		}else {
			//TODO calculate token count automatically
		}
		this.lproducerID = new String ("").concat(producerID);
		this.lConsumerID = new String ("").concat(ConsumerID);
		this.lchannelID = new String ("").concat(channelID);
		this.jobID = new String(Long.toString(id));
		this.lisActive = true;
		this.srcStreet = srcStreet;
		this.srcStreetNo = srcStreetNo; 
		this.srcZIP = srcZIP;
		this.srcAddressLine = srcAddressLine;
		this.srcCity = srcCity;
		this.dstStreet = dstStreet; 
		this.dstStreetNo =  dstStreetNo;
		this.dstZIP = dstZIP;
		this.dstAddressLine =  dstAddressLine;
		this.dstCity = dstCity;
	}

	public String getLtitle() {
		return ltitle;
	}
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
	public String getSrcStreet() {
		return srcStreet;
	}
	public void setSrcStreet(String srcStreet) {
		this.srcStreet = srcStreet;
	}
	public int getSrcStreetNo() {
		return srcStreetNo;
	}
	public void setSrcStreetNo(int srcStreetNo) {
		this.srcStreetNo = srcStreetNo;
	}
	public int getSrcZIP() {
		return srcZIP;
	}
	public void setSrcZIP(int srcZIP) {
		this.srcZIP = srcZIP;
	}
	public String getSrcAddressLine() {
		return srcAddressLine;
	}
	public void setSrcAddressLine(String srcAddressLine) {
		this.srcAddressLine = srcAddressLine;
	}
	public String getSrcCity() {
		return srcCity;
	}
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}
	public String getDstStreet() {
		return dstStreet;
	}
	public void setDstStreet(String dstStreet) {
		this.dstStreet = dstStreet;
	}
	public int getDstStreetNo() {
		return dstStreetNo;
	}
	public void setDstStreetNo(int dstStreetNo) {
		this.dstStreetNo = dstStreetNo;
	}
	public int getDstZIP() {
		return dstZIP;
	}
	public void setDstZIP(int dstZIP) {
		this.dstZIP = dstZIP;
	}
	public String getDstAddressLine() {
		return dstAddressLine;
	}
	public void setDstAddressLine(String dstAddressLine) {
		this.dstAddressLine = dstAddressLine;
	}
	public String getDstCity() {
		return dstCity;
	}
	public void setDstCity(String dstCity) {
		this.dstCity = dstCity;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public double getLsrcLat() {
		return lsrcLat;
	}

	public void setLsrcLat(double lsrcLat) {
		this.lsrcLat = lsrcLat;
	}

	public double getLsrcLong() {
		return lsrcLong;
	}

	public void setLsrcLong(double lsrcLong) {
		this.lsrcLong = lsrcLong;
	}

	public double getLdstLat() {
		return ldstLat;
	}

	public void setLdstLat(double ldstLat) {
		this.ldstLat = ldstLat;
	}

	public double getLdstLong() {
		return ldstLong;
	}

	public void setLdstLong(double ldstLong) {
		this.ldstLong = ldstLong;
	}

	public String getLdescription() {
		return ldescription;
	}

	public void setLdescription(String ldescription) {
		this.ldescription = ldescription;
	}

	public int getLtokenCount() {
		return ltokenCount;
	}

	public void setLtokenCount(int ltokenCount) {
		this.ltokenCount = ltokenCount;
	}

	public String getLproducerID() {
		return lproducerID;
	}

	public void setLproducerID(String lproducerID) {
		this.lproducerID = lproducerID;
	}

	public String getlConsumerID() {
		return lConsumerID;
	}

	public void setlConsumerID(String lConsumerID) {
		this.lConsumerID = lConsumerID;
	}

	public String getLchannelID() {
		return lchannelID;
	}

	public void setLchannelID(String lchannelID) {
		this.lchannelID = lchannelID;
	}

	public boolean isLisActive() {
		return lisActive;
	}

	public void setLisActive(boolean lisActive) {
		this.lisActive = lisActive;
	}

	public boolean isLisAssigned() {
		return lisAssigned;
	}

	public void setLisAssigned(boolean lisAssigned) {
		this.lisAssigned = lisAssigned;
	}
	
	


}

