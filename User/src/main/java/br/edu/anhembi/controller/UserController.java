package br.edu.anhembi.controller;

import br.edu.anhembi.model.UserRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        //todo: log this
        userService.registerUser(userRegistrationRequest);
    }

    //todo: get mapping

    //todo: put mapping

    //todo: delete mapping
}
