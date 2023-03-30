package br.com.fefproject.FefProjectApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;
    @Column(name="first_name_customer", nullable = false, length = 300)
    private String firstNameCustomer;
    @Column(name="last_name_customer", nullable = false, length = 300)
    private String lastNameCustomer;
    @Column(name="cpf_customer", nullable = false, length = 11)
    private String cpfCustomer;
    @Column(name = "birthdate_customer", nullable = false)
    private LocalDate birthdateCustomer;
    @Column(name="date_created_customer", nullable = false)
    private LocalDate dateCreatedCustomer;
    @Column(name="month_icome_customer", nullable = false, precision =10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;
    @Column(name="status_customer", nullable = false)
    private Boolean statusCustomer;
    @Column(name="email_customer", nullable = false, length = 100)
    private String emailCustomer;
    @Column(name="password_customer", nullable = false, length = 40)
    private String passwordCustomer;

}