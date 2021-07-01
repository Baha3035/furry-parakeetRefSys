package kg.megacom.referralSys.mappers;

import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.dto.InviteDto;

public interface InviteMapper {
    Invite toInvite(InviteDto inviteDto);
    InviteDto toInviteDto(Invite invite);
}
