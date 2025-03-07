package phonelostservice.domain;

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
