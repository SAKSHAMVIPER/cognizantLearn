import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-create-consumer-business',
  templateUrl: './create-consumer-business.component.html',
  styleUrls: ['./create-consumer-business.component.css'],
})
export class CreateConsumerBusinessComponent implements OnInit {
  public consumerForm!: FormGroup;
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any;

  constructor(
    private _consumerService: ConsumerService,
    private _fb: FormBuilder,
    private _router: Router
  ) {
    this.myForm();
  }

  //Create required field validator for name
  myForm() {
    this.consumerForm = this._fb.group({
      firstName: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('^[A-Z+a-z ]{3,40}$'),
        ]),
      ],
      lastName: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('^[A-Z+a-z ]{3,40}$'),
        ]),
      ],
      email: [
        '',
        Validators.compose([
          Validators.required,
          Validators.email,
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,30}$'),
        ]),
      ],
      pan: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[A-Z]{5}[0-9]{4}[A-Z]{1}'),
        ]),
      ],
      dob: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}'),
        ]),
      ],
      businessName: ['', Validators.required],
      businessType: ['', Validators.required],
      capitalInvested: ['', Validators.required],
      validity: [
        '',
        Validators.compose([Validators.required, Validators.maxLength(2)]),
      ],
      agentId: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      agentName: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('^[A-Z+a-z ]{3,40}$'),
        ]),
      ],
      businessTurnover: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
      businessAge: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,3}'),
        ]),
      ],
      totalEmployees: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{1,4}'),
        ]),
      ],
    });
  }
  ngOnInit(): void {
    // this.consumerForm = new FormGroup({
    //   firstName: new FormControl(),
    //   lastName: new FormControl(),
    //   email: new FormControl(),
    //   pan: new FormControl(),
    //   dob: new FormControl(),
    //   businessName: new FormControl(),
    //   businessType: new FormControl(),
    //   capitalInvested: new FormControl(),
    //   validity: new FormControl(),
    //   agentId: new FormControl(),
    //   agentName: new FormControl(),
    //   businessTurnover: new FormControl(),
    //   businessAge: new FormControl(),
    //   totalEmployees: new FormControl(),
    // });
  }

  onSubmit(consumerForm: any): void {
    console.log(consumerForm);

    // if (!consumerForm.valid) {
    //   this.errorMsg = 'Invalid consumer form';
    //   return;
    // }
    this._consumerService.addConsumerBusiness(consumerForm).subscribe(
      (data: any) => {
        console.log(data);
        if (data == 'Created')
          this.response = 'Successfully created Consumer Business';
        // 'Successfully created Consumer Business with Consumer ID: ' +
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
