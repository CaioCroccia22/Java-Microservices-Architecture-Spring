package br.com.ccroccia.vendas.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ccroccia.vendas.online.domain.Client;
import br.com.ccroccia.vendas.online.repository.IClientRepository;
import jakarta.validation.Valid;

@Service
public class RegisterClient {
	private IClientRepository clientRepository;
	
	@Autowired
	public RegisterClient(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	
	public Client register(@Valid Client c) {
		return clientRepository.insert(c);
	}
	
	public Client update(@Valid Client c) {
		return clientRepository.save(c);
	}
	
	public void remove(String id) {
		this.clientRepository.deleteById(id);
	}
}
