package tacos.data.jpa_repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.security.users_domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
