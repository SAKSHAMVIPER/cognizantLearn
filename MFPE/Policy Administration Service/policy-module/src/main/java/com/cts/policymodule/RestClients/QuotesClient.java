package com.cts.policymodule.RestClients;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Headers("Content-Type: application/json")
@FeignClient(name = "quotes-service", url = "${QUOTES_SERVICE:http://localhost:8666}")
public interface QuotesClient {
    @GetMapping("/getQuotesForPolicy")
    public String quotesResponse
            (@RequestHeader String Authorization,@Valid @RequestParam Long businessValue, @RequestParam Long propertyValue, @RequestParam String propertyType);
}
