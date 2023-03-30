package br.com.fefproject.FefProjectApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String cpfCustomer;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdateCustomer;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreatedCustomer;
    @Column(name = "monthly_income_customer", nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;
    @Column(name = "status_customer", nullable = false, length = 300)
    private Boolean statusCustomer;
    private String emailCustomer;
    private String passwordCustomer;


}