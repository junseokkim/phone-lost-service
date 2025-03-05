package phonelostservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "recoveries",
    path = "recoveries"
)
public interface RecoveryRepository
    extends PagingAndSortingRepository<Recovery, Long> {}
