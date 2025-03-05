package phonelostservice.domain;

import java.util.*;
import lombok.*;
import phonelostservice.domain.*;
import phonelostservice.infra.AbstractEvent;

@Data
@ToString
public class ImeiUnblocked extends AbstractEvent {

    private Long id;
}
