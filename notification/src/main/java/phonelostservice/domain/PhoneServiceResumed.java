package phonelostservice.domain;

import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

@Data
@ToString
public class PhoneServiceResumed extends AbstractEvent {

    private Long id;
    private String status;
    private Date blockedAt;
}
