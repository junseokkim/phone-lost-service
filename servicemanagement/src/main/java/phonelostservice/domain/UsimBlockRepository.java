package phonelostservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "usimBlocks",
    path = "usimBlocks"
)
public interface UsimBlockRepository
    extends PagingAndSortingRepository<UsimBlock, Long> {}
