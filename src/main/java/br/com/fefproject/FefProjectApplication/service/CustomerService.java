package br.com.fefproject.FefProjectApplication.service;

import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getInfoCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveProduct(Customer customer) {
        if (validateCustomer(customer)) {
            return customerRepository.saveAndFlush(customer);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O preço de venda do produto é " +
                            "obrigatório e deve ser maior que 0 (zero)!");
        }
    }

    public HashMap<String, Object> deleteCustomer(Long idCustomer) {
        Optional<Customer> customer =
                Optional.ofNullable(CustomerRepository.findByid(idCustomer).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "cliente não encontrado!")));


        customerRepository.delete(customer.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Cliente: " + customer.get().getFirstNameCustomer() + " excluído com sucesso!");
        return result;
    }

    public Optional<Customer> findProductById(Long idCustomer) {
        return Optional.ofNullable(customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado!")));
    }

    public Customer updateCustomer(Customer customer) {
        if (validateCustomer(customer)) {
            if (findCustomerById(customer.getIdCustomer())) != null) {
                return customerRepository.saveAndFlush(customer);
            } else {
                return null;
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Os campos não podem ser nulos, verifique");
        }
    }

    public Boolean validateCustomer(Customer customer) {
        if (customer.getCpfCustomer() != null &&
                customer.getCpfCustomer() &&
                customer.getFirstNameCustomer() != null &&
                customer.getLastNameCustomer()) {
            return true;
        } else {
            return false;
        }
    }


}