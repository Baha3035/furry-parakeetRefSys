package kg.megacom.referralSys.Service.impl;

import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.dto.InviteDto;
import kg.megacom.referralSys.Service.InviteService;
import kg.megacom.referralSys.Service.SubscriberService;
import kg.megacom.referralSys.dao.InviteRepo;
import kg.megacom.referralSys.dao.SubscriberRepo;
import kg.megacom.referralSys.mappers.SubscriberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.List;

@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteRepo inviteRepo;

    @Autowired
    private SubscriberService subscriberService;

    private SubscriberMapper subscriberMapper;

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
        calendar.add();
    }
}
