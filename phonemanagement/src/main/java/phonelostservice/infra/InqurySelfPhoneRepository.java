package phonelostservice.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "inqurySelfPhones",
    path = "inqurySelfPhones"
)
public interface InqurySelfPhoneRepository
    extends PagingAndSortingRepository<InqurySelfPhone, Long> {}
