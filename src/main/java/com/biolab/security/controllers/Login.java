package com.biolab.security.controllers;

import com.biolab.security.services.CustomUserDetailsService;
import com.biolab.security.dto.LoginDTO;
import com.biolab.security.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// Nome Correto AUTH
@RestController
public class Login {

//    private final CustomUserDetailsService userDetailsService;
//    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authM;

    public Login(JwtService jwtService, AuthenticationManager authM) {
        this.jwtService = jwtService;
        this.authM = authM;
    }

//    @PostMapping("login")
//    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO dto){
//        try {
//            var u = userDetailsService.loadUserByUsername(dto.getCpf());
//
//            if (!encoder.matches(dto.getSenha(), u.getPassword())){
//                return ResponseEntity.ok("Usuario ou Senha incorreta");
//            }
//
//            return ResponseEntity.ok("Logado com Sucesso!!");
//
//        } catch (UsernameNotFoundException e) {
//
//            return ResponseEntity.ok("Usuario não encontrado. ");
//        }
//    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO dto) {
        authM.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getCpf(),
                        dto.getSenha()
                )
        );
        return ResponseEntity.ok(jwtService.generateToken(dto.getCpf()));
    }


}
