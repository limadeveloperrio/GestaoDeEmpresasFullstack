package com.companybruno.demoAPI.Repositories;

import com.companybruno.demoAPI.models.entities.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("from Funcionario f where f.cpf = :param")
    Funcionario findByCPF(@Param("param") String nome);

    @Query("from Funcionario f where f.matricula = :param")
    Funcionario findByMatricula(@Param("param")String cpf);

    @Query("from Funcionario f where f.dataAdmissao between :param1 and :param2")
    List<Funcionario> findByDataAdmissao(@Param("param1")Date dataMin, @Param("param2")Date dataMax);
}
