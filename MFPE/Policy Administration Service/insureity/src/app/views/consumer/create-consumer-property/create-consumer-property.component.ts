import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { Property } from 'app/models/property.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-create-consumer-property',
  templateUrl: './create-consumer-property.component.html',
  styleUrls: ['./create-consumer-property.component.css'],
})
export class CreateConsumerPropertyComponent implements OnInit {
  public propertyForm!: FormGroup;
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any;
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.propertyForm = this.fb.group({
      businessId: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      consumerId: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      buildingSqFt: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      buildingType: ['', Validators.compose([Validators.required])],
      buildingStoreys: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      buildingAge: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      propertyValue: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      costOftheAsset: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      salvageValue: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      usefulLifeofAsset: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
    });
  }

  onSubmit(consumerForm: Property): void {
    console.log(consumerForm);
    // if (!this.propertyForm.valid) {
    //   this.errorMsg = 'Invalid input';
    //   return;
    // }

    this._consumerService.addBusinessProperty(consumerForm).subscribe(
      (data: any) => {
        this.response = 'Successfully created Business Property';
        // 'Successfully created Business Property with Consumer ID: ' +
        // data.consumerId +
        // 'and Business ID: ' +
        // data.businessId;
        // this._router.navigate(['/']);
      },
      (error: HttpErrorResponse) => {
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
