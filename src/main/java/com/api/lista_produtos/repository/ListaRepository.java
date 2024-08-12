package com.api.lista_produtos.repository;

import com.api.lista_produtos.model.Lista;
import com.api.lista_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {
}
