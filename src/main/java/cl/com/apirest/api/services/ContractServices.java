package cl.com.apirest.api.services;

import cl.com.apirest.api.models.Contract;
import cl.com.apirest.api.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServices {

    @Autowired
    private ContractRepository contractRepository;


    public Contract createContract(Contract contract) {

        return contractRepository.save(contract);
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Contract getContractById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El campo id no puede estar en blanco o el valor ingresado es invalido");
        }
        return contractRepository.findById(id).orElseThrow();
    }

    public Contract updateContractById(Contract contract) {
        Contract existingContract = contractRepository.findById(contract.getId()).orElse(null);
        if (existingContract != null) {
            existingContract.setContractDate(contract.getContractDate());
            existingContract.setOccupation(contract.getOccupation());
            existingContract.setTypeContract(contract.getTypeContract());
            existingContract.setSalary(contract.getSalary());
            return contractRepository.save(existingContract);
        }else {
            return null;
        }
    }

    public String deleteContract(Long id) {
        contractRepository.deleteById(id);
        return "El contrato a sido borrado " + id;
    }
}
