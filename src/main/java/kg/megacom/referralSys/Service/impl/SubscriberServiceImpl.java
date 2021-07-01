package kg.megacom.referralSys.Service.impl;

import kg.megacom.referralSys.Models.Subscriber;
import kg.megacom.referralSys.Models.dto.SubscriberDto;
import kg.megacom.referralSys.Service.SubscriberService;
import kg.megacom.referralSys.dao.SubscriberRepo;
import kg.megacom.referralSys.exceptions.SubscriberNotFoundException;
import kg.megacom.referralSys.mappers.SubscriberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Autowired
    private SubscriberMapper subscriberMapper;



    @Override
    public SubscriberDto getOrCreate(SubscriberDto subscriberDto) {
        Subscriber subscriber = subscriberMapper.toSubscriber(subscriberDto);
        try{
            subscriber = subscriberRepo.findById(subscriberDto.getSubsId()).get();
        }
        catch (SubscriberNotFoundException e){
            subscriber.setAddDate(new Date());
            subscriber.setEditDate(new Date());
            subscriber.setActive(true);
            subscriber = subscriberRepo.save(subscriber);
        }
        return subscriberMapper.toSubscriberDto(subscriber);
    }
}
