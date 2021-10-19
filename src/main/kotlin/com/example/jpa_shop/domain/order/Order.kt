package com.example.jpa_shop.domain.order

import com.example.jpa_shop.domain.member.Member
import javax.persistence.*

@Entity
class Order {

    @Id @GeneratedValue
    @JoinColumn(name = "order_id")
    var id:Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member:Member? = null

}