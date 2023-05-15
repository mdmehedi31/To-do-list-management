package com.backend.controller;


import com.backend.request.AuthRequest;
import com.backend.service.implementation.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest){

        /*
        UserDetails userDetails =this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token= this.jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
        */
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                        authRequest.getPassword()));

        if (authentication.isAuthenticated()){
            String token = this.jwtService.generateToken(authRequest.getUserName());
            return ResponseEntity.ok(token);
          //  return jwtService.generateToken(authRequest.getUserName());
        }else{
            throw new UsernameNotFoundException("Invalid user name and password");
        }
    }
}
