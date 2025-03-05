package phonelostservice.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "통신서비스차단정보조회",
    path = "통신서비스차단정보조회"
)
public interface 통신서비스차단정보조회Repository
    extends PagingAndSortingRepository<통신서비스차단정보조회, Long> {}
