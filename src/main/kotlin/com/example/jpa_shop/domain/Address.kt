package com.example.jpa_shop.domain

import javax.persistence.Embeddable

@Embeddable
data class Address(
    var city:String,
    var street:String,
    var zipCode:String
)