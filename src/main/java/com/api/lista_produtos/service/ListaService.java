package com.api.lista_produtos.service;

import com.api.lista_produtos.model.ItemLista;
import com.api.lista_produtos.model.Lista;
import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.model.Usuario;
import com.api.lista_produtos.repository.ListaRepository;
import com.api.lista_produtos.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;


    public List<Lista> buscarListas(){

        return listaRepository.findAll();

    }

    public Lista criarLista(String username, String descricao){

        Usuario usuario = usuarioService.buscarUsuarioPorUserName(username);

        if(usuario == null) throw new RuntimeException("Usuario inexistente");

        Lista lista = new Lista();
        lista.setDescricao(descricao);
        lista.setUsuario(usuario);
        lista.setPreco(BigDecimal.ZERO);

        return listaRepository.save(lista);

    }


    public void deletarLista(Long id){

        Lista lista = listaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada!"));

         listaRepository.delete(lista);

    }





}
