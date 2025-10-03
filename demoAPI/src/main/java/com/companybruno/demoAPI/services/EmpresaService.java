package com.companybruno.demoAPI.services;

import com.companybruno.demoAPI.Repositories.IEmpresaRepository;
import com.companybruno.demoAPI.entities.Empresa;
import com.companybruno.demoAPI.interfaces.IEmpresaServies;
import com.companybruno.demoAPI.mapping.EmpresaMap;
import com.companybruno.demoAPI.models.requests.EmpresaDTO;
import com.companybruno.demoAPI.models.responses.EmpresaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements IEmpresaServies {

    @Autowired
    IEmpresaRepository empresaRepository;

    @Override
    public ResponseEntity<EmpresaResponse> postServices(EmpresaDTO request) {
        EmpresaResponse response = new EmpresaResponse();
        response.setEmpresaRequest(request);
        try {
            if(empresaRepository.findByRazaoSocial(request.getRazaoSocial())!=null){
                response.setStatusCode(400);
                response.setMensagem("A razão social " + request.getRazaoSocial() + " Já está cadastrada, tente outra");
                return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            if(empresaRepository.findByCNPJ(request.getCnpj())!=null){
                response.setStatusCode(400);
                response.setMensagem("O CNPJ " + request.getCnpj() + " já está  cadastrada, tente outra");
                return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }            
            empresaRepository.save(EmpresaMap.map(request));
            response.setStatusCode(201);
            response.setMensagem("Empresa cadastrada com sucesso.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMensagem(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<EmpresaResponse> putServices(@RequestBody EmpresaDTO request){
        EmpresaResponse response = new EmpresaResponse();

        try {
            Optional<Empresa> result = empresaRepository.findById(request.getId());
            if (result.isPresent()) {
                empresaRepository.save(EmpresaMap.map(request));
                response.setStatusCode(200);
                response.setMensagem("Empresa atualizada com sucesso.");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatusCode(400);
                response.setMensagem("Empresa de ID " + request.getId() + " Ainda não cadastrada.");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMensagem(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    public ResponseEntity<List<EmpresaDTO>> getAll() {
        try {
            List<EmpresaDTO> responses = empresaRepository.findAll()
                    .stream()
                    .map(EmpresaMap::mapToResponse) 
                    .toList();

            return ResponseEntity.ok(responses);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    public ResponseEntity<EmpresaResponse> getById(Integer id){
    	EmpresaResponse response = new EmpresaResponse();
    	
    	try {
			Optional<Empresa> result = empresaRepository.findById(id);
			
			if(result.isPresent()) {
				Empresa empresa = result.get();
				EmpresaDTO dto = EmpresaMap.mapToResponse(empresa);
				response.setStatusCode(200);
				response.setMensagem("Empresa por ID");
				response.setEmpresaRequest(dto);
				
				return ResponseEntity.ok(response);
			}else {
				response.setStatusCode(200);
				response.setMensagem("Empresa não existe.");
				
				return ResponseEntity.ok(response);
			}
			
		} catch (Exception e) {
			response.setMensagem(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    	
    }
    
    public ResponseEntity<EmpresaResponse> detetebyId(Integer id){

        EmpresaResponse response = new EmpresaResponse();

    	try {
			Optional<Empresa> empresa = empresaRepository.findById(id);
    	if(empresa.isPresent()) {
    		empresaRepository.delete(empresa.get());
            response.setMensagem("Empresa removida com sucesso.");
    		return ResponseEntity.ok( response);
    	}else{
            response.setMensagem("Ocorreu um erro ou empresa não existe.");
    		return ResponseEntity.ok( response);
    	}    	
    
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
