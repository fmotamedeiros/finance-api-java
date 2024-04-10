package br.com.cpsoftware.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.userdetails.User;

import br.com.cpsoftware.finance.model.LoginRequest;
import br.com.cpsoftware.finance.model.LoginResponse;
import br.com.cpsoftware.finance.security.CustomUserDetailsService;
import br.com.cpsoftware.finance.security.JwtUtil;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authenticationRequest = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);

        if (authenticationResponse != null && authenticationResponse.isAuthenticated()) {
            User loggedUser = (User) authenticationResponse.getPrincipal();
            LoginResponse loginResponse = new LoginResponse(jwtUtil.generateToken(loggedUser.getUsername()),
                    loggedUser.getUsername());
            return ResponseEntity.ok(loginResponse);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
    }

}
