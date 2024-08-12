package com.api.lista_produtos.controller;


import com.api.lista_produtos.model.ItemLista;
import com.api.lista_produtos.model.Usuario;
import com.api.lista_produtos.service.ItemListaService;
import com.api.lista_produtos.service.UsuarioService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemListaService itemListaService;


    @GetMapping("buscar/{idLista}")
    public List<ItemLista> buscarItens(
            @PathVariable("idLista") Long idLista ){

        return itemListaService.buscarPorIdLista(idLista);
    }

    @PostMapping("criar/{idProduto}/{idLista}/{quantidade}")
    public ItemLista adicionarItemLista(
            @PathVariable("idProduto") Long idProduto,
            @PathVariable("idLista") Long idLista,
            @PathVariable("quantidade") Integer quantidade){

        return itemListaService.criarItem(idProduto,idLista,quantidade );
    }







}
