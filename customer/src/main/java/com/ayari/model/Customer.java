package com.ayari.model;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {


    @Id
    @SequenceGenerator(name="customer_id_sequence",
    sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="customer_id_sequence")
    private Integer id ;


    private String email;
    private String firstName;
    private String lastName;


}
