package com.coli.springsnippets.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Tier1ServiceNoMockitoTest {

    @Autowired
    private Tier1ServiceMock tier1ServiceMock;

    @Test
    void appendFooToLiege() {
        assertEquals("Mock foo", tier1ServiceMock.appendFooToLiege());
    }
}

@Service
class Tier1ServiceMock extends Tier1Service {

    /**
     * If there is no default constructor in Tier1Service, for ex. when using @RequiredArgsConstructor, then the
     * constructors must be rewritten here.
     */
    public Tier1ServiceMock(TenantRepository tenantRepository, Tier2Service tier2Service) {
        super(tenantRepository, tier2Service);
    }

    @Override
    String getTenantName(String tenantId) {
        return "Mock";
    }
}