package br.com.ccroccia.vendas.online.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import br.com.ccroccia.vendas.online.domain.Client;
import br.com.ccroccia.vendas.online.exception.EntityNotFoundException;
import br.com.ccroccia.vendas.online.repository.IClientRepository;

@Service
public class FindClient {
	private IClientRepository clientRepository;
	
	@Autowired
	public FindClient(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Page<Client> Find(Pageable pageable){
		return clientRepository.findAll(pageable);
	}
	
	public Client findById(String id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Client.class, id));
	}
	
	public Boolean isActive(String id) {
		return clientRepository.existsById(id);
		
	}
	
	public Client findByCpf(Long cpf) {
		return clientRepository.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException(Client.class, String.valueOf(cpf)));
	}
	
	
	
	
	
}
