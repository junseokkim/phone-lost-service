package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceUnlockRemotely extends AbstractEvent {

    private Long id;
    private String status;
    private Date lockedAt;

    public DeviceUnlockRemotely(RemoteLock aggregate) {
        super(aggregate);
    }

    public DeviceUnlockRemotely() {
        super();
    }
}
//>>> DDD / Domain Event
