package com.luv2code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;
}