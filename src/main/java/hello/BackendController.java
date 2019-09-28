package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import backend.interfaces.*;
import backend.response.CombinedResponse;
import backend.response.Coordinate;
import backend.utils.*;

@RestController
public class BackendController {
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong userCounter = new AtomicLong();
	ArrayList<Job> jobList = new ArrayList<Job>();
	ArrayList<User> userList = new ArrayList<User>();
	private static final String template = "%s";

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/createjob")
	public CombinedResponse createJob(@RequestParam(value = "src_street") String srcStreet,
			@RequestParam(value = "src_no") int srcStreetNo, @RequestParam(value = "src_zip") int srcZIP,
			@RequestParam(value = "src_addr_line") String srcAddressLine,
			@RequestParam(value = "dst_street") String dstStreet, @RequestParam(value = "dst_no") int dstStreetNo,
			@RequestParam(value = "dst_zip") int dstZIP, @RequestParam(value = "dst_street") String dstAddressLine,
			@RequestParam(value = "city") String city, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "delivery_type") String deliveryTpe,
			@RequestParam(value = "tokenSet") boolean isTokenGiven,
			@RequestParam(value = "tokencount", defaultValue = "0") int tokenCount,
			@RequestParam(value = "prod_id") String prodID, @RequestParam(value = "cons_id") String conID,
			@RequestParam(value = "chan_id", defaultValue = "") String chanID) {
		CombinedResponse retval = new CombinedResponse();
		// check IDS for a match
		boolean isProdRegistered = checkID(prodID);
		boolean isConsRegistered = checkID(conID);
		boolean isChanRegistered = checkID(chanID) || chanID.equals("");
		if (isProdRegistered && isConsRegistered && isChanRegistered) {
			Coordinate src_coord = calculateCoords(srcStreet, srcStreetNo, srcZIP, city);
			Coordinate dst_coord = calculateCoords(dstStreet, dstStreetNo, dstZIP, city);
			Job x = new Job(src_coord.lat,src_coord.lon,dst_coord.lat,dst_coord.lon,String.format(template,
					title),String.format(template, desc),isTokenGiven,tokenCount,
					String.format(template, prodID),String.format(template,
							conID),String.format(template, chanID),counter.getAndIncrement());

			if (x != null) {
				jobList.add(x);
				retval = new CombinedResponse(title, deliveryTpe);
			}
		} else {
			retval = new CombinedResponse("null", "null");
		}
		return retval;
	}

	private Coordinate calculateCoords(String Street, int streetNo, int zip, String city) {
		Coordinate retval = new Coordinate();
		// TODO do something here
		retval = new Coordinate(1.0, 1.0);
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

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/getjoblist")
	public ArrayList<Job> getJobList() {
		ArrayList<Job> retval = new ArrayList<Job>();

		if (jobList != null) {
			retval.addAll(jobList);
		} else {
			retval.add(new Job());
		}
		return retval;
	}

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/assignjob")
	public boolean assignJob(@RequestParam(value = "job_id") String jobID,
			@RequestParam(value = "chan_id") String chanID) {
		boolean retval = false;
		// find the required job
		for (Job j : jobList) {
			if (j.getJobID().equals(jobID)) {
				j.setLchannelID(chanID);
				j.setLisAssigned(true);
				retval = true;
				break;
			}
		}
		return retval;
	}

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/unassignjob")
	public boolean unassignJob(@RequestParam(value = "job_id") String jobID) {
		boolean retval = false;
		// find the required job
		for (Job j : jobList) {
			if (j.getJobID().equals(jobID)) {
				j.setLchannelID("");
				j.setLisAssigned(false);
				retval = true;
				break;
			}
		}
		return retval;
	}

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/canceljob")
	public boolean cancelJob(@RequestParam(value = "job_id") String jobID) {
		boolean retval = false;
		// find the required job
		for (Job j : jobList) {
			if (j.getJobID().equals(jobID)) {
				jobList.remove(j);
				retval = true;
				break;
			}
		}
		return retval;
	}

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/closejob")
	public boolean closeJob(@RequestParam(value = "job_id") String jobID) {
		boolean retval = false;
		// find the required job
		for (Job j : jobList) {
			if (j.getJobID().equals(jobID)) {
				j.setLisActive(false);
				retval = true;
				break;
			}
		}
		return retval;
	}

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/queryjob")
	public Job queryJob(@RequestParam(value = "job_id") String jobID) {
		Job retval = new Job();
		// find the required job
		for (Job j : jobList) {
			if (j.getJobID().equals(jobID)) {
				retval = j;
				break;
			}
		}
		return retval;
	}

	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/getActivejoblist")
	public ArrayList<Job> getActiveJobList() {
		ArrayList<Job> retval = new ArrayList<Job>();
		if (jobList != null) {
			for (Job j : jobList) {
				if (j.isLisActive() == true && j.isLisAssigned() == false) {
					retval.add(j);
				}
			}
		} else {
			retval.add(new Job());
		}
		return retval;
	}

	// user handler API
	@CrossOrigin(origins = "http://10.4.1.130:8080")
	@RequestMapping("/createuser")
	public String createuser(@RequestParam(value = "usr_name") String name,
			@RequestParam(value = "phone_no") long phoneNo) {
		String retval = new String();
		User u = new User(name, phoneNo, userCounter.getAndIncrement());

		if (u != null) {
			userList.add(u);
			retval = new String("");
			retval += u.getID();
		}
		return retval;
	}

}
