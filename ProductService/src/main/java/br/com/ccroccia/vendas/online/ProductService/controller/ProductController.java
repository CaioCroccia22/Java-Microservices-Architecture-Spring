package br.com.ccroccia.vendas.online.ProductService.controller;


import br.com.ccroccia.vendas.online.ProductService.Service.ProductService;
import br.com.ccroccia.vendas.online.ProductService.domain.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

/*
* ResponseEntity - Is Java class that represents the complete response HTTP(header + status+ body)
*
*
*
* */


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> create(@Valid @RequestBody Product product){
        Product savedProduct = productService.save(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedProduct);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>>findById(@PathVariable(value = "id", required = true) String id){
        return ResponseEntity.ok(productService.findById(id));
    }

}
