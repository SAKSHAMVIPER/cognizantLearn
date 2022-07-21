import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URLs } from 'app/_shared/urls';

@Injectable({
  providedIn: 'root',
})
export class QuotesService {
  constructor(private http: HttpClient) {}

  public getQuotes(
    businessValue: number,
    propertyValue: number,
    propertyType: string
  ) {
    return this.http.get<any>(
      URLs.QUOTES_API_BASE_URL +
        'quotes-service/getQuotesForPolicy/?businessValue=' +
        businessValue +
        '&propertyValue=' +
        propertyValue +
        '&propertyType=' +
        propertyType
    );
  }
}
