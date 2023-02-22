package com.coli.springsnippets.statik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaticAppServiceTest {

    @Test
    void foobar() {
        assertEquals("foo bar baz", StaticApp.foobar());
    }
}