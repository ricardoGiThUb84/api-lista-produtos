package com.api.lista_produtos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Roles {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios = new ArrayList<>();
}
