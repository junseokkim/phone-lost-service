package phonelostservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonelostservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "rentals", path = "rentals")
public interface RentalRepository
    extends PagingAndSortingRepository<Rental, Long> {}
