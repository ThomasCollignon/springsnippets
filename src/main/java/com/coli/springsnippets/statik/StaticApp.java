package com.coli.springsnippets.statik;

public class StaticApp {

    static String foobar() {
        return FooStaticService.foo() + " " + BarStaticService.bar("baz");
    }
}
