package kg.megacom.referralSys.mappers.impl;

import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.dto.InviteDto;
import kg.megacom.referralSys.mappers.InviteMapper;
import kg.megacom.referralSys.mappers.SubscriberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteMapperImpl implements InviteMapper {

    @Autowired
    private SubscriberMapper subscriberMapper;
    @Override
    public Invite toInvite(InviteDto inviteDto) {
        Invite invite = new Invite();
        invite.setReceiver(subscriberMapper.toSubscriber(inviteDto.getReceiver()));
        invite.setSender(subscriberMapper.toSubscriber(inviteDto.getSender()));
        invite.setEndDate(inviteDto.getEndDate());
        invite.setStartDate(inviteDto.getStartDate());
        invite.setStatus(inviteDto.getStatus());
        return invite;
    }

    @Override
    public InviteDto toInviteDto(Invite invite) {
        InviteDto inviteDto = new InviteDto();
        inviteDto.setReceiver(subscriberMapper.toSubscriberDto(invite.getReceiver()));
        inviteDto.setSender(subscriberMapper.toSubscriberDto(invite.getSender()));
        inviteDto.setEndDate(invite.getEndDate());
        inviteDto.setStartDate(invite.getStartDate());
        inviteDto.setStatus(invite.getStatus());
        return inviteDto;
    }
}
