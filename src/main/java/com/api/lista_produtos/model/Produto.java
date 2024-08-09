package com.api.lista_produtos.model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.management.Query;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String condicao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "preco_desconto", nullable = false)
    private BigDecimal precoDesconto;

    @Column(nullable = false)
    private BigDecimal porcentagem;


}
