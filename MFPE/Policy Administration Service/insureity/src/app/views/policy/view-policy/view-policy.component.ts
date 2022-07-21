import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-view-policy',
  templateUrl: './view-policy.component.html',
  styleUrls: ['./view-policy.component.css'],
})
export class ViewPolicyComponent implements OnInit {
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any = {};
  public state: any = { consumerId: null, policyId: null };

  constructor(
    private _policyService: PolicyService,
    private _router: Router,
    private _Activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.state.consumerId =
      this._Activatedroute.snapshot.paramMap.get('consumerId');
    this.state.policyId =
      this._Activatedroute.snapshot.paramMap.get('policyId');
    console.log(this.state);

    this.getPolicy();
  }

  public getPolicy(): any {
    return this._policyService
      .getPolicy(this.state.policyId, this.state.consumerId)
      .subscribe(
        (policy: any) => {
          console.log(policy);
          this.response = policy;
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
