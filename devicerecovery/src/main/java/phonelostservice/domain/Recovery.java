package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.DevicerecoveryApplication;
import phonelostservice.domain.DeviceFound;
import phonelostservice.domain.DeviceRecoveredToNormal;

@Entity
@Table(name = "Recovery_table")
@Data
//<<< DDD / Aggregate Root
public class Recovery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long deviceId;

    private Date recoveredAt;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeviceFound deviceFound = new DeviceFound(this);
        deviceFound.publishAfterCommit();

        DeviceRecoveredToNormal deviceRecoveredToNormal = new DeviceRecoveredToNormal(
            this
        );
        deviceRecoveredToNormal.publishAfterCommit();
    }

    public static RecoveryRepository repository() {
        RecoveryRepository recoveryRepository = DevicerecoveryApplication.applicationContext.getBean(
            RecoveryRepository.class
        );
        return recoveryRepository;
    }
}
//>>> DDD / Aggregate Root
