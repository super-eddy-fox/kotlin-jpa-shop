package com.example.jpa_shop.domain.item

import com.example.jpa_shop.exception.NotEnoughStockException
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
abstract class Item(
    val name: String,
    var price:Int,
    var stockQuantity:Int
) {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    val id: Long? = null

    @ManyToMany(mappedBy = "items")
    val categories:List<Category> = arrayListOf()

    fun addStock(quantity:Int){
        this.stockQuantity = quantity
    }

    fun removeStock(quantity:Int){
        val restStock:Int = this.stockQuantity - quantity
        if(restStock < 0){
            throw NotEnoughStockException("need more stock")
        }
        this.stockQuantity = restStock
    }


}

