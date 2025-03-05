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

    public PhoneServiceSuspended(UsimBlock aggregate) {
        super(aggregate);
    }

    public PhoneServiceSuspended() {
        super();
    }
}
//>>> DDD / Domain Event
