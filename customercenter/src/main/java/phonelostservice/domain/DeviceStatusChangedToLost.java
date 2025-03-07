package phonelostservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phonelostservice.infra.AbstractEvent;

@Data
public class DeviceStatusChangedToLost extends AbstractEvent {

    private Long id;
    private String status;
    private Date updatedAt;
}
