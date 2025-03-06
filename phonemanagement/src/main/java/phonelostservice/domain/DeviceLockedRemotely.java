package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceLockedRemotely extends AbstractEvent {

    private Long id;
    private Date lockedAt;
    private String status;

    public DeviceLockedRemotely(RemoteLock aggregate) {
        super(aggregate);
    }

    public DeviceLockedRemotely() {
        super();
    }
}
//>>> DDD / Domain Event
