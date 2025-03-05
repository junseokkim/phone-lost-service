package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ImeiUnblocked extends AbstractEvent {

    private Long id;

    public ImeiUnblocked(ImeiBlock aggregate) {
        super(aggregate);
    }

    public ImeiUnblocked() {
        super();
    }
}
//>>> DDD / Domain Event
