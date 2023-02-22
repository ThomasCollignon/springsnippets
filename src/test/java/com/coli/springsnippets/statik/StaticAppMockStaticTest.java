package com.coli.springsnippets.statik;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

/**
 * This requires mockito-inline, see the file in /mockito-extensions
 */
public class StaticAppMockStaticTest {

    @Test
    void mockingStaticMethods() {
        try (MockedStatic<BarStaticService> barStaticServiceMock = mockStatic(BarStaticService.class);
             MockedStatic<FooStaticService> fooStaticServiceMock = mockStatic(FooStaticService.class)) {
            barStaticServiceMock.when(() -> BarStaticService.bar(any())) // with args
                                .thenReturn("mocked bar");
            fooStaticServiceMock.when(FooStaticService::foo) // without arg
                                .thenReturn("mocked foo");
            assertEquals("mocked foo mocked bar", StaticApp.foobar()); // The caller can be non-static
        }
    }
}
