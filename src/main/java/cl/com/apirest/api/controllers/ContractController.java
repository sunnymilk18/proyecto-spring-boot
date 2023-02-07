package cl.com.apirest.api.controllers;

import cl.com.apirest.api.models.Contract;
import cl.com.apirest.api.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ContractController {

    @Autowired
    private ContractServices contractServices;

    @PostMapping("/contracts/create")
    public ResponseEntity <Contract> createContract (@RequestBody Contract contract) {
        return ResponseEntity.ok().body(contractServices.createContract(contract));
    }

    @GetMapping("contracts")
    public ResponseEntity <List<Contract>> getAllContracts () {
        return ResponseEntity.ok().body(contractServices.getAllContracts());
    }

    @GetMapping("/contracts/{id}")
    public ResponseEntity <Contract> getContractById (@PathVariable Long id){
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(contractServices.getContractById(id));
    }

    @PutMapping("/contracts/update")
    public ResponseEntity <Contract> updateContract (@RequestBody Contract contract) {
        return ResponseEntity.ok().body(contractServices.updateContractById(contract));
    }

    @DeleteMapping("/contracts/delete/{id}")
    public ResponseEntity <Contract> deleteContract(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        this.contractServices.deleteContract(id);
        return ResponseEntity.noContent().build();
    }


}
