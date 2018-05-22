///<reference path="../../../../node_modules/@angular/forms/src/validators.d.ts"/>
import {Component, OnInit} from '@angular/core';
import {OrgType} from "../../model/orgType";
import {OrganizationTypeService} from "../../service/type.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";




@Component({
  selector: 'app-organization-type-list',
  templateUrl: './organization-type-list.component.html',
  styleUrls: ['./organization-type-list.component.css']
})
export class OrganizationTypeListComponent implements OnInit {

  orgTypes : OrgType[];
  private isClicked : boolean = false;
  form : FormGroup;

  constructor(private typeService: OrganizationTypeService) {}

  ngOnInit() {
    this.form = new FormGroup({
      nameOrgType: new FormControl('',
        [Validators.required, Validators.minLength(3)],
          [this.checkForNameOfType.bind(this)])
    });
    this.typeService.getAllType().subscribe(data => {
      this.orgTypes = data as OrgType[];
    });
  }

  saveType(control : FormControl) {
    this.typeService.saveNewType(control.value).subscribe(() => {
      this.typeService.getAllType().subscribe(data => {
        this.orgTypes = data as OrgType[];
      });
    });
    control.reset();
  }

  checkForNameOfType(control : FormControl): Observable<{ [key: string]: any } | null>{
    if (control.value === null) {
      return Observable.of(null);
    }else{
      return this.typeService.getTypeByName(control.value).map(type => {
        return type ? { 'nameOrgTypeExist': { value: control.value } } : null;
      });
    }
  }

  deleteTypeById(orgTypeId: number){
    this.typeService.deleteTypeById(orgTypeId).subscribe(() => {
      this.typeService.getAllType().subscribe(data => {
        this.orgTypes = data as OrgType[];
      })
    });
  }

  displayTheDeleteButton() {
    this.isClicked === false ? this.isClicked = true : this.isClicked = false;
  }
}
