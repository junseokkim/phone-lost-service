package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostReportReceived extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long deviceId;
    private String status;
    private Date reportedAt;
    private Long userId;
    private Long deviceId;
    private String status;
    private Date reportedAt;

    public LostReportReceived(LostPhoneReport aggregate) {
        super(aggregate);
    }

    public LostReportReceived() {
        super();
    }
}
//>>> DDD / Domain Event
