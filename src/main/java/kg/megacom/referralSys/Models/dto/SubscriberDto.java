package kg.megacom.referralSys.Models.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SubscriberDto {
    private long subsId;
    private String phone;
    private boolean active;
    private Date editDate;
    private Date addDate;
}
