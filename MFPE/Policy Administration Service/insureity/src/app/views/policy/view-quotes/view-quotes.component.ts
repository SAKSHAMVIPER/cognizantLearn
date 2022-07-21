import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-view-quotes',
  templateUrl: './view-quotes.component.html',
  styleUrls: ['./view-quotes.component.css'],
})
export class ViewQuotesComponent implements OnInit {
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any = {};
  public state: any;

  constructor(private _policyService: PolicyService, private _router: Router) {}

  ngOnInit(): void {
    this.state = history.state;
    console.log(this.state);

    this.getQuotes();
  }

  public getQuotes(): any {
    return this._policyService
      .getQuotes(
        this.state.businessValue,
        this.state.propertyValue,
        this.state.propertyType
      )
      .subscribe(
        (policy: any) => {
          console.log(policy);
          this.response = policy;
        },
        (error: any) => {
          this.hasError = true;
          if (error.error.message != null) this.errorMsg = error.error.message;
          else this.errorMsg = error.error;
          console.error(error);
        }
      );
  }
}
