package br.com.fefproject.FefProjectApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Customer {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long  idCustomer;


    @Column(nullable = false, updatable = false)
   private String dateCreatedCustomer;


    @Column (name = "cpf_customer",unique = true, nullable = false, length = 11)
    private String cpfCustomer;


    @Column (name = "name_customer",  nullable = false, length = 50)
    private String nameCustomer;

    @Column (name = "email_customer",  nullable = false, length = 50)
    private String emailCustomer;

    @Column(name = "password_customer", nullable = false, length = 5)
    private String passwordCustomer;


}
