package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.PhonemanagementApplication;
import phonelostservice.domain.DeviceLockedRemotely;
import phonelostservice.domain.DeviceResetRemotely;

@Entity
@Table(name = "RemoteLock_table")
@Data
//<<< DDD / Aggregate Root
public class RemoteLock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long deviceId;

    private String status;

    private Date lockedAt;

    @PostPersist
    public void onPostPersist() {
        DeviceLockedRemotely deviceLockedRemotely = new DeviceLockedRemotely(
            this
        );
        deviceLockedRemotely.publishAfterCommit();

        DeviceResetRemotely deviceResetRemotely = new DeviceResetRemotely(this);
        deviceResetRemotely.publishAfterCommit();
    }

    public static RemoteLockRepository repository() {
        RemoteLockRepository remoteLockRepository = PhonemanagementApplication.applicationContext.getBean(
            RemoteLockRepository.class
        );
        return remoteLockRepository;
    }
}
//>>> DDD / Aggregate Root
