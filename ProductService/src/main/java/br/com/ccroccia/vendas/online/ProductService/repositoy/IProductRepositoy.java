package br.com.ccroccia.vendas.online.ProductService.repositoy;

import br.com.ccroccia.vendas.online.ProductService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepositoy extends MongoRepository<Product, String> {
}
