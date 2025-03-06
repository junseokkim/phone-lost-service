package phonelostservice.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "inquiryLostReports",
    path = "inquiryLostReports"
)
public interface InquiryLostReportRepository
    extends PagingAndSortingRepository<InquiryLostReport, Long> {}
