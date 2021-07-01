package kg.megacom.referralSys.Models.dto;

import kg.megacom.referralSys.Enums.Status;
import kg.megacom.referralSys.Models.Subscriber;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class InviteDto {
    private long id;

    private SubscriberDto sender;

    private SubscriberDto receiver;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
}
