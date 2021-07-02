package kg.megacom.referralSys.Controllers;

import kg.megacom.referralSys.Models.dto.SubscriberDto;
import kg.megacom.referralSys.Service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("Subscriber/block")
    SubscriberDto block(@RequestParam("active") boolean active, @RequestBody SubscriberDto subscriberDto){
        return subscriberService.block(subscriberDto, active);
    }
}