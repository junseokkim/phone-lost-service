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

    private Long deviceId;

    private String imeiNumber;

    private String status;

    private Date blockedAt;

    @PostPersist
    public void onPostPersist() {
        ImeiBlocked imeiBlocked = new ImeiBlocked(this);
        imeiBlocked.publishAfterCommit();

        ImeiUnblocked imeiUnblocked = new ImeiUnblocked(this);
        imeiUnblocked.publishAfterCommit();
    }

    public static ImeiBlockRepository repository() {
        ImeiBlockRepository imeiBlockRepository = ServicemanagementApplication.applicationContext.getBean(
            ImeiBlockRepository.class
        );
        return imeiBlockRepository;
    }
}
//>>> DDD / Aggregate Root
