package phonelostservice.external;

import java.util.Date;
import lombok.Data;

@Data
public class Device {

    private Long id;
    private Long userId;
    private String model;
    private String status;
    private Boolean locked;
    private Date registeredAt;
    private Date updatedAt;
}
