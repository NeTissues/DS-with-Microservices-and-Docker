package br.edu.anhembi.controller;

import br.edu.anhembi.model.Users;
import br.edu.anhembi.model.UserRegistrationRequest;
import br.edu.anhembi.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void registerUser(UserRegistrationRequest userRegistrationRequest){
        Users users = Users.builder()
                .firstName(userRegistrationRequest.firstName())
                .lastName(userRegistrationRequest.lastName())
                .username(userRegistrationRequest.username())
                .password(userRegistrationRequest.password())
                .email(userRegistrationRequest.email())
                .build();
        userRepository.saveAndFlush(users);
    }
}
