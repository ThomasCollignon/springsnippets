package com.coli.springsnippets.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.coli.springsnippets.Constants.TENANT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Using @MockBean is discouraged because it needs the creation of a dedicated Spring context, thus slowing the test.
 */
@SpringBootTest
public class Tier1ServiceMockBeanTest {

    @Autowired
    private Tier1Service tier1Service;

    /**
     * The injection doesn't work if the mocked object is not mandatory, it's the case if the container service
     * (here: in Tier2Service) has an empty constructor.
     * Also, we must ensure that this dependency is injected at context instantiation, for ex with a constructor or
     * with a setter injection.
     */
    @MockBean
    private TenantRepository tenantRepositoryMock;

    @Test
    void callTier2Service() {
        when(tenantRepositoryMock.findFirstByMultipharmaIdEquals(any())).thenReturn(TENANT);
        assertEquals("LiegeMock foo", tier1Service.callTier2Service());
    }
}
