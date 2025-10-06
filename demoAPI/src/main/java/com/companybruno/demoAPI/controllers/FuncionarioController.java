package com.companybruno.demoAPI.controllers;

import com.companybruno.demoAPI.models.requests.FuncionarioDTO;
import com.companybruno.demoAPI.models.responses.FuncionarioResponseDTO;
import com.companybruno.demoAPI.services.FuncionarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class FuncionarioController {

    private static final String ENDPOINT = "/api/funcionarios";

    @Autowired
    private FuncionarioService  funcionarioService;


    @PostMapping(ENDPOINT)
    public ResponseEntity<FuncionarioResponseDTO> funcionarioPost(@RequestBody FuncionarioDTO request) {
        return funcionarioService.funcionarioPostServices(request);
    };
}
