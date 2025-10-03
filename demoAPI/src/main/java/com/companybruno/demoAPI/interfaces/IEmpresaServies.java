package com.companybruno.demoAPI.interfaces;

import com.companybruno.demoAPI.models.requests.EmpresaDTO;
import com.companybruno.demoAPI.models.responses.EmpresaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IEmpresaServies {
    public ResponseEntity<EmpresaResponse> postServices(@RequestBody EmpresaDTO request);
    public ResponseEntity<EmpresaResponse> putServices(@RequestBody EmpresaDTO request);

}
