import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-create-policy',
  templateUrl: './create-policy.component.html',
  styleUrls: ['./create-policy.component.css'],
})
export class CreatePolicyComponent implements OnInit {
  public policyForm!: FormGroup;
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any;
  constructor(private _policyService: PolicyService, private _router: Router) {}

  ngOnInit(): void {
    this.policyForm = new FormGroup({
      consumerId: new FormControl(),
      acceptedQuotes: new FormControl(),
    });
  }

  onSubmit(policyForm: any): void {
    console.log(policyForm);

    this._policyService.addPolicy(policyForm).subscribe(
      (data: any) => {
        console.log(data);
        this.response = data.message;
        // 'Successfully created Business Property with Consumer ID: ' +
        // data.consumerId +
        // 'and Accepted Quote: ' +
        // data.acceptedQuotes;
        // this._router.navigate(['/']);
      },
      (error: HttpErrorResponse) => {
        this.hasError = true;
        if (error.error.message != null) this.errorMsg = error.error.message;
        else if (error.error.error != null) this.errorMsg = error.error.error;
        else this.errorMsg = error.error;
        console.error(error);
      }
    );
  }

  onCancel(): void {
    this._router.navigate(['/']);
  }
}
