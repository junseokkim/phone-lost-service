package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneServiceResumed extends AbstractEvent {

    private Long id;
    private String status;
    private Date blockedAt;

    public PhoneServiceResumed(UsimBlock aggregate) {
        super(aggregate);
    }

    public PhoneServiceResumed() {
        super();
    }
}
//>>> DDD / Domain Event
