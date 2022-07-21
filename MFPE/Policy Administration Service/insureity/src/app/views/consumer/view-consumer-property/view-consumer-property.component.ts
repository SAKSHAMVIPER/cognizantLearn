import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-view-consumer-property',
  templateUrl: './view-consumer-property.component.html',
  styleUrls: ['./view-consumer-property.component.css'],
})
export class ViewConsumerPropertyComponent implements OnInit {
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any = {};
  state: any = { consumerId: null, propertyId: null };
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router,
    private _Activatedroute: ActivatedRoute
  ) {}

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
          this.response = consumerBusiness;
        },
        (error: any) => {
          this.hasError = true;
          if (error.error.error != null) this.errorMsg = error.error.error;
          else this.errorMsg = error.error;
          console.error(error);
        }
      );
  }
}
