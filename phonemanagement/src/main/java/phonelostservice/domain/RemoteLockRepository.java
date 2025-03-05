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
    collectionResourceRel = "remoteLocks",
    path = "remoteLocks"
)
public interface RemoteLockRepository
    extends PagingAndSortingRepository<RemoteLock, Long> {}
