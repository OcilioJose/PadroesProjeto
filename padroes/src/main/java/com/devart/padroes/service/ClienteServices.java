package com.devart.padroes.service;

import com.devart.padroes.model.Cliente;

public interface ClienteServices {

	Iterable <Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente c);

	void atualizar(Long id, Cliente c);

	void deletar(Long id);
}
