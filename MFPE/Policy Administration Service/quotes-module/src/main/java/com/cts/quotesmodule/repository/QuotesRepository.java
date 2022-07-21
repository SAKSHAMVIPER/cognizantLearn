package com.cts.quotesmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.quotesmodule.model.QuotesMaster;

@Repository
@Transactional
public interface QuotesRepository extends JpaRepository<QuotesMaster, Integer>{

	QuotesMaster findByBusinessValueAndPropertyValueAndPropertyType(Long businessValue, Long propertyValue,
			String propertyType);

}
