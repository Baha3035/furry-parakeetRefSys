package kg.megacom.referralSys.mappers.impl;

import kg.megacom.referralSys.Models.Subscriber;
import kg.megacom.referralSys.Models.dto.SubscriberDto;
import kg.megacom.referralSys.mappers.SubscriberMapper;
import org.springframework.stereotype.Service;

@Service
public class SubscriberMapperImpl implements SubscriberMapper {
    @Override
    public SubscriberDto toSubscriberDto(Subscriber subscriber) {
        SubscriberDto subscriberDto = new SubscriberDto();
        subscriberDto.setSubsId(subscriber.getSubsId());
        subscriberDto.setPhone(subscriber.getPhone());
        subscriberDto.setAddDate(subscriber.getAddDate());
        subscriberDto.setEditDate(subscriber.getEditDate());
        subscriberDto.setActive(subscriber.isActive());
        return subscriberDto;
    }

    @Override
    public Subscriber toSubscriber(SubscriberDto subscriberDto) {
        Subscriber subscriber = new Subscriber();
        subscriber.setSubsId(subscriberDto.getSubsId());
        subscriber.setPhone(subscriberDto.getPhone());
        subscriber.setAddDate(subscriberDto.getAddDate());
        subscriber.setEditDate(subscriberDto.getEditDate());
        subscriber.setActive(subscriberDto.isActive());
        return subscriber;
    }
}
