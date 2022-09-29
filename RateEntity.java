package com.example.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rateId;

    @Column(name = "service")
    private String service;

    @Column(name = "food")
    private String food;

    @Column(name = "feedBack")
    private  String feeBack;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerEntity;

}
