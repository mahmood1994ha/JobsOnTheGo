package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import backend.interfaces.*;
import backend.utils.*;
@RestController
public class BackendController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/createjob")
	public Job greeting(@RequestParam(value="src_lat") double src_lat, 
							@RequestParam(value="src_long")double src_long,
							@RequestParam(value="dst_lat")double dst_lat,
							@RequestParam(value="dst_long")double dst_long,
							@RequestParam(value="description")String desc,
							@RequestParam(value="tokenSet") boolean isTokenGiven,
							@RequestParam(value="tokencount", defaultValue = "0")int tokenCount,
							@RequestParam(value="prod_id")String prodID,
							@RequestParam(value="cons_id")String conID,
							@RequestParam(value="chan_id")String chanID){
		return new Job(src_lat,src_long,dst_lat,dst_long,String.format(template, desc),isTokenGiven,tokenCount,
				String.format(template, prodID),String.format(template, conID),String.format(template, chanID));
	}
}

