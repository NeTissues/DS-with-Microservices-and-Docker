package br.edu.anhembi.controller;

import br.edu.anhembi.model.UserRegistrationRequest;
import br.edu.anhembi.model.Users;
import br.edu.anhembi.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        //todo: log this
        userService.registerUser(userRegistrationRequest);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "userId") Long userId) throws UserNotFoundException {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return ResponseEntity.ok().body(users);
    }

    @PutMapping(path = "{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "userId") Long userId,
                                            @Valid @RequestBody Users userDetails) throws UserNotFoundException {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        users.setFirstName(userDetails.getFirstName());
        users.setLastName(userDetails.getLastName());
        users.setUsername(userDetails.getUsername());
        users.setPassword(userDetails.getPassword());
        users.setEmail(userDetails.getEmail());
        
        final Users updatedUser = userRepository.save(users);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable(value = "userId") Long userId) throws UserNotFoundException {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.delete(users);
    }
}
