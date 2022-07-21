import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateConsumerBusinessComponent } from './views/consumer/create-consumer-business/create-consumer-business.component';
import { CreateConsumerPropertyComponent } from './views/consumer/create-consumer-property/create-consumer-property.component';
import { UpdateConsumerBusinessComponent } from './views/consumer/update-consumer-business/update-consumer-business.component';
import { UpdateConsumerPropertyComponent } from './views/consumer/update-consumer-property/update-consumer-property.component';
import { ViewConsumerBusinessComponent } from './views/consumer/view-consumer-business/view-consumer-business.component';
import { ViewConsumerPropertyComponent } from './views/consumer/view-consumer-property/view-consumer-property.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { CreatePolicyComponent } from './views/policy/create-policy/create-policy.component';
import { IssuePolicyComponent } from './views/policy/issue-policy/issue-policy.component';
import { ViewPolicyComponent } from './views/policy/view-policy/view-policy.component';
import { ViewQuotesComponent } from './views/policy/view-quotes/view-quotes.component';
import { RegisterComponent } from './views/register/register.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },

  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'createConsumerProperty',
    component: CreateConsumerPropertyComponent,
  },
  {
    path: 'createConsumerBusiness',
    component: CreateConsumerBusinessComponent,
  },
  { path: 'createPolicy', component: CreatePolicyComponent },

  {
    path: 'updateConsumerProperty/:consumerId/:propertyId',
    component: UpdateConsumerPropertyComponent,
  },
  {
    path: 'updateConsumerBusiness/:consumerId',
    component: UpdateConsumerBusinessComponent,
  },
  { path: 'issuePolicy', component: IssuePolicyComponent },

  {
    path: 'viewConsumerBusiness/:consumerId',
    component: ViewConsumerBusinessComponent,
  },
  {
    path: 'viewConsumerProperty/:consumerId/:propertyId',
    component: ViewConsumerPropertyComponent,
  },
  {
    path: 'viewPolicy/:consumerId/:policyId',
    component: ViewPolicyComponent,
  },
  { path: 'viewQuotes', component: ViewQuotesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
