package kg.megacom.referralSys.Models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "subscribers")
@Data
public class Subscriber {
    @Id
    @Column(name = "subs_id")
    private long subsId;
    private String phone;
    private boolean active;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "edit_date")
    private Date editDate;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_date")
    private Date addDate;
}
