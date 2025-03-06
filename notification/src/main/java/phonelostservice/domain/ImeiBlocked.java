package phonelostservice.domain;

import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

@Data
@ToString
public class ImeiBlocked extends AbstractEvent {

    private Long id;
    private Long deviceId;
    private String imeiNumber;
    private String status;
    private Date blockedAt;
}
