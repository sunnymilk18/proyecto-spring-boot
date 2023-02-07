package cl.com.apirest.api.repositories;

import cl.com.apirest.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
