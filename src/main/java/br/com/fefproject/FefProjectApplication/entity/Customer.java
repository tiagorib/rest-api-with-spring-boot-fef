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

    @Column(name = "first_name_customer", nullable = false, length = 300)
    private String firstNameCustomer;

    @Column(name = "last_name_customer", nullable = false, length = 300)
    private String lastNameCustomer;


    @Column(name = "cpf_customer", nullable = false, length = 11, unique = true)
    private String cpfCustomer;

    @Column(name = "birth_date_customer", nullable = false)
    private LocalDate birthdateCustomer;


    @Column(name = "date_created_customer", nullable = false, updatable = false)
    private LocalDate dateCreatedCustomer;

    @Column(name = "monthly_income_customer", nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;

    @Column(name = "status_customer", nullable = false)
    private Boolean statusCustomer;

    @Column(name = "email_customer", unique = true, nullable = false, length = 300)
    private String emailCustomer;

    @Column(name = "password_customer", nullable = false, length = 15)
    private String passwordCustomer;

}