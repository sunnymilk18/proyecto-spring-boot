package cl.com.apirest.api.controllers;

import cl.com.apirest.api.models.User;
import cl.com.apirest.api.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/users/create")
    public ResponseEntity <User> createUser (@RequestBody User user) {
        return ResponseEntity.ok().body(this.userServices.createUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity <List<User>> getAllUsers (){
        return ResponseEntity.ok().body(userServices.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity <User> getUserById (@PathVariable Long id){
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(userServices.getUserById(id));
    }

    @PutMapping("/users/update")
    public ResponseEntity <User> updateUser (@RequestBody User user) {
        return ResponseEntity.ok().body(userServices.updateUserById(user));
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity <User> deleteUser(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        this.userServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
