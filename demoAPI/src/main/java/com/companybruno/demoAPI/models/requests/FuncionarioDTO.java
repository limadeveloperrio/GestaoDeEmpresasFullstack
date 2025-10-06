package com.companybruno.demoAPI.models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String matricula;
    private Date dataAdmissao;
    private Integer idEmpresa;
}
