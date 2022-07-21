import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { Property } from 'app/models/property.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-update-consumer-property',
  templateUrl: './update-consumer-property.component.html',
  styleUrls: ['./update-consumer-property.component.css'],
})
export class UpdateConsumerPropertyComponent implements OnInit {
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any;
  state: any = { consumerId: null, propertyId: null };
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router,
    private _Activatedroute: ActivatedRoute
  ) {}

  propertyForm = new FormGroup({
    businessId: new FormControl(),
    consumerId: new FormControl(),
    buildingSqFt: new FormControl(),
    buildingType: new FormControl(),
    buildingStoreys: new FormControl(),
    buildingAge: new FormControl(),
    costOftheAsset: new FormControl(),
    salvageValue: new FormControl(),
    usefulLifeofAsset: new FormControl(),
  });
  ngOnInit(): void {
    this.state.consumerId =
      this._Activatedroute.snapshot.paramMap.get('consumerId');
    this.state.propertyId =
      this._Activatedroute.snapshot.paramMap.get('propertyId');
    console.log(this.state);

    this.getConsumerProperty();
  }

  public getConsumerProperty(): any {
    return this._consumerService
      .getConsumerProperty(this.state.consumerId, this.state.propertyId)
      .subscribe(
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
    this.propertyForm = new FormGroup({
      businessId: new FormControl(data.businessId),
      consumerId: new FormControl(data.consumerId),
      buildingSqFt: new FormControl(data.buildingSqFt),
      buildingType: new FormControl(data.buildingType),
      buildingStoreys: new FormControl(data.buildingStoreys),
      buildingAge: new FormControl(data.buildingAge),
      costOftheAsset: new FormControl(data.costOftheAsset),
      salvageValue: new FormControl(data.salvageValue),
      usefulLifeofAsset: new FormControl(data.usefulLifeofAsset),
    });
  }

  onSubmit(consumerForm: Consumer): void {
    console.log(consumerForm);

    this._consumerService
      .updateBusinessProperty(consumerForm)
      .subscribe((data: any) => {
        this.response = 'Successfully updated Business Property';
          // 'Successfully updated Business Property with Consumer ID: ' +
          // data.consumerId +
          // 'and Business ID: ' +
          // data.businessId;
        // this._router.navigate(['/']);
      });
  }

  onCancel(): void {
    this._router.navigate(['/']);
  }
}
