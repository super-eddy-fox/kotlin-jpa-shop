package com.example.jpa_shop.domain.item

import javax.persistence.Entity

@Entity
class Album(
    val artist:String,
    name: String,
    price:Int,
    stockQuantity:Int) : Item(name,price,stockQuantity) {

    lateinit var etc:String

}