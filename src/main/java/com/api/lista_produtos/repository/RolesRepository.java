package com.api.lista_produtos.repository;

import com.api.lista_produtos.model.ItemLista;
import com.api.lista_produtos.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
