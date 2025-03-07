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

    //<<< Clean Arch / Port Method
    public static void changeDeviceStatusLost(
        LostReportReceived lostReportReceived
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStatusChangedToLost deviceStatusChangedToLost = new DeviceStatusChangedToLost(device);
        deviceStatusChangedToLost.publishAfterCommit();
        */
        

        repository().findById(lostReportReceived.getDeviceId()).ifPresent(device->{
            
            device.setStatus("LOST");
            device.setLocked(true);
            device.setUpdatedAt(new Date());
            repository().save(device);

            DeviceStatusChangedToLost deviceStatusChangedToLost = new DeviceStatusChangedToLost(device);
            deviceStatusChangedToLost.publishAfterCommit();

         });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeDeviceStatusNormal(
        LostReportCancelled lostReportCancelled
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStatusChangedToNormal deviceStatusChangedToNormal = new DeviceStatusChangedToNormal(device);
        deviceStatusChangedToNormal.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostReportCancelled.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStatusChangedToNormal deviceStatusChangedToNormal = new DeviceStatusChangedToNormal(device);
            deviceStatusChangedToNormal.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
