package com.coli.springsnippets.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.coli.springsnippets.Constants.TENANT_NAME_MOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class Tier1ServiceMockServiceTest {

    @InjectMocks
    private Tier1Service tier1Service;

    @Mock
    private Tier2Service tier2ServiceMock;

    @BeforeEach
    void setUp() {
        openMocks(this); // faster than using @SpringBootTest when full context is not needed
        when(tier2ServiceMock.getTenantName(any())).thenReturn(TENANT_NAME_MOCK);
        when(tier2ServiceMock.appendFooToLiege()).thenCallRealMethod();
    }

    @Test
    void appendFooToLiege() {
        assertEquals("LiegeMock foo", tier1Service.callTier2Service());
        verify(tier2ServiceMock).getTenantName(any());
    }
}