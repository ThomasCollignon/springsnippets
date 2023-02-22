package com.coli.springsnippets.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * {@literal @}Autowired on properties (= field injection) can replace the constructor (constructor injection) or the
 * use of {@literal @}RequiredArgsConstructor, without the 'final' modifier, which would break immutability.
 */
@Service
@RequiredArgsConstructor
public class Tier1Service {

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
