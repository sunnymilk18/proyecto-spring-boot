package cl.com.apirest.api.controllers;


import cl.com.apirest.api.models.Company;
import cl.com.apirest.api.services.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CompanyController {

    @Autowired
    private CompanyServices companyServices;

    @PostMapping("/company/create")
    public ResponseEntity <Company> createCompany (@RequestBody Company company) {
        return ResponseEntity.ok().body(companyServices.createCompany(company));
    }

    @GetMapping("company")
    public ResponseEntity <List<Company>> getAllCompany () {
        return ResponseEntity.ok().body(companyServices.getAllCompany());
    }

    @GetMapping("/company/{id}")
    public ResponseEntity <Company> getCompanyById (@PathVariable Long id){
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(companyServices.getCompanyById(id));
    }

    @PutMapping("/company/update")
    public ResponseEntity <Company> updateCompany (@RequestBody Company company) {
        return ResponseEntity.ok().body(companyServices.updateCompanyById(company));
    }

    @DeleteMapping("/company/delete/{id}")
    public ResponseEntity <Company> deleteCompany(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        this.companyServices.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

}
