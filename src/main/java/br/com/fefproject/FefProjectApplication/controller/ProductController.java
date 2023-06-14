package br.com.fefproject.FefProjectApplication.controller;

import br.com.fefproject.FefProjectApplication.dto.ProductDTO;
import br.com.fefproject.FefProjectApplication.entity.Product;
import br.com.fefproject.FefProjectApplication.exception.ResponseGenericException;
import br.com.fefproject.FefProjectApplication.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/fef/v1/product")
@CrossOrigin(value = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    @Operation(summary = "Method for list all products from database")
    public ResponseEntity<Object> getInfoProducts() {
        List<Product> result = productService.getInfoProducts();
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @PostMapping(value = "/insert")
    @Operation(summary = "Method for save products in database")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDTO productDTO) {
        Product result = productService.saveProduct(productDTO);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @DeleteMapping(value = "/delete/{idProduct}")
    @Operation(summary = "Method for delete product from database")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long idProduct) {
        HashMap<String, Object> result = productService.deleteProduct(idProduct);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @GetMapping(value = "/findProduct/{idProduct}")
    @Operation(summary = "Method for find products by idProduct in database")
    public ResponseEntity<Object> findProduct(@PathVariable Long idProduct) {
        Product result = productService.findProductById(idProduct);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @PutMapping(value = "/update")
    @Operation(summary = "Method for update customers in database")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        Product result = productService.updateProduct(product);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

}