package com.example.jpa_shop.domain.member

import com.example.jpa_shop.domain.member.QMember.member
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class MemberRepository(@Autowired private val em:EntityManager,
                       @Autowired private val jpaQueryFactory:JPAQueryFactory) {

    fun save(member:Member): Long? {
        em.persist(member)
        return member.id
    }

    fun findOne(id:Long) : Member? {
        return em.find(Member::class.java,id)
    }

    fun findAll() : List<Member> {
        return jpaQueryFactory.selectFrom(member).fetch()
    }

    fun findByName(name:String):List<Member> {
        return jpaQueryFactory.selectFrom(member).where(member.name.eq(name)).fetch()
    }

}