package br.com.ccroccia.vendas.online.ProductService.Service;

import br.com.ccroccia.vendas.online.ProductService.Exceptions.EntityCreationException;
import br.com.ccroccia.vendas.online.ProductService.domain.Product;
import br.com.ccroccia.vendas.online.ProductService.repositoy.IProductRepositoy;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;

import javax.swing.text.html.parser.Entity;

/**
 * In this Layer I will throw the Exception to GlobalExceptionHandler
 * Service -> Throw exception -> GlobalExceptionHadler translate to API error
 * */

public class ProductService {
    private final IProductRepositoy productRepositoy;

    public ProductService(IProductRepositoy productRepositoy){
        this.productRepositoy = productRepositoy;
    }

    //Save method doesnt return Optional because of that I needed to implement try/catch
    // I put DataAccessException exception because the exceptions from JPA inherentence them
    public Product save(Product p){
        try {
            return productRepositoy.save(p);
        } catch(DataAccessException ex ){
            throw new EntityCreationException("Error to create product");
        }

    }
}
