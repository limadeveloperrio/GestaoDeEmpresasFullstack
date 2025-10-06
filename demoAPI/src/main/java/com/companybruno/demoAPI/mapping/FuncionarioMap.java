package com.companybruno.demoAPI.mapping;

import com.companybruno.demoAPI.models.entities.Empresa;
import com.companybruno.demoAPI.models.entities.Funcionario;
import com.companybruno.demoAPI.models.requests.FuncionarioDTO;

import java.util.Optional;

public class FuncionarioMap {

    public static Funcionario funcionarioToResponse(FuncionarioDTO request, Optional<Empresa> empresa) {
        Funcionario  funcionario = new Funcionario();
        funcionario.setMatricula(request.getMatricula());
        funcionario.setCpf(request.getCpf());
        funcionario.setNome(request.getNome());
        funcionario.setDataAdmissao(request.getDataAdmissao());
        funcionario.setEmpresa(empresa.get());
        return funcionario;
    }
}
