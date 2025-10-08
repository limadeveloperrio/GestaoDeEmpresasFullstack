package com.companybruno.demoAPI.Repositories;

import com.companybruno.demoAPI.models.entities.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Query("from Empresa e where e.razaoSocial = :param")
    Empresa findByRazaoSocial(@Param("param") String razaoSocial);

    @Query("from Empresa e where e.cnpj = :param")
    Empresa findByCNPJ(@Param(("param")) String cnpj);

    @Query("select count(f) from Funcionario f where f.empresa.idEmpresa = :param")
    Integer countFuncionarioId(@Param("param") Integer id);
}
