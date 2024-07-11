package com.devart.padroes.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devart.padroes.model.Cliente;
import com.devart.padroes.model.Endereco;
import com.devart.padroes.repository.ClienteRepository;
import com.devart.padroes.repository.EnderecoRepository;
import com.devart.padroes.service.ClienteServices;
import com.devart.padroes.service.ViaCepService;

@Service
public class ClienteServiceImp implements ClienteServices {

	//Singleton
	@Autowired
	ClienteRepository repository;

	@Autowired
	EnderecoRepository endereco;

	@Autowired
	ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente c) {
		salvarClientePorCep(c);
	}

	@Override
	public void atualizar(Long id, Cliente c) {

		Optional<Cliente> cliente =  repository.findById(id);
		if (cliente.isPresent())
			salvarClientePorCep(c);

	}

	@Override
	public void deletar(Long id) {
		repository.deleteById(id);
	}

	private void salvarClientePorCep(Cliente c) {
		String cep = c.getEndereco().getCep();

		Endereco end = endereco.findById(cep).orElseGet(() ->{
			Endereco novo = viaCepService.consultarCep(cep);
			endereco.save(novo);
			return novo;
		});

		c.setEndereco(end);

		repository.save(c);
	}

}
