package br.com.fefproject.FefProjectApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "firstname_customer", nullable = false, length = 300)
    private String firstNameCustomer;

    @Column(name = "lastname_customer", nullable = false, length = 300)
    private String lastNameCustomer;

    @Column(name = "cpf_customer", nullable = false, length = 14)
    private String cpfCustomer;

    @Column(name = "birthdate_customer", nullable = false, length = 6)
    private LocalDate birthdateCustomer;

    @CreatedDate
    @Column(name = "datecreated_customer",nullable = false, updatable = false)
    private LocalDate dateCreatedCustomer;

    @Column(name = "monthlyIncome_customer",nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;

    @Column(name = "status_customer",nullable = false)
    private Boolean statusCustomer;

    @Column(name = "email_customer",nullable = false, length = 300)
    private String emailCustomer;

    @Column(name = "password_customer",nullable = false, length = 300)
    private String passwordCustomer;

}