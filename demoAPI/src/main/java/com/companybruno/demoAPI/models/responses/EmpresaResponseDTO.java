package com.companybruno.demoAPI.models.responses;

import com.companybruno.demoAPI.models.requests.EmpresaDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaResponseDTO {
    private Integer statusCode;
    private String mensagem;
    private EmpresaDTO empresaRequest;
}
