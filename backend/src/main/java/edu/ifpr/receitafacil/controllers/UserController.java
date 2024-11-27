package edu.ifpr.receitafacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.receitafacil.Enum.UserRole;
import edu.ifpr.receitafacil.configuration.TokenService;
import edu.ifpr.receitafacil.dtos.AuthenticationDTO;
import edu.ifpr.receitafacil.dtos.LoginResponse;
import edu.ifpr.receitafacil.dtos.RegisterDTO;
import edu.ifpr.receitafacil.model.User;
import edu.ifpr.receitafacil.repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO authenticationDTO){
         var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
         var auth = this.authenticationManager.authenticate(usernamePassword);

         var token = tokenService.generateToken((User) auth.getPrincipal());

         return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if(userRepository.findByLogin(registerDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User user = User.builder()
                  .login(registerDTO.login())
                  .senha(registerDTO.password())
                  .roles(UserRole.valueOf(registerDTO.role()))
                  .build();
        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
    
}