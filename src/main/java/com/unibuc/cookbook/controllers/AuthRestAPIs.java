package com.unibuc.cookbook.controllers;

import com.unibuc.cookbook.dto.Utilizator;
import com.unibuc.cookbook.repositories.UtilizatorRepository;
import com.unibuc.cookbook.security.jwt.JwtProvider;
import com.unibuc.cookbook.security.request.LoginForm;
import com.unibuc.cookbook.security.request.SignUpForm;
import com.unibuc.cookbook.security.response.JwtResponse;
import com.unibuc.cookbook.security.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNumeUtilizator(), loginRequest.getParola()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (utilizatorRepository.existsByNumeUtilizator(signUpRequest.getNumeUtilizator())) {
            return new ResponseEntity<>(new ResponseMessage("Nume utilizator existent in baza de date!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (utilizatorRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email existent in baza de date!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Utilizator utilizator = new Utilizator(signUpRequest.getNume(), signUpRequest.getPrenume(), signUpRequest.getNumeUtilizator(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getParola()));


        utilizatorRepository.save(utilizator);

        return new ResponseEntity<>(new ResponseMessage("Înregistrare finalizată cu succes!"), HttpStatus.OK);
    }

    @GetMapping("/utilizator")
    public Utilizator afiseazaUtilizator(@RequestParam(name = "numeUtilizator") String numeUtilizator){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        return utilizator;
    }
}