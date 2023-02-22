package com.coli.springsnippets.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static com.coli.springsnippets.Constants.TENANT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class Tier1ServiceSpyRepoTest {

    @InjectMocks
    private Tier1Service tier1Service;

    @Spy
    private TenantRepository tenantRepositorySpy;

    @BeforeEach
    void setUp() {
        openMocks(this); // faster than using @SpringBootTest when full context is not needed
        doReturn(TENANT).when(tenantRepositorySpy).findFirstByMultipharmaIdEquals(any());
    }

    @Test
    void appendFooToLiege() {
        assertEquals("LiegeMock foo", tier1Service.appendFooToLiege());
        verify(tenantRepositorySpy).findFirstByMultipharmaIdEquals(any());
    }
}
