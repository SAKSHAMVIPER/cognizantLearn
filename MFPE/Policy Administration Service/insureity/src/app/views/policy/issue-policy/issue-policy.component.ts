import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-issue-policy',
  templateUrl: './issue-policy.component.html',
  styleUrls: ['./issue-policy.component.css'],
})
export class IssuePolicyComponent implements OnInit {
  public issuePolicyForm!: FormGroup;
  public hasError: boolean = false;
  public errorMsg: string = '';
  public state: any;
  public policyResponse: any;
  constructor(private _policyService: PolicyService) {}

  ngOnInit(): void {
    this.issuePolicyForm = new FormGroup({
      policyId: new FormControl(),
      consumerId: new FormControl(),
      businessId: new FormControl(),
      paymentDetails: new FormControl(),
      acceptanceStatus: new FormControl(),
    });
  }

  public onClickIssuePolicy(issuePolicyForm: any): void {
    // todo: check
    console.log(issuePolicyForm);
    this._policyService.issuePolicy(issuePolicyForm).subscribe(
      (data: any) => {
        console.log(data);
        this.policyResponse = data.message;
      },
      (error: any) => {
        this.hasError = true;
        if (error.error.message != null) this.errorMsg = error.error.message;
        else if (error.error.error != null) this.errorMsg = error.error.error;
        else this.errorMsg = error.error;
        console.error(error);
      }
    );
  }
}
