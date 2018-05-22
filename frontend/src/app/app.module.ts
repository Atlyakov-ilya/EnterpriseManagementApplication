import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavComponent } from './component/nav/nav.component';
import { UserListComponent } from './component/user-list/user-list.component';
import {AppRoutingModule} from "./app-routing.module";
import {OrgService} from "./service/organization.service";
import {OrganizationTypeService} from "./service/type.service";
import {UserService} from './service/user.service';
import {HttpClientModule} from "@angular/common/http";
import { OrganizationTypeListComponent } from './component/organization-type-list/organization-type-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AddingNewOrganizationComponent } from './component/adding-new-organization/adding-new-organization.component';
import {BackgroundDirective} from "./directive/backgraund.directive";
import { OrganizationTypeFilterPipe } from './pipe/organization-type-filter.pipe';
import { UserFilterPipe } from './pipe/user-filter.pipe';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    UserListComponent,
    OrganizationTypeListComponent,
    AddingNewOrganizationComponent,
    BackgroundDirective,
    OrganizationTypeFilterPipe,
    UserFilterPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    AppRoutingModule,
  ],
  providers: [
    OrgService,
    UserService,
    OrganizationTypeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
