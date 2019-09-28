package backend.response;

public class CombinedResponse {
	String title;
	String job_type;
	public CombinedResponse(String title_req,String job_type_req) {
		this.title = new String(title_req);
		this.job_type = new String(job_type_req);
	}
	public CombinedResponse() {
		this.title = new String();
		this.job_type = new String();
	}
	
}
