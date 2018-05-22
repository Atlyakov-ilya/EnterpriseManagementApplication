import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UserListComponent} from "./component/user-list/user-list.component";
import {AddingNewOrganizationComponent} from "./component/adding-new-organization/adding-new-organization.component";
import {OrganizationTypeListComponent} from "./component/organization-type-list/organization-type-list.component";


const appRoutes : Routes = [
  {path : 'user_list', component : UserListComponent},
  {path : 'add_org/:orgId', component : AddingNewOrganizationComponent},
  {path : 'add_org', component : AddingNewOrganizationComponent},
  {path : 'type_list', component : OrganizationTypeListComponent}
];

@NgModule({
  imports : [RouterModule.forRoot(appRoutes)],
  exports : [RouterModule]

})
export class AppRoutingModule{}
