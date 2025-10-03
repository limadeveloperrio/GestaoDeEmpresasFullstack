package com.companybruno.demoAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    @Column(length = 100, nullable = false)
    private String nomeFantasia;

    @Column(length = 100, nullable = false, unique = true)
    private String razaoSocial;

    @Column(length = 25, nullable = false, unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios;
}
