package com.companybruno.demoAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncionario;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false, unique = true)
    private String matricula;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private Empresa empresa;
}
