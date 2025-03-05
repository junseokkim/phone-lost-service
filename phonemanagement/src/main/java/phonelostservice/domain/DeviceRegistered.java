package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceRegistered extends AbstractEvent {

    private Long id;
    private Long userId;
    private String model;
    private String status;
    private Boolean locked;
    private Date registeredAt;
    private Date updatedAt;

    public DeviceRegistered(Device aggregate) {
        super(aggregate);
    }

    public DeviceRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
