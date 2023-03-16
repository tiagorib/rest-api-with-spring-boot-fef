package br.com.fefproject.FefProjectApplication.controller;

import br.com.fefproject.FefProjectApplication.entity.Product;
import br.com.fefproject.FefProjectApplication.exception.ResponseGenericException;
import br.com.fefproject.FefProjectApplication.repository.ProductRepository;
import br.com.fefproject.FefProjectApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/fef/v1/product")
@CrossOrigin(value = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getInfoProducts() {
        List<Product> result = productService.getInfoProducts();
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        Product result = productService.saveProduct(product);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

}