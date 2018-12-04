package superchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import superchat.client.FeignDbClient;
import superchat.models.Donation;

	@RestController
	@Api("Root of superchat microservice")
	@RequestMapping("/apisc")
	public class DonationsController {
	    @Autowired
	    private FeignDbClient client;
	 
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully posted donation")
	    })
	    
	    @ApiOperation(value = "Post donation")
	    @RequestMapping(method=RequestMethod.POST, value="/donate", 
	    			params = { "streamerId", "donorId", "eurosponges" })
	    @ResponseBody
	    public ResponseEntity<?> post(
	    				@RequestParam(value = "streamerId", required = true) int streamerId,
	    				@RequestParam(value = "donorId", required = true) int donorId,
	    				@RequestParam(value = "eurosponges", required = true) int sponges) {
	    	
	    	Donation donation = client.postDonate(streamerId, donorId, sponges);
	    	
	    	return new ResponseEntity<>(donation, HttpStatus.OK);
	    }
}
