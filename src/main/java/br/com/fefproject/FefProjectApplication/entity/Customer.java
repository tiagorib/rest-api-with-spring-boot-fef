package br.com.fefproject.FefProjectApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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

    @Column(name = "first_name_customer", nullable = false, length = 100)
    private String firstNameCustomer;

    @Column(name = "last_name_customer", nullable = false, length = 100)
    private String lastNameCustomer;

    @CPF(message = "CPF inválido")
    @Column(name = "cpf_customer", nullable = false, length = 11, unique = true)
    private String cpfCustomer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date_customer", nullable = false)
    private LocalDate birthDateCustomer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_created_customer", nullable = false, updatable = false)
    private LocalDate dateCreatedCustomer;

    @Column(name = "monthly_income_customer", nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;

    @Column(name = "status_customer", nullable = false)
    private Boolean statusCustomer;

    @Email(message = "E-mail inválido")
    @Column(name = "email_customer", nullable = false, length = 300)
    private String emailCustomer;

    @Column(name = "password_customer", nullable = false, length = 500)
    private String passwordCustomer;

    @PrePersist
    public void prePersist(){
        setDateCreatedCustomer(LocalDate.now());
    }

}