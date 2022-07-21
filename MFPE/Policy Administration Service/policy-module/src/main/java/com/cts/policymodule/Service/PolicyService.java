package com.cts.policymodule.Service;

import com.cts.policymodule.Entities.ConsumerPolicy;
import com.cts.policymodule.Entities.PolicyMaster;
import com.cts.policymodule.Exception.ConsumerBusinessNotFoundException;
import com.cts.policymodule.Exception.ConsumerPolicyNotFoundException;
import com.cts.policymodule.Exception.PolicyNotFoundException;
import com.cts.policymodule.Payload.Request.CreatePolicyRequest;
import com.cts.policymodule.Payload.Request.IssuePolicyRequest;
import com.cts.policymodule.Payload.Response.AuthResponse;
import com.cts.policymodule.Payload.Response.ConsumerBusinessDetails;
import com.cts.policymodule.Payload.Response.MessageResponse;
import com.cts.policymodule.Payload.Response.PolicyDetailsResponse;
import com.cts.policymodule.Payload.Response.QuoteDetailsResponse;
import com.cts.policymodule.Repository.ConsumerPolicyRepository;
import com.cts.policymodule.Repository.PolicyMasterRepository;
import com.cts.policymodule.RestClients.AuthClient;
import com.cts.policymodule.RestClients.ConsumerClient;
import com.cts.policymodule.RestClients.QuotesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PolicyService {

    @Autowired
    private ConsumerPolicyRepository consumerPolicyRepository;

    @Autowired
    private PolicyMasterRepository policyMasterRepository;

    @Autowired
    private ConsumerClient consumerClient;

    @Autowired
    private QuotesClient quotesClient;

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

    public QuoteDetailsResponse getQuotes(String Authorization, Long businessValue, Long propertyValue,
            String propertyType) {
        String quote = quotesClient.quotesResponse(Authorization, businessValue, propertyValue, propertyType);
        return (new QuoteDetailsResponse(quote));
    }

    public PolicyDetailsResponse viewPolicy(long consumerId, String policyId)
            throws PolicyNotFoundException, ConsumerPolicyNotFoundException {
        PolicyMaster policyMaster = policyMasterRepository.findByPolicyId(policyId);
        ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerId(consumerId);
        PolicyDetailsResponse policyDetailsResponse = new PolicyDetailsResponse(consumerId, policyMaster.getPolicyId(),
                policyMaster.getPropertyType(), policyMaster.getConsumerType(), policyMaster.getAssuredSum(),
                policyMaster.getTenure(), policyMaster.getBusinessValue(), policyMaster.getPropertyValue(),
                policyMaster.getBaseLocation(), policyMaster.getType(), consumerPolicy.getBusinessId(),
                consumerPolicy.getPaymentDetails(), consumerPolicy.getAcceptanceStatus(),
                consumerPolicy.getPolicyStatus(), consumerPolicy.getEffectiveDate(), consumerPolicy.getCoveredSum(),
                consumerPolicy.getDuration(), consumerPolicy.getAcceptedQuote());
        return policyDetailsResponse;
    }

    public MessageResponse createPolicy(String Authorization, CreatePolicyRequest createPolicyRequest){
    	ConsumerBusinessDetails consumerBusinessDetails=new ConsumerBusinessDetails();
    	try {
        consumerBusinessDetails = getConsumerBusiness(Authorization,
                createPolicyRequest.getConsumerId());
    	}
    	catch(ConsumerBusinessNotFoundException e){
    		
    	}
        if (consumerBusinessDetails == null) {
            return new MessageResponse("No Consumer Business Found!!");
        }
        ConsumerPolicy consumerPolicy = new ConsumerPolicy(consumerBusinessDetails.getConsumerId(),
                consumerBusinessDetails.getBusinessId(), "Initiated", createPolicyRequest.getAcceptedQuotes());
        ConsumerPolicy consumerPolicySave = consumerPolicyRepository.save(consumerPolicy);
        return new MessageResponse("Policy has been created with Policy Consumer Id : " + consumerPolicySave.getId()
                + " .Thank You Very Much!!");
    }

    public ConsumerBusinessDetails getConsumerBusiness(String Authorization, Long consumerId)
            throws ConsumerBusinessNotFoundException {
        ConsumerBusinessDetails consumerBusinessDetails = consumerClient.viewConsumerBusiness(Authorization,
                consumerId);
        return consumerBusinessDetails;
    }

    // public MessageResponse issuePolicy(IssuePolicyRequest issuePolicyRequest)
    // throws ConsumerPolicyNotFoundException, PolicyNotFoundException {
    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    // LocalDateTime now = LocalDateTime.now();
    // ConsumerPolicy consumerPolicy =
    // consumerPolicyRepository.findByConsumerIdAndBusinessId(issuePolicyRequest.getConsumerId(),
    // issuePolicyRequest.getBusinessId());
    // PolicyMaster policyMaster =
    // policyMasterRepository.findByPolicyId(issuePolicyRequest.getPolicyId());
    // consumerPolicy.setPolicyId(issuePolicyRequest.getPolicyId());
    // consumerPolicy.setPaymentDetails(issuePolicyRequest.getPaymentDetails());
    // consumerPolicy.setAcceptanceStatus(issuePolicyRequest.getAcceptanceStatus());
    // consumerPolicy.setPolicyStatus("Issued");
    // consumerPolicy.setEffectiveDate(dtf.format(now));
    // consumerPolicy.setDuration(policyMaster.getTenure());
    // consumerPolicy.setCoveredSum(policyMaster.getAssuredSum());
    // ConsumerPolicy consumerPolicySave =
    // consumerPolicyRepository.save(consumerPolicy);
    // return new MessageResponse("Policy has Issued to PolicyConsumer Id : " +
    // consumerPolicySave.getId() + " .Thank You Very Much!!");
    // }
    public MessageResponse issuePolicy(IssuePolicyRequest issuePolicyRequest)
            throws ConsumerPolicyNotFoundException, PolicyNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ConsumerPolicy consumerPolicy = consumerPolicyRepository
                .findByConsumerIdAndBusinessId(issuePolicyRequest.getConsumerId(), issuePolicyRequest.getBusinessId());
        PolicyMaster policyMaster = policyMasterRepository.findByPolicyId(issuePolicyRequest.getPolicyId());
        consumerPolicy.setPolicyId(issuePolicyRequest.getPolicyId());
        consumerPolicy.setPaymentDetails(issuePolicyRequest.getPaymentDetails());
        consumerPolicy.setAcceptanceStatus(issuePolicyRequest.getAcceptanceStatus());
        consumerPolicy.setPolicyStatus("Issued");
        consumerPolicy.setAssuredSum(policyMaster.getAssuredSum());
        consumerPolicy.setBaseLocation(policyMaster.getBaseLocation());
        consumerPolicy.setBusinessValue(policyMaster.getBusinessValue());
        consumerPolicy.setConsumerType(policyMaster.getConsumerType());
        consumerPolicy.setPropertyType(policyMaster.getPropertyType());
        consumerPolicy.setPropertyValue(policyMaster.getPropertyValue());
        consumerPolicy.setTenure(policyMaster.getTenure());
        consumerPolicy.setType(policyMaster.getType());
        consumerPolicy.setEffectiveDate(dtf.format(now));
        consumerPolicy.setDuration(policyMaster.getTenure());
        consumerPolicy.setCoveredSum(policyMaster.getAssuredSum());
        ConsumerPolicy consumerPolicySave = consumerPolicyRepository.save(consumerPolicy);
        return new MessageResponse(
                "Policy has been issued to Policy Consumer Id : " + consumerPolicySave.getId() + " .Thank You Very Much!!");
    }

}
