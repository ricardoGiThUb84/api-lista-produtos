package com.api.lista_produtos.amqp;


import com.api.lista_produtos.model.Produto;
import com.api.lista_produtos.service.ProdutoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaPromoListener {

    private final String NOME_FILA_PROMO_ATACADAO = "lista.promo.atacadao";

    @Autowired
    private ProdutoService produtoService;


    @RabbitListener(queues = NOME_FILA_PROMO_ATACADAO)
    public void recieveMessage(List<Produto> produtos){

        System.out.println(String.format("Message recieved: %s", produtos));

        produtoService.salvarLote(produtos);

    }
}
