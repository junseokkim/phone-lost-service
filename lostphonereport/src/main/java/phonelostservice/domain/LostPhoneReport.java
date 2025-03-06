package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.LostphonereportApplication;
import phonelostservice.domain.LostReportCancelled;
import phonelostservice.domain.LostReportReceived;

@Entity
@Table(name = "LostPhoneReport_table")
@Data
//<<< DDD / Aggregate Root
public class LostPhoneReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long deviceId;

    private String status;

    private Date reportedAt;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        phonelostservice.external.Device device = new phonelostservice.external.Device();
        // mappings goes here
        LostphonereportApplication.applicationContext
            .getBean(phonelostservice.external.DeviceService.class)
            .changeDeviceStatusLost(device);

        LostReportReceived lostReportReceived = new LostReportReceived(this);
        lostReportReceived.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        phonelostservice.external.Device device = new phonelostservice.external.Device();
        // mappings goes here
        LostphonereportApplication.applicationContext
            .getBean(phonelostservice.external.DeviceService.class)
            .changeDeviceStatusNormal(device);

        LostReportCancelled lostReportCancelled = new LostReportCancelled(this);
        lostReportCancelled.publishAfterCommit();
    }

    public static LostPhoneReportRepository repository() {
        LostPhoneReportRepository lostPhoneReportRepository = LostphonereportApplication.applicationContext.getBean(
            LostPhoneReportRepository.class
        );
        return lostPhoneReportRepository;
    }
}
//>>> DDD / Aggregate Root
