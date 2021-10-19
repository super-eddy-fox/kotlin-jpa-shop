package com.example.jpa_shop.domain.order

import com.example.jpa_shop.domain.item.Item
import javax.persistence.*

@Entity
class OrderItem(item:Item,orderPrice:Int,count:Int) {

    @Id @GeneratedValue
    @JoinColumn(name = "order_item_id")
    var id:Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    val item: Item = item

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order:Order? = null

    var orderPrice:Int = orderPrice
    var count:Int = count

    companion object{
        fun createOrderItem(item:Item,orderPrice:Int,count:Int):OrderItem {
            val orderItem = OrderItem(item,orderPrice,count)
            item.removeStock(count)
            return orderItem
        }
    }

    fun cancel() {
        item.addStock(count)
    }

    fun getTotalPrice():Int {
        return orderPrice * count
    }

}