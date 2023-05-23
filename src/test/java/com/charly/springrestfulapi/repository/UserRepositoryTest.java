package com.charly.springrestfulapi.repository;

import com.charly.springrestfulapi.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testInsert() {
        User user = new User();
        user.setUsername("charlybutar2");
        user.setPassword("rahasia");
        user.setName("Charly Butarbutar");

        userRepository.save(user);

        assertNotNull(user.getUsername());
    }

    @Test
    void testUpdate() {
        User user = userRepository.findById("charlybutar").orElse(null);
        assertNotNull(user);

        user.setPassword("newpassword");
        userRepository.save(user);

        user = userRepository.findById("charlybutar").orElse(null);
        assertEquals("newpassword", user.getPassword());

    }
}