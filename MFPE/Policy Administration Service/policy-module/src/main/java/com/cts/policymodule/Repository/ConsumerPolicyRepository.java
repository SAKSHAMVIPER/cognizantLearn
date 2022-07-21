package com.cts.policymodule.Repository;

import com.cts.policymodule.Entities.ConsumerPolicy;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@DynamicUpdate
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy, Long> {
    ConsumerPolicy findByConsumerId(long consumerId);

    ConsumerPolicy findByConsumerIdAndBusinessId(Long consumerId, Long businessId);

    boolean existsByConsumerId(Long consumerId);

	boolean existsByBusinessId(long businessId);
	
	boolean existsByPolicyId(String policyId);
}
