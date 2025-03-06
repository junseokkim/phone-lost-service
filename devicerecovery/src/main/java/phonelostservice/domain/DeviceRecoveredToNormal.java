package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceRecoveredToNormal extends AbstractEvent {

    private Long id;

    public DeviceRecoveredToNormal(Recovery aggregate) {
        super(aggregate);
    }

    public DeviceRecoveredToNormal() {
        super();
    }
}
//>>> DDD / Domain Event
