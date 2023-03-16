package br.com.fefproject.FefProjectApplication.service;

import br.com.fefproject.FefProjectApplication.entity.Product;
import br.com.fefproject.FefProjectApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getInfoProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {

        if (product.getAmountProduct() != null &&
                product.getAmountProduct().compareTo(BigDecimal.valueOf(0)) == 1) {
            return productRepository.saveAndFlush(product);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O preço de venda do produto é " +
                            "obrigatório e deve ser maior que 0 (zero)!");
        }
    }

}