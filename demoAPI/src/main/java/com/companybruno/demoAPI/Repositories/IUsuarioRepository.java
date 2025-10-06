package com.companybruno.demoAPI.Repositories;

import com.companybruno.demoAPI.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("from Usuario u where u.email = :param")
    Usuario findByEmail(@Param("param") String email);

    @Query("from Usuario u where u.email = :param1 and u.senha = :param2 ")
    Usuario findByEmailAndSenha(@Param("param1") String email, @Param("param2") String senha);
}
