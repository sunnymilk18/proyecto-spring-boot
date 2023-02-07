package cl.com.apirest.api.repositories;

import cl.com.apirest.api.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository <Contract, Long> {
}
