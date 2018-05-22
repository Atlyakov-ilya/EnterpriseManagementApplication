import {Component, OnInit} from '@angular/core';
import {OrgService} from "../../service/organization.service";
import {Organization} from "../../model/organization";


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public organizations : Organization[];
  private isClicked : boolean = false;


  constructor(private orgService: OrgService) { }

  ngOnInit() {
    this.orgService.getAllOrganizations().subscribe(organizations => {
      this.organizations = organizations  as Organization[] ;
    },error => console.error(error));
  }


  displayTheDeleteButton() {
    this.isClicked === false ? this.isClicked = true : this.isClicked = false;
  }

  deleteOrganizationById(org: number){
    this.orgService.deleteOrgById(org).subscribe(() => {
      this.orgService.getAllOrganizations().subscribe(organizations => {
        this.organizations = organizations  as Organization[] ;
      },error => console.error(error));
    });
}


}
