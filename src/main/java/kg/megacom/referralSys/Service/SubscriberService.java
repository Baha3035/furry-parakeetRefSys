package kg.megacom.referralSys.Service;


import kg.megacom.referralSys.Models.dto.SubscriberDto;

public interface SubscriberService {
    SubscriberDto getOrCreate(SubscriberDto subscriberDto);
    SubscriberDto block(SubscriberDto subscriberDto, boolean active);
}
