package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceFound extends AbstractEvent {

    private Long id;

    public DeviceFound(Recovery aggregate) {
        super(aggregate);
    }

    public DeviceFound() {
        super();
    }
}
//>>> DDD / Domain Event
