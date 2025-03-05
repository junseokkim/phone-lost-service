package phonelostservice.domain;

import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

@Data
@ToString
public class LostReportCancelled extends AbstractEvent {

    private Long id;
}
