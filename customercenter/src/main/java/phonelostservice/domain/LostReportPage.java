package phonelostservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "LostReportPage_table")
@Data
public class LostReportPage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long lostReportId;

    private Long deviceId;
    private String lostReportStatus;
}
