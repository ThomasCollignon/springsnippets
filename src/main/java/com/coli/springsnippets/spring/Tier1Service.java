package com.coli.springsnippets.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Tier1Service {

    // @Autowired can replace @RequiredArgsConstructor, without the 'final' modifier
    private final TenantRepository tenantRepository;
    private final Tier2Service tier2Service;

    static String foo() {
        return "Tier1 foo";
    }

    String appendFooToLiege() {
        return getTenantName("797") + " foo";
    }

    String getTenantName(String tenantId) {
        return tenantRepository.findFirstByMultipharmaIdEquals(tenantId).getName();
    }

    String callTier2Service() {
        return tier2Service.appendFooToLiege();
    }
}
