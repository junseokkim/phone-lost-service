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
import phonelostservice.domain.DeviceUnlockRemotely;

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

    public static RemoteLockRepository repository() {
        RemoteLockRepository remoteLockRepository = PhonemanagementApplication.applicationContext.getBean(
            RemoteLockRepository.class
        );
        return remoteLockRepository;
    }

    //<<< Clean Arch / Port Method
    public static void requestRemoteLock(
        DeviceStatusChangedToLost deviceStatusChangedToLost
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        RemoteLock remoteLock = new RemoteLock();
        repository().save(remoteLock);

        DeviceLockedRemotely deviceLockedRemotely = new DeviceLockedRemotely(remoteLock);
        deviceLockedRemotely.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deviceStatusChangedToLost.get???()).ifPresent(remoteLock->{
            
            remoteLock // do something
            repository().save(remoteLock);

            DeviceLockedRemotely deviceLockedRemotely = new DeviceLockedRemotely(remoteLock);
            deviceLockedRemotely.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void requestRemoteUnlock(
        DeviceStatusChangedToNormal deviceStatusChangedToNormal
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        RemoteLock remoteLock = new RemoteLock();
        repository().save(remoteLock);

        DeviceUnlockRemotely deviceUnlockRemotely = new DeviceUnlockRemotely(remoteLock);
        deviceUnlockRemotely.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deviceStatusChangedToNormal.get???()).ifPresent(remoteLock->{
            
            remoteLock // do something
            repository().save(remoteLock);

            DeviceUnlockRemotely deviceUnlockRemotely = new DeviceUnlockRemotely(remoteLock);
            deviceUnlockRemotely.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
