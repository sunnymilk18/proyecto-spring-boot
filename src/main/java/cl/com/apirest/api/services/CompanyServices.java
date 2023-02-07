package cl.com.apirest.api.services;

import cl.com.apirest.api.models.Company;
import cl.com.apirest.api.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServices {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El campo id no puede estar en blanco o el valor ingresado es invalido");
        }
        return companyRepository.findById(id).orElseThrow();
    }

    public Company updateCompanyById(Company company) {
        Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
        if (existingCompany != null) {
            existingCompany.setNombre(company.getNombre());
            existingCompany.setRut(company.getRut());
            existingCompany.setDireccion(company.getDireccion());
            existingCompany.setTelefono(company.getTelefono());
            existingCompany.setEmail(company.getEmail());
            return companyRepository.save(existingCompany);
        }else {
            return null;
        }
    }

    public String deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return "La empresa a sido borrada " + id;
    }

}
