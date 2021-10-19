package com.example.jpa_shop.domain.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class ItemRepository(@Autowired val em:EntityManager) {

    fun save(item: Item){
        if(item.id == null){
            em.persist(item);
        }else{
            em.merge(item)
        }
    }

    fun findOne(id:Long): Item? {
        return em.find(Item::class.java,id)
    }

    fun findAll():List<Item>{
        return em.createQuery("select m from Item m", Item::class.java).resultList;
    }


}