package com.cts.policymodule.Repository;

import com.cts.policymodule.Entities.PolicyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster, Long> {
	
    PolicyMaster findByPolicyId(String policyId);

    boolean existsByPolicyId(String policyId);
}
