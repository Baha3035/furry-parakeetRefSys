package kg.megacom.referralSys.Service;

import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.dto.InviteDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InviteService {
    void saveInvite(InviteDto inviteDto);
    List<Invite> findAll();

    InviteDto sendInvite(InviteDto inviteDto);

    InviteDto acceptInvite(long subsId) throws Exception;
}
