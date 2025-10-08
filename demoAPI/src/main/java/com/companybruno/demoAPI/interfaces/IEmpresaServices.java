package com.companybruno.demoAPI.interfaces;

import com.companybruno.demoAPI.models.requests.EmpresaDTO;
import com.companybruno.demoAPI.models.responses.EmpresaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IEmpresaServices {
    public ResponseEntity<EmpresaResponseDTO> postServices(@RequestBody EmpresaDTO request);
    public ResponseEntity<EmpresaResponseDTO> putServices(@RequestBody EmpresaDTO request);
    public ResponseEntity<EmpresaResponseDTO> DeleteServices(@PathVariable("id") Integer id);

}
