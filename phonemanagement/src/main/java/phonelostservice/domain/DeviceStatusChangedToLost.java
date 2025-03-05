package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceStatusChangedToLost extends AbstractEvent {

    private Long id;
    private String status;
    private Date updatedAt;
    private String status;
    private Date updatedAt;
    private String status;
    private Date updatedAt;

    public DeviceStatusChangedToLost(Device aggregate) {
        super(aggregate);
    }

    public DeviceStatusChangedToLost() {
        super();
    }
}
//>>> DDD / Domain Event
