package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceResetRemotely extends AbstractEvent {

    private Long id;
    private String status;
    private Date lockedAt;
    private String status;
    private Date lockedAt;
    private String status;
    private Date lockedAt;

    public DeviceResetRemotely(RemoteLock aggregate) {
        super(aggregate);
    }

    public DeviceResetRemotely() {
        super();
    }
}
//>>> DDD / Domain Event
