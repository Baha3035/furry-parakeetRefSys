package kg.megacom.referralSys.Service.impl;

import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.dto.InviteDto;
import kg.megacom.referralSys.Service.InviteService;
import kg.megacom.referralSys.dao.InviteRepo;
import kg.megacom.referralSys.dao.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteRepo inviteRepo;

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Override
    public void saveInvite() {
        Invite invite = new Invite();
        invite.setSender(subscriberRepo.getById(12414l));
        invite.setReceiver(subscriberRepo.getById(12514l));
    }

    @Override
    public List<Invite> findAll() {
        return null;
    }

    @Override
    public InviteDto sendInvite(InviteDto inviteDto) {
        System.out.println(inviteDto);
        return inviteDto;
    }
}
