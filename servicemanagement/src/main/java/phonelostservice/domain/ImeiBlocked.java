package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ImeiBlocked extends AbstractEvent {

    private Long id;
    private Long deviceId;
    private String imeiNumber;
    private String status;
    private Date blockedAt;

    public ImeiBlocked(ImeiBlock aggregate) {
        super(aggregate);
    }

    public ImeiBlocked() {
        super();
    }
}
//>>> DDD / Domain Event
