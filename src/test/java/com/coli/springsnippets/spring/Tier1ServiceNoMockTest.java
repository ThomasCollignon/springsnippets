package com.coli.springsnippets.spring;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Here no mock is used for the repository, we need the full Spring context.
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // or @Autowired on the properties
class Tier1ServiceNoMockTest {

    private final Tier1Service tier1Service;

    @Test
    void getTenantName() {
        assertEquals("Liege", tier1Service.getTenantName("797"));
    }
}