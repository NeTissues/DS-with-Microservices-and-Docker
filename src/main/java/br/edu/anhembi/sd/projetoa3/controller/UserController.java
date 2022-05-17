package br.edu.anhembi.sd.projetoa3.controller;

import br.edu.anhembi.sd.projetoa3.model.ResourceNotFoundException;
import br.edu.anhembi.sd.projetoa3.model.User;
import br.edu.anhembi.sd.projetoa3.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllusers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found" + userId));
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
                                                   @RequestBody User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        user.setName(userDetails.getName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found" + userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}