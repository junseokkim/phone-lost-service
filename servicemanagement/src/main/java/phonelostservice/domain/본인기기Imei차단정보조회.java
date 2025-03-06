package phonelostservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "본인기기Imei차단정보조회_table")
@Data
public class 본인기기Imei차단정보조회 {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
