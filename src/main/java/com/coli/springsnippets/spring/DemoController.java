package com.coli.springsnippets.spring;

import com.coli.springsnippets.statik.FooStaticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final Tier1Service tier1Service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/static-foo")
    public String staticFoo() {
        return FooStaticService.foo() + " " + Tier1Service.foo();
    }

    @GetMapping("/tenant/{tenantId}/name") // 797 is available
    public String staticFoo(@PathVariable String tenantId) {
        return tier1Service.getTenantName(tenantId);
    }
}
