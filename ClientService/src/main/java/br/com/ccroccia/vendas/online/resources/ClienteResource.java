package br.com.ccroccia.vendas.online.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ccroccia.vendas.online.domain.Client;
import br.com.ccroccia.vendas.online.controller.FindClient;
import br.com.ccroccia.vendas.online.controller.RegisterClient;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/client")
public class ClienteResource {
	
	private FindClient findClient;
	private RegisterClient registerClient;
	
	@Autowired
	public ClienteResource(FindClient findClient,
			RegisterClient registerClient) {
		this.findClient = findClient;
		this.registerClient = registerClient;
	}
	
	
	@GetMapping 
	public ResponseEntity<Page<Client>> find(Pageable pageable){
		return ResponseEntity.ok(findClient.Find(pageable));
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Find client by id")
	public ResponseEntity<Client> findById(@PathVariable(value = "id", required = true)String id){
		return ResponseEntity.ok(findClient.findById(id));
	}
	
	@GetMapping(value = "active/{id}")
	public ResponseEntity<Boolean> isActive(@PathVariable(value = "id", required = true) String id){
		return ResponseEntity.ok(findClient.isActive(id));
	}
	
	@PostMapping
	public ResponseEntity<Client> register(@RequestBody @Valid Client client){
		return ResponseEntity.ok(registerClient.register(client));
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	@Operation(summary = "Find client by cpf")
	public ResponseEntity<Client> findByCpf(@PathVariable(value = "cpf", required = true) Long cpf){
		return ResponseEntity.ok(findClient.findByCpf(cpf));
	}
	
	@PutMapping
	@Operation(summary = "Update client")
	public ResponseEntity<Client> update(@RequestBody @Valid Client client){
		return ResponseEntity.ok(registerClient.update(client));
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "remove client by id")
	public ResponseEntity<String> remove(@PathVariable(value = "id") String id){
		registerClient.remove(id);
		return ResponseEntity.ok("Sucess to remove client");
	}
	
	
}
