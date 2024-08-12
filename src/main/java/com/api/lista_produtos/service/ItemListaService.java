package com.api.lista_produtos.service;

import com.api.lista_produtos.model.ItemLista;
import com.api.lista_produtos.model.Lista;
import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.repository.ItemListaRepository;
import com.api.lista_produtos.repository.ListaRepository;
import com.api.lista_produtos.repository.ProdutoRepository;
import com.api.lista_produtos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ItemListaService {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ItemListaRepository itemListaRepository;


    @Transactional
    public ItemLista criarItem(Long produtoId, Long listaId, Integer quantidade){

        ItemLista itemLista = new ItemLista();
        Produto produto = produtoService.buscarProdutosPorId(produtoId);

        Lista lista = listaRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        itemLista.inserirProdutoLista(produto, lista, quantidade);
        itemLista.atualizaPreco();

        return itemListaRepository.save(itemLista);

    }

    public void deletarItem(Long id){

        ItemLista itemLista = itemListaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado!"));

        itemListaRepository.delete(itemLista);
    }

    public List<ItemLista> buscarPorIdLista(Long idLista){

       return itemListaRepository.findByListaId(idLista);
    }


}
