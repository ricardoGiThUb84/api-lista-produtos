package com.api.lista_produtos.repository;

import com.api.lista_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query("FROM Produto p WHERE p.descricao LIKE %:nome%" )
    List<Produto> buscarProdutosPorNome(@Param("nome")String nome);

//    @Query("FROM Produto p WHERE " +
//            "p.descricao LIKE %:nome% " +
//            "AND p.descricao LIKE %:marca% " +
//            "AND p.descricao LIKE %:quantidade%" )
//    List<Produto> buscarProdutosPorNome_Marca_Quantidade(@Param("nome")String nome,
//                                                         @Param("marca") String marca,
//                                                         @Param("quantidade") String quantidade);


}
