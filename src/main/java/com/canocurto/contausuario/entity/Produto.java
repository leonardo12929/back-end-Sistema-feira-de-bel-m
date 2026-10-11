package com.canocurto.contausuario.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.canocurto.contausuario.dto.CadastroProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 

@Entity
@Table (name = "produto")
public class Produto {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int estoque;
    @ManyToOne
    @JoinColumn(name = "contausuario_id")
    private ContaUsuario contausuario;

    public Produto(CadastroProduto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.estoque = dados.estoque();    
    }

}
