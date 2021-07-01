package kg.megacom.referralSys.Models;

import kg.megacom.referralSys.Enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "invites")
@Data
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Subscriber sender;
    @ManyToOne
    private Subscriber receiver;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
