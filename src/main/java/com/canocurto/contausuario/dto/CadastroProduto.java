package com.canocurto.contausuario.dto;

import java.math.BigDecimal;

public record CadastroProduto(
    long contaUsuarioId,
    String nome,
    String descricao,
    BigDecimal preco,
    int estoque
) {
    
}
