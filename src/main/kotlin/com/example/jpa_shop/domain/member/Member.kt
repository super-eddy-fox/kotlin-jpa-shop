package com.example.jpa_shop.domain.member

import com.example.jpa_shop.domain.Address
import com.example.jpa_shop.domain.order.Order
import javax.persistence.*


@Entity
class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    var id:Long? = null
    var name:String? = null

    @Embedded
    var address: Address? = null

    @OneToMany(mappedBy = "member")
    val orders:MutableList<Order> = mutableListOf()

}