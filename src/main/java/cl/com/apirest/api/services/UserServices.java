package cl.com.apirest.api.services;

import cl.com.apirest.api.models.User;
import cl.com.apirest.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("El campo id no puede estar en blanco o el valor ingresado es invalido");
        }
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUserById(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setNombre(user.getNombre());
            existingUser.setApellido(user.getApellido());
            existingUser.setRut(user.getRut());
            existingUser.setFechaNacimiento(user.getFechaNacimiento());
            existingUser.setEdad(user.getEdad());
            existingUser.setNumeroContacto(user.getNumeroContacto());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }else {
            return null;
        }
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "La persona a sido borrada " + id;
    }
}
