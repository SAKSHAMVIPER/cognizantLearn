package com.cts.consumermodule.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.consumermodule.exception.ConsumerBusinessNotFoundException;
import com.cts.consumermodule.model.Business;
import com.cts.consumermodule.model.Consumer;
import com.cts.consumermodule.model.Property;
import com.cts.consumermodule.repository.BusinessRepository;
import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.repository.PropertyRepository;
import com.cts.consumermodule.request.BusinessInputRequest;
import com.cts.consumermodule.request.BusinessUpdateRequest;
import com.cts.consumermodule.request.ConsumerBusinessRequest;
import com.cts.consumermodule.request.UpdateRequest;
import com.cts.consumermodule.response.ConsumerBusinessResponse;
import com.cts.consumermodule.client.AuthClient;
import com.cts.consumermodule.model.AuthResponse;


@Service
public class ConsumerService {
	
	private Logger log = LoggerFactory.getLogger(ConsumerService.class);
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private AuthClient authClient;
	
	public boolean isSessionValid(String token) {
		try {
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;	
	}
	
	public ResponseEntity<?> createConsumerBusiness(ConsumerBusinessRequest inputRequest) {
		
		log.info("Start CreateConsumerBusinessService");
		
		Consumer consumer = new Consumer(inputRequest.getFirstName(),inputRequest.getLastName(),
				inputRequest.getDob(),inputRequest.getEmail(),inputRequest.getPan(),inputRequest.getBusinessName(),
				inputRequest.getValidity(),inputRequest.getAgentName(),inputRequest.getAgentId());
		Consumer consumerSavedObj = consumerRepository.save(consumer);
		
		log.debug("Consumer Obj {}", consumerSavedObj);
		
		Business business = new Business(consumerSavedObj.getId(),inputRequest.getBusinessName(),inputRequest.getBusinessType(),
				inputRequest.getBusinessAge(),inputRequest.getTotalEmployees(),inputRequest.getCapitalInvested(),
				inputRequest.getBusinessTurnover());
		Business businessSavedObj = businessRepository.save(business);
		
		log.debug("Business Obj {}", businessSavedObj);
		log.info("End CreateConsumerBusinessService");
		
		return  ResponseEntity.ok("Created");
		
	}
	
	public ConsumerBusinessResponse viewConsumerBusiness(Long consumerid) throws ConsumerBusinessNotFoundException {
		
		log.info("Start viewConsumerBusinessService");
		
		Optional<Consumer> consumer = Optional.ofNullable(consumerRepository.findById(consumerid).orElseThrow(() -> new ConsumerBusinessNotFoundException()));
		log.debug("Consumer List : {}", consumer);
		Consumer consumers = consumer.get();
		log.debug("Consumer : {}", consumers);
		Business business = businessRepository.findByConsumerId(consumerid);
		log.debug("Business : {}", business);
		
		ConsumerBusinessResponse consumerBusinessDetails = new ConsumerBusinessResponse(consumers.getFirstName(),consumers.getLastName(),
				consumers.getDob(),consumers.getEmail(),consumers.getPan(),consumers.getBusinessName(),
				consumers.getValidity(),consumers.getAgentName(),consumers.getAgentId(),business.getConsumerId(),
				business.getBusinessType(),business.getBusinessAge(),business.getTotalEmployees(),business.getCapitalInvested(),
				business.getBusinessTurnover(),business.getId());
		
		log.debug("ConsumerBusinessDetails : {}", consumerBusinessDetails);
		log.info("End viewConsumerBusinessService");
		
		return consumerBusinessDetails;

	}
	
	public ResponseEntity<?> updateConsumerBusiness(UpdateRequest updateRequest) {
		
		log.info("Start updateConsumerBusinessService");
		Optional<Consumer> consumer = consumerRepository.findById(updateRequest.getConsumerId());
		log.debug("{}",consumer.isPresent());
		Consumer consumer_info = consumer.get();
		
		log.debug("Customer Id info {}", consumer_info);
		
		Business business_info = businessRepository.findByConsumerId(updateRequest.getConsumerId());
		
		log.debug("Business Info Obj {}", business_info);
		
		consumer_info.setFirstName(updateRequest.getFirstName());
		consumer_info.setLastName(updateRequest.getLastName());
		consumer_info.setEmail(updateRequest.getEmail());
		consumer_info.setPan(updateRequest.getPan());
		consumer_info.setDob(updateRequest.getDob());
		consumer_info.setBusinessName(updateRequest.getBusinessName());
		consumer_info.setValidity(updateRequest.getValidity());
		consumer_info.setAgentId(updateRequest.getAgentId());
		consumer_info.setAgentName(updateRequest.getAgentName());
		
		Consumer consumerUpdateObj = consumerRepository.save(consumer_info);
		
		business_info.setBusinessType(updateRequest.getBusinessType());
		business_info.setBusinessAge(updateRequest.getBusinessAge());
		business_info.setBusinessTurnover(updateRequest.getBusinessTurnover());
		business_info.setCapitalInvested(updateRequest.getCapitalInvested());
		business_info.setTotalEmployees(updateRequest.getTotalEmployees());
		
		Business businessUpdateObj = businessRepository.save(business_info);
		log.info("End updateConsumerBusinessService");
		
		return ResponseEntity.ok("success");
		
	}
	
	/*Creating property by accepting the inputRequest as RequestBody*/
	public ResponseEntity<?> createBusinessProperty(BusinessInputRequest inputRequest) {
		
		log.info("Start createBusinessPropertyService");
		
		Long propertyValue = calculatePropertyValue(inputRequest.getCostOftheAsset(),inputRequest.getSalvageValue(),
				inputRequest.getUsefulLifeofAsset());
		
		Property property = new Property(inputRequest.getBusinessId(),inputRequest.getConsumerId(),inputRequest.getBuildingSqFt(),
				inputRequest.getBuildingType(),inputRequest.getBuildingStoreys(),inputRequest.getBuildingAge(),propertyValue,
				inputRequest.getCostOftheAsset(),inputRequest.getSalvageValue(),inputRequest.getUsefulLifeofAsset());
		
		Property propertySavedObj = propertyRepository.save(property);
		
		log.debug("Property Saved {}", propertySavedObj);
		log.info("End createBusinessPropertyService");
	
		return ResponseEntity.ok("success");
		
	}

	/*Updating property by accepting the updateRequest as RequestBody*/
	public ResponseEntity<?> updateBusinessProperty(BusinessUpdateRequest updateRequest) {
		
		log.info("start updateBusinessPropertyService");
		
		Long propertyValue = calculatePropertyValue(updateRequest.getCostOftheAsset(),updateRequest.getSalvageValue(),
				updateRequest.getUsefulLifeofAsset());
		
		Property property = propertyRepository.findByConsumerId(updateRequest.getConsumerId());
		
		property.setBuildingSqFt(updateRequest.getBuildingSqFt());
		property.setBuildingType(updateRequest.getBuildingType());
		property.setBuildingAge(updateRequest.getBuildingAge());
		property.setBuildingStoreys(updateRequest.getBuildingStoreys());
		property.setPropertyValue(propertyValue);
		property.setCostOftheAsset(updateRequest.getCostOftheAsset());
		property.setSalvageValue(updateRequest.getSalvageValue());
		property.setUsefulLifeofAsset(updateRequest.getUsefulLifeofAsset());
		
		Property propertySavedObj = propertyRepository.save(property);
		
		log.debug("Property Updated Obj {} ", propertySavedObj);
		log.info("End updateBusinessPropertyService");
		
		return ResponseEntity.ok("Update Property Success");
		
	}

	/*Method to calculate value of a property*/
	public Long calculatePropertyValue(@NotNull Long costOftheAsset, @NotNull Long salvageValue,
			@NotNull Long usefulLifeofAsset) {
		
		log.info("Start calculatePropertyValue method");

		Double x_ratio = (double) ((costOftheAsset - salvageValue) / usefulLifeofAsset);
		log.debug("x_ratio : {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) (costOftheAsset / usefulLifeofAsset);
		log.debug("x_max : {}", x_max);
		Double x_min = (double) (salvageValue / usefulLifeofAsset);
		log.debug("x_min : {}", x_min);
		Double range_diff = (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double propertyvalue = range_diff * sat;
		log.debug("propertyvalue  : {}", propertyvalue);
		log.info("End calPropertyValue");
		
		log.info("End calculatePropertyValue method");
		
		return (long) Math.abs(Math.round(propertyvalue));

	}
	
	public Boolean checkBusinessEligibility(ConsumerBusinessRequest inputRequest) {
		
		log.info("start checkBusienssEligibility method");
		
		Boolean flag = false;
		
		if(inputRequest.getBusinessAge()>=3 || inputRequest.getTotalEmployees()>=50) {
			flag = true;
			log.debug("Check Value {}", flag);
		}
		
		log.debug("Check Value {}", flag);
		log.info("End checkBusinessEligibility method");
		
		return flag;
		
	}
	
	public Boolean checkPropertyEligibility(BusinessInputRequest inputRequest) {
		
		log.info("Start checkPropertyEligibility method");
		
		Boolean flag = false;
		
		if((inputRequest.getBuildingType().equalsIgnoreCase("own") && inputRequest.getBuildingAge()>=5) ||
				(inputRequest.getBuildingType().equalsIgnoreCase("rent") && inputRequest.getBuildingAge()>=3)) {
			flag = true;
			log.debug("Check Value {}", flag);
		}
		
		log.debug("Check Value {}", flag);
		log.info("End checkPropertyEligibility method");
		
		return flag;
		
	}
	
	
	

}
