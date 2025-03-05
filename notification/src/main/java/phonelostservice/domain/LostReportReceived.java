package phonelostservice.domain;

import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

@Data
@ToString
public class LostReportReceived extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long deviceId;
    private String status;
    private Date reportedAt;
    private Long userId;
    private Long deviceId;
    private String status;
    private Date reportedAt;
}
