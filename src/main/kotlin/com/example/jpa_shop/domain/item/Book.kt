package com.example.jpa_shop.domain.item

import javax.persistence.Entity

@Entity
class Book (val author:String,
            val isbn:String,
            name: String,
            price: Int,
            stockQuantity: Int):
    Item(name, price, stockQuantity)