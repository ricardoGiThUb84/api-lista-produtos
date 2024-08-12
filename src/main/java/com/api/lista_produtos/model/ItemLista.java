package com.api.lista_produtos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class ItemLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_lista", nullable = false)
    private Lista lista;


    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    public void inserirProdutoLista(Produto produto, Lista lista, Integer quantidade){

        this.setLista(lista);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public void atualizaPreco(){

        this.setPreco(
                new BigDecimal(
                        String.valueOf(this.getProduto().getPrecoDesconto()))
                        .multiply(BigDecimal.valueOf(this.getQuantidade()))
        );
    }

}
