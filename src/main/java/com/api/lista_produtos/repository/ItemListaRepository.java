package com.api.lista_produtos.repository;

import com.api.lista_produtos.model.ItemLista;
import com.api.lista_produtos.model.Lista;
import com.api.lista_produtos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemListaRepository extends JpaRepository<ItemLista, Long> {


    List<ItemLista> findByListaId(Long id);
}
