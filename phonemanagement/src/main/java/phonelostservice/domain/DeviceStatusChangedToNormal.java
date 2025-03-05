package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceStatusChangedToNormal extends AbstractEvent {

    private Long id;
    private String status;
    private Date updatedAt;
    private String status;
    private Date updatedAt;
    private String status;
    private Date updatedAt;

    public DeviceStatusChangedToNormal(Device aggregate) {
        super(aggregate);
    }

    public DeviceStatusChangedToNormal() {
        super();
    }
}
//>>> DDD / Domain Event
