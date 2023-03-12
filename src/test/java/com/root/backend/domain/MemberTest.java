package com.root.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest
class MemberTest {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(em);
    }
}