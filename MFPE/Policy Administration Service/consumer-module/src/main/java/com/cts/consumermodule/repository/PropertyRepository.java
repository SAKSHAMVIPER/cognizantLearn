package com.cts.consumermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.consumermodule.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
	public Property findByConsumerId(Long consumerId);
	public boolean existsByBusinessId(Long id);
	public boolean existsByConsumerId(Long id);
}