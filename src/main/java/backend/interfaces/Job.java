package backend.interfaces;

public class Job {
	//fields required by FE
	double lsrcLat;
	double lsrcLong;
	double ldstLat;
	double ldstLong;
	String ldescription;
	int ltokenCount;
	String lproducerID;
	String lConsumerID;
	String lchannelID;
	boolean lisActive;
	boolean lisAssigned;
	String jobID;
	String ltitle;
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
			String channelID, long id){
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

