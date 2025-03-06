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
        LostReportReceived lostReportReceived = new LostReportReceived(this);
        lostReportReceived.publishAfterCommit();

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
