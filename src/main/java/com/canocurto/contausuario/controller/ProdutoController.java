package com.canocurto.contausuario.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.canocurto.contausuario.dto.CadastroProduto;
import com.canocurto.contausuario.dto.DetalharProduto;
import com.canocurto.contausuario.service.ProdutoService;

@RestController 
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @PostMapping("/cadastrar") 
    public ResponseEntity<?> cadastrar(@RequestBody CadastroProduto dados,UriComponentsBuilder uBuilder ) {
       try {
            var produto = produtoService.cadastrar(dados);

            var uri = uBuilder.path("/produto/listar/{id}").buildAndExpand(produto.getId()).toUri();

            return ResponseEntity.created(uri).body(new DetalharProduto(produto));
       } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(Map.of("Message: ", e.getMessage()));
       }
    }

    @GetMapping("/listar/{usuarioId}")
    public ResponseEntity<List<DetalharProduto>> listar(@PathVariable long usuarioId) {
      
        
        return produtoService.listar(usuarioId);        
    }
    
}
