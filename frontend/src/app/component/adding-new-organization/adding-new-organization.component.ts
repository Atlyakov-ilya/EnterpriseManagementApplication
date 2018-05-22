import {Component, OnInit} from '@angular/core';
import {OrganizationTypeService} from "../../service/type.service";
import {OrgType} from "../../model/orgType";
import {Organization} from "../../model/organization";
import {User} from "../../model/user";
import {UserService} from "../../service/user.service";
import {NgForm} from "@angular/forms";
import {OrgService} from "../../service/organization.service";
import {ActivatedRoute} from "@angular/router";
import {isUndefined} from "util";


@Component({
  selector: 'app-adding-new-organization',
  templateUrl: './adding-new-organization.component.html',
  styleUrls: ['./adding-new-organization.component.css']
})
export class AddingNewOrganizationComponent implements OnInit{

  orgTypes : OrgType[];
  users : User[];
  organization = new Organization();
  searchType = '';
  searchUser = '';
  orgId: string;
  user = new User();
  orgType = new OrgType();
  showEditFlag :boolean;


  constructor(private organizationService: OrgService,
              private typeService: OrganizationTypeService,
              private userService : UserService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.orgId =  this.route.snapshot.params['orgId'];
     if(isUndefined(this.orgId)){
       this.showEditFlag = false;
     }else{
       this.showEditFlag = true;
       this.route.params
         .pluck('orgId')
         .switchMap(orgId => this.organizationService.getOrganizationById(orgId as number))
         .subscribe(org => {
           this.organization = org as Organization,
             this.orgType = this.organization.typeOfOrganization,
             this.user = this.organization.director;
         });
     }
    }

  getOrganizationTypeList(){
    this.typeService.getAllType().subscribe(data => {
      this.orgTypes = data as OrgType[];
    })
  }

  getUserList(){
    this.userService.getAllUser().subscribe(data =>{
      this.users = data as User[];
    });
  }

  selectTypeByName(type : OrgType){
    return this.orgType = type;
  }

  selectUser(user : User){
    return this.user = user;
  }

  addNewOrganization(form : NgForm){
    this.organization.typeOfOrganization = this.orgType;
    this.organization.director = this.user;
    this.organizationService.addNewOrganization(this.organization).subscribe(data => {
      this.users = data as User[];
    });
    form.reset();
  }


  editOrganization(form : NgForm , org: Organization ){
    this.organizationService.editOrganization(this.organization).subscribe();
    console.log('!!!!!!!!!!!!!!!!!!!!');
    form.reset();
  }

}
