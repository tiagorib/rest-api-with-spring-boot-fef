package br.com.fefproject.FefProjectApplication.service;


import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Customer> getInfoCustomer() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        if (validateCustomer(customer)) {
            customer.setDateCreatedCustomer(LocalDate.now());
            return customerRepository.saveAndFlush(customer);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Deve ter CPF e email");
        }
    }

    public HashMap<String, Object> deleteCustomer(Long customerId) {
        Optional<Customer> customer =
                Optional.ofNullable(customerRepository.findById(customerId).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Produto não encontrado!")));


        customerRepository.delete(customer.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Cliente: " + customer.get().getFirstNameCustomer() + " excluído com sucesso!");
        return result;
    }

    public Optional<Customer> findCustomerById(Long idCustomer) {
        return Optional.ofNullable(customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado!")));
    }

    public Customer updateCustomer(Customer customer) {
        if (validateCustomer(customer)) {
            if (findCustomerById(customer.getIdCustomer()) != null) {
                return customerRepository.saveAndFlush(customer);
            } else {
                return null;
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O CPF e email são obrigatorios");
        }
    }

    public Boolean validateCustomer(Customer customer) {
        if (customer.getEmailCustomer() != null &&
                customer.getCpfCustomer() != null) {
            return true;
        } else {
            return false;
        }
    }


}
