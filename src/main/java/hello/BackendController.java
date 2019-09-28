package hello;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import backend.interfaces.*;
import backend.utils.*;
@RestController
public class BackendController {
	ArrayList<Job> jobList = new ArrayList<Job>();
	ArrayList<User> userList = new ArrayList<User>();
	private static final String template = "%s";
	
	@RequestMapping("/createjob")
	public String createJob(@RequestParam(value="src_lat") double src_lat, 
							@RequestParam(value="src_long")double src_long,
							@RequestParam(value="dst_lat")double dst_lat,
							@RequestParam(value="dst_long")double dst_long,
							@RequestParam(value="description")String desc,
							@RequestParam(value="tokenSet") boolean isTokenGiven,
							@RequestParam(value="tokencount", defaultValue = "0")int tokenCount,
							@RequestParam(value="prod_id")String prodID,
							@RequestParam(value="cons_id")String conID,
							@RequestParam(value="chan_id", defaultValue = "")String chanID){
		String retval = new String();
		
		//check IDS for a match
		boolean isProdRegistered = checkID(prodID);
		boolean isConsRegistered = checkID(conID);
		boolean isChanRegistered = checkID(chanID) || chanID.equals("");
		if (isProdRegistered && isConsRegistered && isChanRegistered) {
			Job x =  new Job(src_lat,src_long,dst_lat,dst_long,String.format(template, desc),isTokenGiven,tokenCount,
					String.format(template, prodID),String.format(template, conID),String.format(template, chanID));
			if (x!=null) {
				jobList.add(x);
				retval = x.getJobID();
			}
		}else {
			retval = new String("user(s) don't exist");
		}
		return retval;
	}
	
	private boolean checkID(String userID) {
		boolean retval = false;
		for (User u : userList) {
			if (u.getID().equalsIgnoreCase(userID)) {
				retval = true;
				break;
			}
		}
		return retval;
	}
	
	@RequestMapping("/getjoblist")
	public ArrayList<Job> getJobList(){
		ArrayList<Job> retval= new ArrayList<Job>();
		
		if (jobList!=null) {
			retval.addAll(jobList);
		}else {
			retval.add(new Job());
		}
		return retval;
	}
	
	@RequestMapping("/assignjob")
	public boolean assignJob(@RequestParam(value="job_id")String jobID,
			@RequestParam(value="chan_id")String chanID){
		boolean retval = false;
		//find the required job
		for (Job j: jobList) {
			if (j.getJobID().equals(jobID)) {
				j.setLchannelID(chanID);
				j.setLisAssigned(true);
				retval = true;
				break;
			}
		}		
		return retval;
	}
	@RequestMapping("/unassignjob")
	public boolean unassignJob(@RequestParam(value="job_id")String jobID){
		boolean retval = false;
		//find the required job
		for (Job j: jobList) {
			if (j.getJobID().equals(jobID)) {
				j.setLchannelID("");
				j.setLisAssigned(false);
				retval = true;
				break;
			}
		}		
		return retval;
	}
	
	@RequestMapping("/canceljob")
	public boolean cancelJob(@RequestParam(value="job_id")String jobID){
		boolean retval = false;
		//find the required job
		for (Job j: jobList) {
			if (j.getJobID().equals(jobID)) {
				jobList.remove(j);
				retval = true;
				break;
			}
		}		
		return retval;
	}
	
	@RequestMapping("/closejob")
	public boolean closeJob(@RequestParam(value="job_id")String jobID){
		boolean retval = false;
		//find the required job
		for (Job j: jobList) {
			if (j.getJobID().equals(jobID)) {
				j.setLisActive(false);
				retval = true;
				break;
			}
		}		
		return retval;
	}
	
	
	@RequestMapping("/queryjob")
	public Job queryJob(@RequestParam(value="job_id")String jobID){
		Job retval = new Job();
		//find the required job
		for (Job j: jobList) {
			if (j.getJobID().equals(jobID)) {
				retval = j;
				break;
			}
		}		
		return retval;
	}
	
	@RequestMapping("/getActivejoblist")
	public ArrayList<Job> getActiveJobList(){
		ArrayList<Job> retval= new ArrayList<Job>();
		if (jobList!=null) {
			for (Job j:jobList) {
				if(j.isLisActive() == true && j.isLisAssigned() == false) {
					retval.add(j);
				}
			}
		}else {
			retval.add(new Job());
		}
		return retval;
	}
	
	
	//user handler API 
	@RequestMapping("/createuser")
	public String createuser(@RequestParam(value="usr_name")String name,@RequestParam(value="phone_no")long phoneNo){
		String retval = new String();
		User u = new User(name, phoneNo);
		
		if (u!=null) {
			userList.add(u);
			retval = new String("OK");
			retval += u.getID();
		}
		return retval;
	}
	
	
	
	
}

