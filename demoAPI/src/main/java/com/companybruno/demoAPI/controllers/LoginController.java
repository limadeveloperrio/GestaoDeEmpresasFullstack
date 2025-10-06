package com.companybruno.demoAPI.controllers;

import com.companybruno.demoAPI.Repositories.IUsuarioRepository;
import com.companybruno.demoAPI.configuration.authentication.MDSCriptograpy;
import com.companybruno.demoAPI.configuration.authentication.TokenHelp;
import com.companybruno.demoAPI.models.entities.Usuario;
import com.companybruno.demoAPI.models.requests.UsuarioDTO;
import com.companybruno.demoAPI.models.responses.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private static final String ENDPOINT = "/api/login";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private TokenHelp  tokenHelp;

    @PostMapping(ENDPOINT)
    public ResponseEntity<UsuarioResponse> LoginPost(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioResponse response = new UsuarioResponse();
        try {
            Usuario usuario = usuarioRepository.findByEmailAndSenha(usuarioDTO.getEmail(), MDSCriptograpy.encrypt(usuarioDTO.getSenha()));
            if (usuario != null) {
                response.setStatusCode(200);
                response.setMensagem("Usuário autenticado com sucesso!");
                response.setToken(tokenHelp.generateToken(usuario.getEmail()));
                response.setNomeUsuario(usuario.getNome());
                response.setEmail(usuario.getEmail());
                return ResponseEntity.ok().body(response);
            }else {
                response.setStatusCode(401);
                response.setMensagem("Acesso negado!");
                response.setNomeUsuario(usuario.getNome());
                response.setEmail(usuario.getEmail());
                return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
