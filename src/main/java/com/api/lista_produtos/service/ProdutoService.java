package com.api.lista_produtos.service;

import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public void salvarLote(List<Produto> prdutos){

        int grupo = 50;

        if(prdutos.size() >= grupo){

            IntStream.range(0,(prdutos.size() / grupo))
                    .forEach(count ->
                            produtoRepository.saveAll(
                                    prdutos.subList(
                                            count * grupo,
                                            Integer.sum(count, 1) * grupo))
                    );

            Integer leftOver = prdutos.size() % grupo;

            if(leftOver > 0){

                produtoRepository.saveAll(
                        prdutos.subList(
                                prdutos.size() - leftOver,
                                (prdutos.size())
                        )
                );

            }

        }else{

            produtoRepository.saveAll(prdutos);

        }




    }


}
