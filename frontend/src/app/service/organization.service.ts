import {Injectable} from "@angular/core";
import {Organization} from "../model/organization";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class OrgService{

  private url = `http://127.0.0.1:8080/org`;

  constructor(private http: HttpClient){}

  getOrganizationById(orgId : number){
    return this.http.get(`${this.url}/${orgId}`);
  }

  getAllOrganizations() {
    return this.http.get(`${this.url}/`);
  }

  deleteOrgById(orgId : number){
    return this.http.delete(`${this.url}/${orgId}`);
  }

  addNewOrganization(organization : Organization){
    const body = OrgService.organizationObjectImpl(organization);
    return this.http.post(`${this.url}/`, body);
  }

  editOrganization(organization : Organization){
    const body = OrgService.organizationObjectImpl(organization);
    console.log(organization.orgId)
    return this.http.put(`${this.url}/${organization.orgId}`, body);
  }

 static organizationObjectImpl(organization : Organization) : any{
   return  {
      orgName: organization.orgName,
      orgDescription: organization.orgDescription,
      address: organization.address,
      phoneNumber: organization.phoneNumber,
      numberOfStaff: organization.numberOfStaff,
      additionalInformation:organization.additionalInformation,
      typeOfOrganization: organization.typeOfOrganization,
      director:organization.director,
      date: organization.date
    }
  }

}
