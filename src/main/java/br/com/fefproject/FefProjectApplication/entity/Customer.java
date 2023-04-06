package br.com.fefproject.FefProjectApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer")
    private Long idCustomer;

    @Column(name = "firstNameCustomer", unique = true, nullable = false, length = 300)
    private String firstNameCustomer;
    @Column(name = "lastNameCustomer", unique = true, nullable = false, length = 300)
    private String lastNameCustomer;

    @CPF
    @Column(name = "cpfCustomer", unique = true, nullable = false, length = 300)
    private String cpfCustomer;

    @Column
    private LocalDate birthdateCustomer;

    @Column
    private LocalDate dateCreatedCustomer;

    @Column(name = "monthlyIncomeCustomer", nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;

    @Column(name = "statusCustomer", nullable = false)
    private Boolean statusCustomer;

    @Email
    @Column(name = "emailCustomer", unique = true, nullable = false, length = 300)
    private String emailCustomer;

    @Column(name = "passwordCustomer", unique = true, nullable = false, length = 300)
        private String passwordCustomer;
}
