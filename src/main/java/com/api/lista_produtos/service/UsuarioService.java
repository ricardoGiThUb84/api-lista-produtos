package com.api.lista_produtos.service;

import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.model.Roles;
import com.api.lista_produtos.model.Usuario;
import com.api.lista_produtos.repository.ProdutoRepository;
import com.api.lista_produtos.repository.RolesRepository;
import com.api.lista_produtos.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolesRepository rolesRepository;


    public Usuario criarUsuario(Usuario usuario){
        Roles roleUser = rolesRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Role não encontrada!"));

        usuario.getRoles().add(roleUser);

       return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorUserName(String username){

        return usuarioRepository.findByUsername(username);

    }


}
