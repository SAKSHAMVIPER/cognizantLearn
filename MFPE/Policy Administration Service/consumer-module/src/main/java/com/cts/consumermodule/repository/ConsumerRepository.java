package com.cts.consumermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.consumermodule.model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
		public boolean existsByPan(String pan);
}

