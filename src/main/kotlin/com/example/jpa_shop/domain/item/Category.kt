package com.example.jpa_shop.domain.item

import javax.persistence.*

@Entity
class Category(val name:String) {

    @Id @GeneratedValue
    @Column(name="category_id")
    var id:Long? = null

    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")])
    val items: List<Item> = mutableListOf()


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: Category? = null

    @OneToMany(mappedBy = "parent")
    val child:MutableList<Category> = mutableListOf()

    fun addChildCategory(child: Category){
        this.child.add(child)
        child.parent = this
    }


}