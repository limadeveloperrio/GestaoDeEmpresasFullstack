package com.companybruno.demoAPI.controllers;

import com.companybruno.demoAPI.models.requests.EmpresaDTO;
import com.companybruno.demoAPI.models.responses.EmpresaResponse;
import com.companybruno.demoAPI.services.EmpresaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    private static final String ENDPOINT = "/api/empresa";

    @Autowired
    EmpresaService empresaService;

    @PostMapping(ENDPOINT)
    public ResponseEntity<EmpresaResponse> post(@RequestBody EmpresaDTO request){
       return empresaService.postServices(request);
    }

    @PutMapping(ENDPOINT)
    public  ResponseEntity<EmpresaResponse> put(@RequestBody EmpresaDTO request){
        return empresaService.putServices(request);
    }    
    
    @GetMapping(ENDPOINT)
    public ResponseEntity<List<EmpresaDTO>> getAll() {
    	 return empresaService.getAll();
	}
    
    @GetMapping(ENDPOINT + "/{id}")
    public ResponseEntity<EmpresaResponse> getById(@PathVariable("id")Integer id){    	
    	return empresaService.getById(id);
    }

    @DeleteMapping(ENDPOINT + "/{id}")
    public ResponseEntity<EmpresaResponse> deleteById(@PathVariable("id")Integer id){
    	return empresaService.detetebyId(id);
    }
}
