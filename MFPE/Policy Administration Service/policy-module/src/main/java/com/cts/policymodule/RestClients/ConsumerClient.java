package com.cts.policymodule.RestClients;

import com.cts.policymodule.Exception.ConsumerBusinessNotFoundException;
import com.cts.policymodule.Payload.Response.ConsumerBusinessDetails;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Headers("Content-Type: application/json")
@FeignClient(name = "consumer-service", url = "${CONSUMER_SERVICE:http://localhost:8133}")
public interface ConsumerClient {
    @GetMapping("/viewConsumerBusiness")
    public ConsumerBusinessDetails viewConsumerBusiness(@RequestHeader String Authorization,@Valid @RequestParam Long consumerId) throws ConsumerBusinessNotFoundException;
}
