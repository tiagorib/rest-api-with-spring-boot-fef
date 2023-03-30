package br.com.fefproject.FefProjectApplication.service;

import br.com.fefproject.FefProjectApplication.entity.Customer;
import br.com.fefproject.FefProjectApplication.entity.Product;
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
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        if (validateCustomer(customer)) {
            customer.setDateCreatedCustomer(LocalDate.now());
            return customerRepository.saveAndFlush(customer);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O salário do cliente é " +
                            "obrigatório e deve ser maior que 0 (zero)!");
        }
    }

    public HashMap<String, Object> deleteCustomer(Long customerId) {
        Optional<Customer> customer =
                Optional.ofNullable(customerRepository.findById(customerId).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado!")));


        customerRepository.delete(customer.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Cliente: " + customer.get().getFirstNameCustomer()+" "+customer.get().getLastNameCustomer() + " excluído com sucesso!");
        return result;
    }

    public Optional<Customer> findCustomerById(Long idCustomer) {
        return Optional.ofNullable(customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado!")));
    }

    public Customer updateCustomer(Customer customer) {
        if (validateCustomer(customer)) {
            if (findCustomerById(customer.getIdCustomer()) != null) {
                LocalDate data = findCustomerById(customer.getIdCustomer()).get().getDateCreatedCustomer();
                customer.setDateCreatedCustomer(data);
                return customerRepository.saveAndFlush(customer);
            } else {
                return null;
            }
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O salário do cliente é " +
                            "obrigatório e deve ser maior que 0 (zero)!");
        }
    }

    public Boolean validateCustomer(Customer customer) {
        if (customer.getMonthlyIncomeCustomer() != null &&
                customer.getMonthlyIncomeCustomer().compareTo(BigDecimal.valueOf(0)) == 1){
            return true;
        } else {
            return false;
        }
    }
}
