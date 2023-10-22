package com.company.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GenericGenerator(name = "cart_id_generator", strategy = "com.company.demo.generator.CartIdGenerator")
    @GeneratedValue(generator = "cart_id_generator")
    @Column(name = "cart_id")
    private String cartId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "cart_date")
    private Date cartDate = new Date();

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name="quantity")
    private Integer quantity;
}
