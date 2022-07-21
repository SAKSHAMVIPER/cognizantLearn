package com.cts.consumermodule.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumermodule.exception.ConsumerBusinessNotFoundException;
import com.cts.consumermodule.model.Property;
import com.cts.consumermodule.repository.BusinessRepository;
import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.repository.PropertyRepository;
import com.cts.consumermodule.request.BusinessInputRequest;
import com.cts.consumermodule.request.BusinessUpdateRequest;
import com.cts.consumermodule.request.ConsumerBusinessRequest;
import com.cts.consumermodule.request.UpdateRequest;
import com.cts.consumermodule.response.ConsumerBusinessResponse;
import com.cts.consumermodule.service.ConsumerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ConsumerController {

	private Logger log = LoggerFactory.getLogger(ConsumerController.class);
	
	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@PostMapping("/createConsumerBusiness")
	public ResponseEntity<?> createConsumerBusiness(@RequestHeader String Authorization,
			@RequestBody ConsumerBusinessRequest inputRequest) {
		
		log.info("Start createConsumerBusinessController");
		
		if (consumerService.isSessionValid(Authorization)) {
			if (businessRepository.existsByBusinessName(inputRequest.getBusinessName())) {
				return ResponseEntity.badRequest().body("Business already exists");
			}
			if (consumerRepository.existsByPan(inputRequest.getPan())) {
				return ResponseEntity.badRequest().body("Consumer already exists");
			}
			if(!consumerService.checkBusinessEligibility(inputRequest)) {
				return  ResponseEntity.badRequest().body("Sorry! You are not eligible");
			}
			return consumerService.createConsumerBusiness(inputRequest);
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/viewConsumerBusiness")
	public ResponseEntity<?> viewConsumerBusinessResponse(@RequestHeader String Authorization,
			@RequestParam Long consumerId) throws ConsumerBusinessNotFoundException{
		if (consumerService.isSessionValid(Authorization)) {
			if (!consumerRepository.existsById(consumerId)) {
				throw new ConsumerBusinessNotFoundException();
			}
			if (!businessRepository.existsByConsumerId(consumerId)) {
				return ResponseEntity.badRequest().body("No Business Found!!");
			}
			ConsumerBusinessResponse consumerBusinessDetails = consumerService.viewConsumerBusiness(consumerId);

			return ResponseEntity.ok(consumerBusinessDetails);
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/viewConsumerProperty")
	public ResponseEntity<?> viewConsumerProperty(@RequestHeader String Authorization,
			@Valid @RequestParam Long consumerId, @RequestParam Long propertyId) {
		if (consumerService.isSessionValid(Authorization)) {
			if (!propertyRepository.existsById(propertyId)) {
				return ResponseEntity.badRequest().body("No Property Found!!");
			}
			if (!consumerRepository.existsById(consumerId)) {
				return ResponseEntity.badRequest().body("No Consumer Found!!");
			}
			if (businessRepository.findByConsumerId(consumerId) == null) {
				return ResponseEntity.badRequest().body("No Business Found!!");
			}
			Optional<Property> property = propertyRepository.findById(propertyId);
			return ResponseEntity.ok(property);
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/updateConsumerBusiness")
	public ResponseEntity<?> updateConsumerBusiness(@RequestHeader String Authorization,
			@Valid @RequestBody UpdateRequest updateRequest) {
		if (consumerService.isSessionValid(Authorization)) {
			if (businessRepository.existsByBusinessName(updateRequest.getBusinessName())
					&& consumerRepository.existsById(updateRequest.getConsumerId())) {

				return consumerService.updateConsumerBusiness(updateRequest);
			}
			return ResponseEntity.badRequest().body("Business/Consumer doesnt exists");
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/createBusinessProperty")
	public ResponseEntity<?> createBusinessProperty(@RequestHeader String Authorization,
			@Valid @RequestBody BusinessInputRequest inputRequest) {
		if (consumerService.isSessionValid(Authorization)) {
			if (propertyRepository.existsByBusinessId(inputRequest.getBusinessId())) {
				return ResponseEntity.badRequest().body("BusinessProperty already exists");
			}
			if (!consumerRepository.existsById(inputRequest.getConsumerId())) {
				return ResponseEntity.badRequest().body("Consumer doesnot exists");
			}
			if (!businessRepository.existsById(inputRequest.getBusinessId())) {
				return ResponseEntity.badRequest().body("Business doesnot exists");
			}
			if(!consumerService.checkPropertyEligibility(inputRequest)) {
				return ResponseEntity.badRequest().body("Sorry! You are not Eligible");
			}
			return consumerService.createBusinessProperty(inputRequest);
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/updateBusinessProperty")
	public ResponseEntity<?> updateBusinessProperty(@RequestHeader String Authorization,
			@Valid @RequestBody BusinessUpdateRequest updateRequest) {
		if (consumerService.isSessionValid(Authorization)) {
			if (propertyRepository.existsByConsumerId(updateRequest.getConsumerId())) {
				return consumerService.updateBusinessProperty(updateRequest);
			}
			return ResponseEntity.badRequest().body("Business/Property doesnt exists");
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}
}
