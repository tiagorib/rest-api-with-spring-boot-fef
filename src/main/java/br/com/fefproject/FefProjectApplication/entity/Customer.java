package br.com.fefproject.FefProjectApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "first_name_customer", unique = true, nullable = false, length = 300)
    private String firstNameCustomer;

    @Column(name = "last_name_customer", unique = true, nullable = false, length = 300)
    private String lastNameCustomer;
    @Column(name = "cpf_customer", unique = true, nullable = false, length = 300)
    private String cpfCustomer;
    @Column(name = "birthdate_customer", unique = true, nullable = false, length = 300)
    private LocalDate birthdateCustomer;
    @Column(name = "date_created_customer", unique = true, nullable = false, length = 300)
    private LocalDate dateCreatedCustomer;
    @Column(name = "monthly_income_customer", unique = true, nullable = false, length = 300)
    private BigDecimal monthlyIncomeCustomer;
    @Column(name = "status_customer", unique = true, nullable = false, length = 300)
    private Boolean statusCustomer;
    @Column(name = "email_customer", unique = true, nullable = false, length = 300)
    private String emailCustomer;
    @Column(name = "password_customer", unique = true, nullable = false, length = 300)
    private String passwordCustomer;


}