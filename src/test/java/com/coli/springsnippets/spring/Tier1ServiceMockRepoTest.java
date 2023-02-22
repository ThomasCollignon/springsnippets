package com.coli.springsnippets.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static com.coli.springsnippets.Constants.TENANT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class Tier1ServiceMockRepoTest {

    @InjectMocks
    private Tier1Service tier1Service;

    @Mock
    private TenantRepository tenantRepositoryMock;

    @BeforeEach
    void setUp() {
        openMocks(this); // faster than using @SpringBootTest when full context is not needed
        Mockito.when(tenantRepositoryMock.findFirstByMultipharmaIdEquals(any()))
               .thenReturn(TENANT);
    }

    @Test
    void appendFooToLiege() {
        assertEquals("LiegeMock foo", tier1Service.appendFooToLiege());
        verify(tenantRepositoryMock).findFirstByMultipharmaIdEquals(any());
    }
}