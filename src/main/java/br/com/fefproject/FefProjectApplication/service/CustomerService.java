package br.com.fefproject.FefProjectApplication.service;

import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.entity.Product;
import br.com.fefproject.FefProjectApplication.repository.CustomerRepository;
import br.com.fefproject.FefProjectApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public Customer saveCustomer(Customer customer) {
        customer.setDateCreatedCustomer(LocalDate.now());
        return customerRepository.saveAndFlush(customer);
    }

    public HashMap<String, Object> deleteCustomer(Long customerId) {
        Optional<Customer> customer =
                Optional.ofNullable(customerRepository.findById(customerId).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado!")));


        customerRepository.delete(customer.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Cliente: " + customer.get().getFirstNameCustomer() + " "
                + customer.get().getLastNameCustomer() + " excluído com sucesso!");
        return result;
    }

    public Optional<Customer> findCustomerById(Long idCustomer) {
        return Optional.ofNullable(customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado!")));
    }

    public Customer updateCustomer(Customer customer) {
            if (findCustomerById(customer.getIdCustomer()) != null) {
                customer.setDateCreatedCustomer(LocalDate.now());
                return customerRepository.saveAndFlush(customer);
            } else {
                return null;
            }
    }

}
