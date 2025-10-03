package com.companybruno.demoAPI.models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaDTO {
    private Integer id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
}
