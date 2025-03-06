package phonelostservice.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "본인기기Imei차단정보조회",
    path = "본인기기Imei차단정보조회"
)
public interface 본인기기Imei차단정보조회Repository
    extends PagingAndSortingRepository<본인기기Imei차단정보조회, Long> {}
