package com.canocurto.contausuario.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.canocurto.contausuario.dto.CadastroProduto;
import com.canocurto.contausuario.dto.DetalharProduto;
import com.canocurto.contausuario.entity.Produto;
import com.canocurto.contausuario.repository.ContaUsuarioRepository;
import com.canocurto.contausuario.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
@Service 
@Transactional 
public class ProdutoService {
    
    private ProdutoRepository produtoRepository;
    private ContaUsuarioRepository contaUsuarioRepository;

    public ProdutoService(ProdutoRepository repository, ContaUsuarioRepository contaUsuarioRepository) {
        this.produtoRepository = repository;

        this.contaUsuarioRepository = contaUsuarioRepository;
    }

    public Produto cadastrar(CadastroProduto dados) {
        var produto = new Produto(dados);

        var contaUsuario = contaUsuarioRepository.getReferenceById(dados.contaUsuarioId());
       
        produto.setContausuario(contaUsuario);

        produtoRepository.save(produto);
        return produto;
    }

    public ResponseEntity<List<DetalharProduto>> listar(long usuarioId) {
        
        var produtos = produtoRepository.findByContausuarioId(usuarioId).stream().map(DetalharProduto:: new).toList();

        return ResponseEntity.ok(produtos);

    } 
}
