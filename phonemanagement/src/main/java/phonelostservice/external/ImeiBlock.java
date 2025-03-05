package phonelostservice.external;

import java.util.Date;
import lombok.Data;

@Data
public class ImeiBlock {

    private Long id;
    private Long deviceId;
    private String imeiNumber;
    private String status;
    private Date blockedAt;
    private Long deviceId;
    private String imeiNumber;
    private String status;
    private Date blockedAt;
}
