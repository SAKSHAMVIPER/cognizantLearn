import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-view-consumer-business',
  templateUrl: './view-consumer-business.component.html',
  styleUrls: ['./view-consumer-business.component.css'],
})
export class ViewConsumerBusinessComponent implements OnInit {
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any = {};
  state: any;
  constructor(
    private _consumerService: ConsumerService,
    private _activatedroute: ActivatedRoute,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.state = this._activatedroute.snapshot.paramMap.get('consumerId');
    console.log(this.state);

    this.getConsumerBusiness();
  }

  public getConsumerBusiness(): any {
    return this._consumerService.getConsumerBusiness(this.state).subscribe(
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
