package com.api.lista_produtos.controller;


import com.api.lista_produtos.model.Lista;
import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.service.ListaService;
import com.api.lista_produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lista")
public class ListaController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ListaService listaService;


    @GetMapping
    public List<Lista> buscarListas(){

        return listaService.buscarListas();
    }

    @PostMapping("criar/{username}/{descricao}")
    public Lista criarLista(
            @PathVariable("username") String username,
            @PathVariable("descricao") String descricao){

        return listaService.criarLista(username, descricao);
    }


}
