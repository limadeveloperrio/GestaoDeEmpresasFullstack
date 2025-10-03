package com.companybruno.demoAPI.Repositories;

import com.companybruno.demoAPI.entities.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
