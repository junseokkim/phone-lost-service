package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneServiceSuspended extends AbstractEvent {

    private Long id;
    private Long deviceId;
    private String status;
    private Date blockedAt;

    public PhoneServiceSuspended(UsimBlock aggregate) {
        super(aggregate);
    }

    public PhoneServiceSuspended() {
        super();
    }
}
//>>> DDD / Domain Event
