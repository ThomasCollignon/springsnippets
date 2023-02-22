package com.coli.springsnippets.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static com.coli.springsnippets.Constants.TENANT_NAME_MOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class Tier1ServiceSpyServiceTest {

    @InjectMocks
    private Tier1Service tier1Service;

    /**
     * This requires the mocked object to have a no-arg constructor, meaning that no property of this object can be
     * mandatory (=final), so having final properties with {@literal @}RequiredArgsConstructor won't work.
     * It works with @Autowired (field injection or setter injection).
     */
    @Spy
    private Tier2Service tier2ServiceSpy;

    /**
     * In case of a @Spy, when/thenReturn executes the method and just replace the returned value,
     * while doReturn/when doesn't execute the method.<br>
     * See <a href="https://stackoverflow.com/a/29394497/3790512">SO post</a><br>
     * Strangely, in case of mocking a Spring repository, when/thenReturn doesn't perform the DB query.
     */
    @BeforeEach
    void setUp() {
        openMocks(this); // faster than using @SpringBootTest when full context is not needed
        doReturn(TENANT_NAME_MOCK).when(tier2ServiceSpy).getTenantName(any());
    }

    @Test
    void appendFooToLiege() {
        assertEquals("LiegeMock foo", tier1Service.callTier2Service());
        verify(tier2ServiceSpy).getTenantName(any());
    }
}
