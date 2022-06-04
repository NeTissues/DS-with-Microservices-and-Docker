package br.edu.anhembi.user;

import br.edu.anhembi.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "localhost:8080")
public interface UserClient {

    @GetMapping ("api/v1/user/{userId}")
    ResponseEntity<Users> getUserById(@PathVariable("userId")  Long userId);
}