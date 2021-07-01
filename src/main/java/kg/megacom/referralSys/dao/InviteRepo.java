package kg.megacom.referralSys.dao;

import kg.megacom.referralSys.Models.Invite;
import kg.megacom.referralSys.Models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InviteRepo extends JpaRepository<Invite, Long> {
    long countAllBySenderAndStartDateAfter(Subscriber sender,  Date date);
    Invite findByReceiver(Subscriber receiver);
}
