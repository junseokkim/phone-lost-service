package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.ServicemanagementApplication;
import phonelostservice.domain.PhoneServiceResumed;
import phonelostservice.domain.PhoneServiceSuspended;

@Entity
@Table(name = "UsimBlock_table")
@Data
//<<< DDD / Aggregate Root
public class UsimBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long deviceId;

    private String status;

    private Date blockedAt;

    @PostPersist
    public void onPostPersist() {
        PhoneServiceSuspended phoneServiceSuspended = new PhoneServiceSuspended(
            this
        );
        phoneServiceSuspended.publishAfterCommit();

        PhoneServiceResumed phoneServiceResumed = new PhoneServiceResumed(this);
        phoneServiceResumed.publishAfterCommit();
    }

    public static UsimBlockRepository repository() {
        UsimBlockRepository usimBlockRepository = ServicemanagementApplication.applicationContext.getBean(
            UsimBlockRepository.class
        );
        return usimBlockRepository;
    }
}
//>>> DDD / Aggregate Root
