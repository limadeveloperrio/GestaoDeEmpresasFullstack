package com.companybruno.demoAPI.interfaces;

import com.companybruno.demoAPI.models.requests.FuncionarioDTO;
import com.companybruno.demoAPI.models.responses.FuncionarioResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IFuncionarioServices {

    public ResponseEntity<FuncionarioResponseDTO> funcionarioPostServices(FuncionarioDTO  request);
}
