import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { ConsumerService } from './services/consumer.service';
import { PolicyService } from './services/policy.service';
import { ViewConsumerBusinessComponent } from './views/consumer/view-consumer-business/view-consumer-business.component';
import { ViewConsumerPropertyComponent } from './views/consumer/view-consumer-property/view-consumer-property.component';
import { CreatePolicyComponent } from './views/policy/create-policy/create-policy.component';
import { IssuePolicyComponent } from './views/policy/issue-policy/issue-policy.component';
import { ViewPolicyComponent } from './views/policy/view-policy/view-policy.component';
import { ViewQuotesComponent } from './views/policy/view-quotes/view-quotes.component';
import { CreateConsumerBusinessComponent } from './views/consumer/create-consumer-business/create-consumer-business.component';
import { CreateConsumerPropertyComponent } from './views/consumer/create-consumer-property/create-consumer-property.component';
import { UpdateConsumerPropertyComponent } from './views/consumer/update-consumer-property/update-consumer-property.component';
import { UpdateConsumerBusinessComponent } from './views/consumer/update-consumer-business/update-consumer-business.component';
import { LoginComponent } from './views/login/login.component';
import { RegisterComponent } from './views/register/register.component';
import { AuthInterceptor } from './_helpers/auth.interceptor';
import { CardComponent } from './_shared/card/card.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatePolicyComponent,
    ViewPolicyComponent,
    IssuePolicyComponent,
    HomeComponent,
    ViewConsumerPropertyComponent,
    ViewConsumerBusinessComponent,
    ViewQuotesComponent,
    CreateConsumerBusinessComponent,
    CreateConsumerPropertyComponent,
    UpdateConsumerPropertyComponent,
    UpdateConsumerBusinessComponent,
    LoginComponent,
    RegisterComponent,
    CardComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    ConsumerService,
    PolicyService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
