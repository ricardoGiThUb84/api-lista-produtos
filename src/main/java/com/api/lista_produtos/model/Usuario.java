package com.api.lista_produtos.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Usuario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String username;

    private String senha;

    private String cpf;

    @OneToMany(mappedBy = "usuario")
    private List<Lista> listas;

    @ManyToMany
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private List<Roles> roles = new ArrayList<>();
}
