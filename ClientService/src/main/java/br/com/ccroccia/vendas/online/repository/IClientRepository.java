package br.com.ccroccia.vendas.online.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.ccroccia.vendas.online.domain.Client;

@Repository
public interface IClientRepository extends MongoRepository<Client, String>{
	Optional<Client> findByCpf(Long cpf);
}
