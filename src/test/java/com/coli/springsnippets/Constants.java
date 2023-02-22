package com.coli.springsnippets;

import com.coli.springsnippets.spring.Tenant;

public class Constants {

    public static final String TENANT_NAME_MOCK = "LiegeMock";
    public static final Tenant TENANT = initTenant();

    private static Tenant initTenant() {
        Tenant tenant = new Tenant();
        tenant.setName(TENANT_NAME_MOCK);
        return tenant;
    }
}
