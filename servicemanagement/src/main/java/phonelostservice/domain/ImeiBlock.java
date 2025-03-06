package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.ServicemanagementApplication;
import phonelostservice.domain.ImeiBlocked;
import phonelostservice.domain.ImeiUnblocked;

@Entity
@Table(name = "ImeiBlock_table")
@Data
//<<< DDD / Aggregate Root
public class ImeiBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long deviceId;

    private String imeiNumber;

    private String status;

    private Date blockedAt;

    public static ImeiBlockRepository repository() {
        ImeiBlockRepository imeiBlockRepository = ServicemanagementApplication.applicationContext.getBean(
            ImeiBlockRepository.class
        );
        return imeiBlockRepository;
    }

    //<<< Clean Arch / Port Method
    public static void blockOnLost(
        DeviceStatusChangedToLost deviceStatusChangedToLost
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        ImeiBlock imeiBlock = new ImeiBlock();
        repository().save(imeiBlock);

        ImeiBlocked imeiBlocked = new ImeiBlocked(imeiBlock);
        imeiBlocked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deviceStatusChangedToLost.get???()).ifPresent(imeiBlock->{
            
            imeiBlock // do something
            repository().save(imeiBlock);

            ImeiBlocked imeiBlocked = new ImeiBlocked(imeiBlock);
            imeiBlocked.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void blockOnNormal(
        DeviceStatusChangedToNormal deviceStatusChangedToNormal
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        ImeiBlock imeiBlock = new ImeiBlock();
        repository().save(imeiBlock);

        ImeiUnblocked imeiUnblocked = new ImeiUnblocked(imeiBlock);
        imeiUnblocked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deviceStatusChangedToNormal.get???()).ifPresent(imeiBlock->{
            
            imeiBlock // do something
            repository().save(imeiBlock);

            ImeiUnblocked imeiUnblocked = new ImeiUnblocked(imeiBlock);
            imeiUnblocked.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
