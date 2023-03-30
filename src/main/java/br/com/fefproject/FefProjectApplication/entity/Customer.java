package br.com.fefproject.FefProjectApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "first_name_customer", nullable = false)
    private String firstNameCustomer;

    @Column(name = "last_name_customer", nullable = false)
    private String lastNameCustomer;

    @CPF
    @Column(name = "cpf_customer", nullable = false)
    private String cpfCustomer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "birth_date_customer", nullable = false)
    private LocalDate birthdateCustomer;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "date_created_customer", nullable = false, updatable = false)
    private LocalDate dateCreatedCustomer;

    @Column(name = "monthly_income_customer", nullable = false)
    private BigDecimal monthlyIncomeCustomer;

    @Column(name = "status_customer", nullable = false)
    private Boolean statusCustomer;

    @Email
    @Column(name = "email_customer", nullable = false)
    private String emailCustomer;


    @Column(name = "password_customer", nullable = false)
    private String passwordCustomer;

}