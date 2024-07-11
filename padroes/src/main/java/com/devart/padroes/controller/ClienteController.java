package com.devart.padroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devart.padroes.model.Cliente;
import com.devart.padroes.service.ClienteServices;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	ClienteServices service;

	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos(){
		return ResponseEntity.ok(service.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Cliente> inseir(@RequestBody Cliente c){
		service.inserir(c);
		return ResponseEntity.ok(c);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id, @RequestBody Cliente c){
		service.atualizar(id, c);
		return ResponseEntity.ok(c);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id){
		service.deletar(id);
		return ResponseEntity.ok().build();
	}

}
