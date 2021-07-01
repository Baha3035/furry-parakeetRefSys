package kg.megacom.referralSys.Service.impl;

import kg.megacom.referralSys.Models.Subscriber;
import kg.megacom.referralSys.Models.dto.SubscriberDto;
import kg.megacom.referralSys.Service.SubscriberService;
import kg.megacom.referralSys.dao.SubscriberRepo;
import kg.megacom.referralSys.mappers.SubscriberMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Autowired
    private SubscriberMapper subscriberMapper;



    @Override
    public SubscriberDto getOrCreate(SubscriberDto subscriberDto) {
        Subscriber subscriber = subscriberMapper.toSubscriber(subscriberDto);
        try{

        }
    }
}
