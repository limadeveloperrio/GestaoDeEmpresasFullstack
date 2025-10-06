package com.companybruno.demoAPI.models.responses;

import com.companybruno.demoAPI.models.requests.EmpresaDTO;
import com.companybruno.demoAPI.models.requests.FuncionarioDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioResponseDTO {
    private Integer statusCode;
    private String mensagem;
    private FuncionarioDTO funcionario;
    private EmpresaDTO empresa;
}
