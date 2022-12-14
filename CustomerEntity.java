package com.example.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @JsonIgnore
    @OneToMany(mappedBy = "customerEntity",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RateEntity> rateEntities;

    @JsonIgnore
    @OneToMany(mappedBy = "customerEntity", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntities;

    @Column(name = "name")
    private String name;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "age")
    private String age;


    @Column(name = "address")
    private String address;

}
