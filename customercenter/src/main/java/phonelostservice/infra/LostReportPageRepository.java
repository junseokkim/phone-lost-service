package phonelostservice.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "lostReportPages",
    path = "lostReportPages"
)
public interface LostReportPageRepository
    extends PagingAndSortingRepository<LostReportPage, Long> {
    List<LostReportPage> findByDeviceId(Long deviceId);
}
