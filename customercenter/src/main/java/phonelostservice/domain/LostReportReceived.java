package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phonelostservice.infra.AbstractEvent;

@Data
public class LostReportReceived extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long deviceId;
    private String status;
    private Date reportedAt;
}
