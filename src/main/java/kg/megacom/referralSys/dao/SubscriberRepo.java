package kg.megacom.referralSys.dao;

import kg.megacom.referralSys.Models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {
}
