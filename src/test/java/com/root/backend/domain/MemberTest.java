package com.root.backend.domain;

import com.root.backend.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class MemberTest {

    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(false)
    void create_member_and_find() {
        final Member member = new Member("tester", "testpw", "test@123");
        memberRepository.save(member);
        assertNotNull(member.getId());
        em.clear();

        final Member findMember = memberRepository.findById(member.getId()).orElseThrow();
        assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember.getPassword()).isEqualTo(member.getPassword());
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getCreatedAt()).isEqualTo(member.getCreatedAt());
        assertThat(findMember.getModifiedAt()).isEqualTo(member.getModifiedAt());
    }
}
