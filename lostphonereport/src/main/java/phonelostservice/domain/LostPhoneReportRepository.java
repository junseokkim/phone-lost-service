package phonelostservice.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "lostPhoneReports",
    path = "lostPhoneReports"
)
public interface LostPhoneReportRepository
    extends PagingAndSortingRepository<LostPhoneReport, Long> {}
