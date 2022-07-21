import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Policy } from 'app/models/policy.model';
import { URLs } from 'app/_shared/urls';

@Injectable({
  providedIn: 'root',
})
export class PolicyService {
  constructor(private http: HttpClient) {}
  // createPolicy
  public addPolicy(consumer: any): any {
    return this.http.post<any>(URLs.POLICY_API_BASE_URL + 'createPolicy', consumer);
  }
  // issuePolicy;
  public issuePolicy(policy: any): any {
    return this.http.post<any>(URLs.POLICY_API_BASE_URL + 'issuePolicy', policy);
  }

  // viewPolicy
  public getPolicy(policyId: string, consumerId: string) {
    return this.http.get<any>(
      URLs.POLICY_API_BASE_URL +
        'viewPolicy?consumerId=' +
        consumerId +
        '&policyId=' +
        policyId
    );
  }

  // getQuotes;
  public getQuotes(
    businessValue: Number,
    propertyValue: Number,
    propertyType: string
  ): any {
    return this.http.get<any>(
      URLs.POLICY_API_BASE_URL +
        'getQuotes?businessValue=' +
        businessValue +
        '&propertyValue=' +
        propertyValue +
        '&propertyType=' +
        propertyType
    );
  }
}
