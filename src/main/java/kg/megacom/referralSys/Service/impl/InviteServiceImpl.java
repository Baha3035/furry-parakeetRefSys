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
    public void saveInvite(InviteDto inviteDto) {
        inviteRepo.save(inviteMapper.toInvite(inviteDto));
    }

    @Override
    public List<Invite> findAll() {
        return null;
    }

    @Override
    public InviteDto sendInvite(InviteDto inviteDto) {
        inviteDto.setSender(subscriberService.getOrCreate(inviteDto.getSender()));
        inviteDto.setReceiver(subscriberService.getOrCreate(inviteDto.getReceiver()));
        inviteDto.setStatus(Status.ACTIVE);

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

        saveInvite(inviteDto);

        if(inviteRepo.countAllByReceiver(subscriberMapper.toSubscriber(inviteDto.getReceiver())) > 1){
            inviteRepo.getById(inviteMapper.toInvite(inviteDto).getId()-1).setStatus(Status.NOT_ACTIVE);
        }


        System.out.println(inviteDto);
        return inviteDto;
    }

    @Override
    public InviteDto acceptInvite(long subsId) {
        if (subscriberRepo.existsById(subsId)) {
            if (inviteRepo.findByReceiverAndStatus(subscriberRepo.getById(subsId), Status.ACTIVE) != null) {
                InviteDto inviteDto = inviteMapper.toInviteDto(
                        inviteRepo.findByReceiverAndStatus(subscriberRepo.getById(subsId), Status.ACTIVE));
                inviteDto.setStatus(Status.ACCEPTED);
                return inviteDto;
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
