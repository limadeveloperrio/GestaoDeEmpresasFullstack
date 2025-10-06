package com.companybruno.demoAPI.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private String email;
    private String token;
    private String nomeUsuario;
    private String mensagem;
    private Integer statusCode;
}
