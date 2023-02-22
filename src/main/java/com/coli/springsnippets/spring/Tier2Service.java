package com.coli.springsnippets.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tier2Service {

    // Can't be final if we want to spy Tier2Service, see Tier1ServiceSpyServiceTest
    private TenantRepository tenantRepository;

    @Autowired
    public void setTenantRepository(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    String appendFooToLiege() {
        return getTenantName("797") + " foo";
    }

    String getTenantName(String tenantId) {
        return tenantRepository.findFirstByMultipharmaIdEquals(tenantId).getName();
    }
}
