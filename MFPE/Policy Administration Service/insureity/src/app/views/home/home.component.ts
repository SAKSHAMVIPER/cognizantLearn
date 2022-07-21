import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public quoteResponse: any;

  public consumerBusinessForm!: FormGroup;
  public consumerPropertyForm!: FormGroup;
  public policyForm!: FormGroup;
  public quotesForm!: FormGroup;

  consumerError: any;
  propertyError: any;
  quotesError: any;
  policyError: any;

  hasError: boolean = false;
  errorMsg: any;

  constructor(
    private _consumerService: ConsumerService,
    private _policyService: PolicyService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.consumerBusinessForm = new FormGroup({
      consumerId: new FormControl(),
    });

    this.consumerPropertyForm = new FormGroup({
      consumerId2: new FormControl(),
      propertyId: new FormControl(),
    });

    this.quotesForm = new FormGroup({
      businessValue: new FormControl(),
      propertyValue: new FormControl(),
      propertyType: new FormControl(),
    });

    this.policyForm = new FormGroup({
      consumerId3: new FormControl(),
      policyId: new FormControl(),
    });
  }

  // consumerbusiness function
  public onClickAddConsumerBusiness(): void {
    this._router.navigate(['/createConsumerBusiness']);
  }
  public onClickViewConsumerBusiness(consumerBusinessForm: any): void {
    if (consumerBusinessForm.consumerId == null) {
      this.consumerError = 'Consumer Id is required';
      return;
    }
    // this._router.navigate(['/viewConsumerBusiness/']);
    this._router.navigateByUrl(
      '/viewConsumerBusiness/' + consumerBusinessForm.consumerId
    );
  }
  public onClickUpdateConsumerBusiness(consumerBusinessForm: any): void {
    if (consumerBusinessForm.consumerId == null) {
      this.consumerError = 'Consumer Id is required';
      return;
    }
    this._router.navigate([
      '/updateConsumerBusiness/' + consumerBusinessForm.consumerId,
    ]);
  }

  // consumer property function
  public onClickViewConsumerProperty(consumerPropertyForm: any): void {
    if (
      consumerPropertyForm.consumerId2 == null &&
      consumerPropertyForm.propertyId == null
    ) {
      this.propertyError = 'Consumer Id and Property Id is required';
      return;
    }
    if (consumerPropertyForm.consumerId2 == null) {
      this.propertyError = 'Consumer Id is required';
      return;
    }
    if (consumerPropertyForm.propertyId == null) {
      this.propertyError = 'Property Id is required';
      return;
    }
    // this._router.navigate(['/viewConsumerProperty']);
    this._router.navigateByUrl(
      '/viewConsumerProperty/' +
        consumerPropertyForm.consumerId2 +
        '/' +
        consumerPropertyForm.propertyId
    );
  }
  public onClickAddConsumerProperty(): void {
    this._router.navigate(['/createConsumerProperty']);
  }
  public onClickUpdateConsumerProperty(consumerPropertyForm: any): void {
    if (
      consumerPropertyForm.consumerId2 == null &&
      consumerPropertyForm.propertyId == null
    ) {
      this.propertyError = 'Consumer Id and Property Id is required';
      return;
    }
    if (consumerPropertyForm.consumerId2 == null) {
      this.propertyError = 'Consumer Id is required';
      return;
    }
    if (consumerPropertyForm.propertyId == null) {
      this.propertyError = 'Property Id is required';
      return;
    }
    this._router.navigate([
      '/updateConsumerProperty/' +
        consumerPropertyForm.consumerId2 +
        '/' +
        consumerPropertyForm.propertyId,
    ]);
  }

  // quotes function
  public onClickViewQuotes(quotesForm: any): void {
    this.hasError = false;

    if (
      quotesForm.businessValue == null ||
      quotesForm.propertyValue == null ||
      quotesForm.propertyType == null
    ) {
      this.quotesError = 'All fields are required';
      return;
    }
    // todo: check
    return this._policyService
      .getQuotes(
        quotesForm.businessValue,
        quotesForm.propertyValue,
        quotesForm.propertyType
      )
      .subscribe(
        (policy: any) => {
          console.log(policy);
          this.quoteResponse = policy.quotes;
        },
        (error: any) => {
          this.hasError = true;
          console.error(error);
          if (error.error.error != null) this.errorMsg = error.error.error;
          else if (error.error.message != null)
            this.errorMsg = error.error.message;
          else this.errorMsg = error.error;
        }
      );
  }

  // policy function
  public onClickViewPolicy(policyForm: any): void {
    // this._router.navigate(['/viewPolicy']);
    if (policyForm.consumerId3 == null || policyForm.policyId == null) {
      this.policyError = 'All fields are required';
      return;
    }
    this._router.navigateByUrl(
      '/viewPolicy/' + policyForm.consumerId3 + '/' + policyForm.policyId
    );
  }
  public onClickAddPolicy(): void {
    this._router.navigate(['/createPolicy']);
  }
  public onClickIssuePolicy(): void {
    this._router.navigate(['/issuePolicy']);
  }
}
