package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostReportCancelled extends AbstractEvent {

    private Long id;

    public LostReportCancelled(LostPhoneReport aggregate) {
        super(aggregate);
    }

    public LostReportCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
