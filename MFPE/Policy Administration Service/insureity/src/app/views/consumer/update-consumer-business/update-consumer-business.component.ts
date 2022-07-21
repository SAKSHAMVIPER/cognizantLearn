import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-update-consumer-business',
  templateUrl: './update-consumer-business.component.html',
  styleUrls: ['./update-consumer-business.component.css'],
})
export class UpdateConsumerBusinessComponent implements OnInit {
  // public consumerForm!: FormGroup;
  public consumerId: any;
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any;
  state: any;

  constructor(
    private _consumerService: ConsumerService,
    private _Activatedroute: ActivatedRoute,
    private _router: Router
  ) {}

  consumerForm = new FormGroup({
    consumerId: new FormControl(),
    firstName: new FormControl(),
    lastName: new FormControl(),
    email: new FormControl(),
    pan: new FormControl(),
    dob: new FormControl(),
    businessName: new FormControl(),
    businessType: new FormControl(),
    capitalInvested: new FormControl(),
    validity: new FormControl(),
    agentId: new FormControl(),
    agentName: new FormControl(),
    businessTurnover: new FormControl(),
    businessAge: new FormControl(),
    totalEmployees: new FormControl(),
  });

  ngOnInit(): void {
    this.state = this._Activatedroute.snapshot.paramMap.get('consumerId');
    this.getConsumerBusiness();
    console.log(this.state);
  }

  public getConsumerBusiness(): any {
    return this._consumerService.getConsumerBusiness(this.state).subscribe(
      (consumerBusiness: any) => {
        console.log(consumerBusiness);
        this.setFormData(consumerBusiness);
        // this.response = consumerBusiness;
      },
      (error: any) => {
        this.hasError = true;
        this.errorMsg = error.error || error.error.error;
        console.error(error);
      }
    );
  }

  // set default form values here
  public setFormData(data: any) {
    this.consumerForm = new FormGroup({
      consumerId: new FormControl(data.consumerId),
      firstName: new FormControl(data.firstName),
      lastName: new FormControl(data.lastName),
      email: new FormControl(data.email),
      pan: new FormControl(data.pan),
      dob: new FormControl(data.dob),
      businessName: new FormControl(data.businessName),
      businessType: new FormControl(data.businessType),
      capitalInvested: new FormControl(data.capitalInvested),
      validity: new FormControl(data.validity),
      agentId: new FormControl(data.agentId),
      agentName: new FormControl(data.agentName),
      businessTurnover: new FormControl(data.businessTurnover),
      businessAge: new FormControl(data.businessAge),
      totalEmployees: new FormControl(data.totalEmployees),
    });
  }
  onSubmit(consumerForm: Consumer): void {
    console.log(consumerForm);

    this._consumerService.updateConsumerBusiness(consumerForm).subscribe(
      (data: any) => {
        this.response = 'Successfully updated Consumer Business';
        // 'Successfully updated Consumer Business with Consumer ID: ' +
        // data.consumerId +
        // 'and Business ID: ' +
        // data.businessId;
      },
      (error: any) => {
        this.hasError = true;
        if (error.error.error != null) this.errorMsg = error.error.error;
        else this.errorMsg = error.error;
        console.error(error);
      }
    );
  }

  onCancel(): void {
    this._router.navigate(['/']);
  }
}
