package phonelostservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "imeiBlocks",
    path = "imeiBlocks"
)
public interface ImeiBlockRepository
    extends PagingAndSortingRepository<ImeiBlock, Long> {}
