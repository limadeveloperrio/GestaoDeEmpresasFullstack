package com.companybruno.demoAPI.services;

import com.companybruno.demoAPI.Repositories.IEmpresaRepository;
import com.companybruno.demoAPI.Repositories.IFuncionarioRepository;
import com.companybruno.demoAPI.models.entities.Empresa;
import com.companybruno.demoAPI.models.entities.Funcionario;
import com.companybruno.demoAPI.interfaces.IFuncionarioServices;
import com.companybruno.demoAPI.mapping.EmpresaMap;
import com.companybruno.demoAPI.mapping.FuncionarioMap;
import com.companybruno.demoAPI.models.requests.FuncionarioDTO;
import com.companybruno.demoAPI.models.responses.FuncionarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService implements IFuncionarioServices {

    @Autowired
    private IFuncionarioRepository funcionarioRepository;

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public ResponseEntity<FuncionarioResponseDTO> funcionarioPostServices(FuncionarioDTO request) {

        FuncionarioResponseDTO  responseDTO = new FuncionarioResponseDTO();
        try {
            if(funcionarioRepository.findByCPF(request.getCpf()) != null){
                responseDTO.setStatusCode(400);
                responseDTO.setMensagem("O CPF " + request.getCpf() + " já está cadastrado");
                return ResponseEntity.badRequest().body(responseDTO);
            }
            if(funcionarioRepository.findByMatricula(request.getMatricula()) != null){
                responseDTO.setStatusCode(400);
                responseDTO.setMensagem("A matrícula  " + request.getMatricula() + " já está cadastrado");
                return ResponseEntity.badRequest().body(responseDTO);
            }
            Optional<Empresa> empresa = empresaRepository.findById(request.getIdEmpresa());
            if (empresa.isEmpty()) {
                responseDTO.setStatusCode(400);
                responseDTO.setMensagem("A empresa não foi localizada");
                return ResponseEntity.badRequest().body(responseDTO);
            }
            Funcionario funcionario = FuncionarioMap.funcionarioToResponse(request, empresa);
            funcionarioRepository.save(funcionario);
            responseDTO.setStatusCode(200);
            responseDTO.setFuncionario(request);
            responseDTO.setEmpresa(EmpresaMap.mapToResponse(empresa.get()));
            responseDTO.setMensagem("Funcionario cadastrado com sucesso");
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
