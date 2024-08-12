package com.api.lista_produtos.controller;


import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public List<Produto> listarProdutos(){

        return produtoService.buscarProdutos();
    }

    @GetMapping("buscar/{nome}")
    public List<Produto> buscarProdutoPorDescricao(
            @PathVariable("nome") String nome ){

        return produtoService.buscarProdutosPorNomeEmarca(nome);
    }

//    @GetMapping("buscar/{nome}/{marca}/{quantidade}")
//    public List<Produto> buscarProdutoPorDescricao(
//            @PathVariable("nome") String nome ,
//            @PathVariable("marca") String marca,
//            @PathVariable("quantidade") String quantidade){
//
//        return produtoService.buscarProdutosPorNomeEmarca(nome,marca, quantidade);
//    }
}
