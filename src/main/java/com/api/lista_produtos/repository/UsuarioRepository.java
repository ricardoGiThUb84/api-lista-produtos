package com.api.lista_produtos.repository;

import com.api.lista_produtos.model.Lista;
import com.api.lista_produtos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String nome);
}
