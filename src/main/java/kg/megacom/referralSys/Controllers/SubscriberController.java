package kg.megacom.referralSys.Controllers;

import kg.megacom.referralSys.Models.dto.SubscriberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriberController {

    @PostMapping("Subscriber/block")
    SubscriberDto block(@RequestParam("active") boolean active, @RequestBody SubscriberDto subscriberDto){

    }
}
