package com.cts.consumermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.consumermodule.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Long> {
	public Business findByConsumerId(Long consumerId);
	public boolean existsByBusinessName(String businessName);
	public boolean existsByConsumerId(Long consumerId);
}
