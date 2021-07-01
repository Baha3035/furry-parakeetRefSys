package kg.megacom.referralSys.Models.dto;

import kg.megacom.referralSys.Enums.Status;
import kg.megacom.referralSys.Models.Subscriber;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

public class InviteDto {
    private long id;

    private SubscriberDto sender;

    private SubscriberDto receiver;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
}
