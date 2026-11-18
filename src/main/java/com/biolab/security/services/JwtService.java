package com.biolab.security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET = "temqueter32caracteresparafuncionarfacadireito";

    public  String generateToken(String cpf){
        return Jwts.builder()
                .setSubject(cpf)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    public String getCpf(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
