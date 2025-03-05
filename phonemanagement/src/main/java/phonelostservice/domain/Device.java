package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.PhonemanagementApplication;
import phonelostservice.domain.DeviceRegistered;
import phonelostservice.domain.DeviceStatusChangedToLost;
import phonelostservice.domain.DeviceStatusChangedToNormal;

@Entity
@Table(name = "Device_table")
@Data
//<<< DDD / Aggregate Root
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String model;

    private String status;

    private Boolean locked;

    private Date registeredAt;

    private Date updatedAt;

    @PostPersist
    public void onPostPersist() {
        DeviceRegistered deviceRegistered = new DeviceRegistered(this);
        deviceRegistered.publishAfterCommit();

        DeviceStatusChangedToLost deviceStatusChangedToLost = new DeviceStatusChangedToLost(
            this
        );
        deviceStatusChangedToLost.publishAfterCommit();

        DeviceStatusChangedToNormal deviceStatusChangedToNormal = new DeviceStatusChangedToNormal(
            this
        );
        deviceStatusChangedToNormal.publishAfterCommit();
    }

    public static DeviceRepository repository() {
        DeviceRepository deviceRepository = PhonemanagementApplication.applicationContext.getBean(
            DeviceRepository.class
        );
        return deviceRepository;
    }
}
//>>> DDD / Aggregate Root
