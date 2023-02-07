package cl.com.apirest.api.repositories;

import cl.com.apirest.api.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, Long> {
}
