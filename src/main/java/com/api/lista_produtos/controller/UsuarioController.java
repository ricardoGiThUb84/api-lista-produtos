package com.api.lista_produtos.controller;


import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.model.Usuario;
import com.api.lista_produtos.service.ProdutoService;
import com.api.lista_produtos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("buscar/(username)")
    public Usuario buscarUsuario(
            @PathVariable("nome") String nome ){

        return usuarioService.buscarUsuarioPorUserName(nome);
    }


    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){

        return usuarioService.criarUsuario(usuario);
    }




}
