package com.companybruno.demoAPI.interfaces;

import com.companybruno.demoAPI.models.requests.FuncionarioDTO;
import com.companybruno.demoAPI.models.responses.EmpresaResponseDTO;
import com.companybruno.demoAPI.models.responses.FuncionarioResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IFuncionarioServices {
    public ResponseEntity<FuncionarioResponseDTO> funcionarioPostServices(FuncionarioDTO  request);
    }
