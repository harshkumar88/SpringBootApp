package net.engineeringdigest.project.UserApp.controller;

import net.engineeringdigest.project.common.DTO.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<Response> getAllUsers() {
        Response res= Response.builder().message("Hello World").success(true).build();
        return new  ResponseEntity<>(res, HttpStatus.OK);
    }
}
