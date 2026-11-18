package com.biolab.security.controllers;

import com.biolab.security.services.UsuarioService;
import com.biolab.security.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    public final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.saveUser(dto));
    }

}
