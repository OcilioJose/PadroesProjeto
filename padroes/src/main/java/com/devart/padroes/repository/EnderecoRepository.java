package com.devart.padroes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devart.padroes.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
