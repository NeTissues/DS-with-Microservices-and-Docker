package br.edu.anhembi.controller;

import br.edu.anhembi.model.User;
import br.edu.anhembi.model.UserRegistrationRequest;
import br.edu.anhembi.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void registerUser(UserRegistrationRequest userRegistrationRequest){
        User user = User.builder()
                .firstName(userRegistrationRequest.firstName())
                .secondName(userRegistrationRequest.secondName())
                .username(userRegistrationRequest.username())
                .password(userRegistrationRequest.password())
                .email(userRegistrationRequest.email())
                .build();
        userRepository.saveAndFlush(user);
    }
}
