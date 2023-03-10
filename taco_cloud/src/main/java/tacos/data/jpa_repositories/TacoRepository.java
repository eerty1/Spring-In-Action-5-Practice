package tacos.data.jpa_repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.Taco;

@Repository
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
