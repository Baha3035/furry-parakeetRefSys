package kg.megacom.referralSys.Service.impl;

import kg.megacom.referralSys.Enums.Status;
import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.Subscriber;
import kg.megacom.referralSys.Models.dto.InviteDto;
import kg.megacom.referralSys.Service.InviteService;
import kg.megacom.referralSys.Service.SubscriberService;
import kg.megacom.referralSys.dao.InviteRepo;
import kg.megacom.referralSys.dao.SubscriberRepo;
import kg.megacom.referralSys.exceptions.LimitReachedException;
import kg.megacom.referralSys.mappers.InviteMapper;
import kg.megacom.referralSys.mappers.SubscriberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.List;

@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteRepo inviteRepo;

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private SubscriberMapper subscriberMapper;

    @Autowired
    private InviteMapper inviteMapper;

    @Override
    public void saveInvite() {

    }

    @Override
    public List<Invite> findAll() {
        return null;
    }

    @Override
    public InviteDto sendInvite(InviteDto inviteDto) {
        inviteDto.setSender(subscriberService.getOrCreate(inviteDto.getSender()));
        inviteDto.setReceiver(subscriberService.getOrCreate(inviteDto.getReceiver()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        long count = inviteRepo.countAllBySenderAndStartDateAfter(subscriberMapper.toSubscriber(inviteDto.getSender()), calendar.getTime());

        if (count == 5){
            throw new LimitReachedException("Достигнуто максимальное число инвайтов за сутки!!!");
        }

        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        count = inviteRepo.countAllBySenderAndStartDateAfter(subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime());

        if(!inviteDto.getReceiver().isActive()){
            throw new ArithmeticException("Абонент отключил возможность приглашения!");
        }


        System.out.println(inviteDto);
        return inviteDto;
    }

    @Override
    public InviteDto acceptInvite(long subsId) {
        if (subscriberRepo.existsById(subsId)) {
            if (inviteRepo.findByReceiver(subscriberRepo.getById(subsId)) != null) {
                InviteDto inviteDto = inviteMapper.toInviteDto(
                        inviteRepo.findByReceiver(subscriberRepo.getById(subsId)));
                inviteDto.setStatus(Status.ACCEPTED);
                return null;
            }
            throw new RuntimeException("У абонента нет приглашения!!!");
        }

        Subscriber subscriber = new Subscriber();
        subscriber.setActive(false);
        subscriber.setSubsId(subsId);
        subscriberRepo.save(subscriber);
        throw new RuntimeException("Абонента не существует!!!");
    }
}
