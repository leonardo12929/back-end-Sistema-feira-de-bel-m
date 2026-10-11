package com.canocurto.contausuario.dto;

import java.math.BigDecimal;

import com.canocurto.contausuario.entity.Produto;

public record DetalharProduto(
     long id,
    String nome,
    String descricao,
    BigDecimal preco,
    int estoque
) {
    public DetalharProduto (Produto dados) {
        this(dados.getId(), dados.getNome(), dados.getDescricao(), dados.getPreco(), dados.getEstoque());
    }
    
}
