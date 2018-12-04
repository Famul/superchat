package superchat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import superchat.models.Donation;



@FeignClient(name = "db", url = "http://localhost:8030")
public interface FeignDbClient {
    @RequestMapping(method = RequestMethod.POST, value = "/donate")
    Donation postDonate(@RequestParam(value = "streamerId", required = true) int streamerId,
    		@RequestParam(value = "donorId", required = true) int donorId,
    		@RequestParam(value = "eurosponges", required = true) int sponges);
}