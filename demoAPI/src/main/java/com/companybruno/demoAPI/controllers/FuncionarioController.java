package com.companybruno.demoAPI.controllers;

import com.companybruno.demoAPI.models.requests.FuncionarioDTO;
import com.companybruno.demoAPI.models.responses.EmpresaResponseDTO;
import com.companybruno.demoAPI.models.responses.FuncionarioResponseDTO;
import com.companybruno.demoAPI.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionarioController {

    private static final String ENDPOINT = "/api/funcionarios";

    @Autowired
    private FuncionarioService  funcionarioService;


    @PostMapping(ENDPOINT)
    public ResponseEntity<FuncionarioResponseDTO> funcionarioPost(@RequestBody FuncionarioDTO request) {
        return funcionarioService.funcionarioPostServices(request);
    };

}
