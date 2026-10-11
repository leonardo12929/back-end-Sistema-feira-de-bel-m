package com.canocurto.contausuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canocurto.contausuario.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByContausuarioId(Long id);
}
