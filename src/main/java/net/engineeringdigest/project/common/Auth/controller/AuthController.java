package net.engineeringdigest.project.common.Auth.controller;


import net.engineeringdigest.project.common.Auth.Entity.AuthEntity;
import net.engineeringdigest.project.common.Auth.Service.AuthService;
import net.engineeringdigest.project.common.DTO.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<Response> login(@RequestBody AuthEntity auth) {
        String token = authService.login(auth.getUserName());
        Response res= Response.builder().message(token).success(true).build();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
