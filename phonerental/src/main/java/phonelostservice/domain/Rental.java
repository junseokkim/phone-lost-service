package phonelostservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonelostservice.PhonerentalApplication;

@Entity
@Table(name = "Rental_table")
@Data
//<<< DDD / Aggregate Root
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String deviceModel;

    private String status;

    private Date rentalStartDate;

    private Date expectedReturnDate;

    public static RentalRepository repository() {
        RentalRepository rentalRepository = PhonerentalApplication.applicationContext.getBean(
            RentalRepository.class
        );
        return rentalRepository;
    }
}
//>>> DDD / Aggregate Root
