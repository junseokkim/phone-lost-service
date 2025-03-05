package phonelostservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "통신서비스차단정보조회_table")
@Data
public class 통신서비스차단정보조회 {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
