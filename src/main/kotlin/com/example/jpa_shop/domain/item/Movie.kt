package com.example.jpa_shop.domain.item

import javax.persistence.Entity

@Entity
class Movie(
    val director:String,
    name: String, price: Int, stockQuantity: Int) : Item(name, price, stockQuantity) {
    lateinit var actor:String
}