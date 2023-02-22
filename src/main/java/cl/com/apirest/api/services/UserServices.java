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
            existingUser.setUserName(user.getUserName());
            existingUser.setLastName(user.getLastName());
            existingUser.setRut(user.getRut());
            existingUser.setBirthdate(user.getBirthdate());
            existingUser.setContactNumber(user.getContactNumber());
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
