package kg.megacom.referralSys.mappers;

import kg.megacom.referralSys.Models.Subscriber;
import kg.megacom.referralSys.Models.dto.SubscriberDto;

public interface SubscriberMapper {
    SubscriberDto toSubscriberDto(Subscriber subscriber);
    Subscriber toSubscriber(SubscriberDto subscriberDto);
}
