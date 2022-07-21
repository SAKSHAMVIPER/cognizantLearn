import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Consumer } from 'app/models/consumer.model';
import { Property } from 'app/models/property.model';
import { URLs } from 'app/_shared/urls';
import { Observable } from 'rxjs/internal/Observable';

const headers = new HttpHeaders().set('Content-Type', 'application/json');
const requestOptions: Object = {
  headers: headers,
  responseType: 'text',
};

@Injectable({
  providedIn: 'root',
})
export class ConsumerService {
  constructor(private http: HttpClient) {}
  // createConsumerBusiness
  public addConsumerBusiness(consumer: any): any {
    console.log(consumer);
    return this.http.post<any>(
      URLs.CONSUMER_API_BASE_URL + 'createConsumerBusiness',
      consumer,
      requestOptions
    );
  }

  // createBusinessProperty
  public addBusinessProperty(property: Property): any {
    return this.http.post<Property>(
      URLs.CONSUMER_API_BASE_URL + 'createBusinessProperty',
      property,
      requestOptions
    );
  }

  // updateConsumerBusiness
  public updateConsumerBusiness(consumer: Consumer): any {
    return this.http.post<Consumer>(
      URLs.CONSUMER_API_BASE_URL + 'updateConsumerBusiness',
      consumer,
      requestOptions
    );
  }

  // updateBusinessProperty
  public updateBusinessProperty(property: Property): any {
    return this.http.post<Consumer>(
      URLs.CONSUMER_API_BASE_URL + 'updateBusinessProperty',
      property,
      requestOptions
    );
  }

  // viewConsumerBusiness
  public getConsumerBusiness(id: number): Observable<any> {
    return this.http.get(
      URLs.CONSUMER_API_BASE_URL + 'viewConsumerBusiness?consumerId=' + id,
      { responseType: 'json' }
    ); //.pipe(map((response: any) => response.json()));
  }

  // viewConsumerProperty
  public getConsumerProperty(consumerId: string, propertyId: number): any {
    return this.http.get<Property>(
      URLs.CONSUMER_API_BASE_URL +
        'viewConsumerProperty?consumerId=' +
        consumerId +
        '&propertyId=' +
        propertyId
    );
  }
}
