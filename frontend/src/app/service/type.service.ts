import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {OrgType} from "../model/orgType";
import {Headers} from "@angular/http";
import {FormControl} from "@angular/forms";

@Injectable()
export class OrganizationTypeService{

  private url = `http://127.0.0.1:8080/type`;

  constructor(private http: HttpClient){}

  getAllType (){
    return this.http.get(`${this.url}/`);
  }

  saveNewType(type : OrgType){
    return this.http.post(`${this.url}/`,  type)
  }

  getTypeByName(nameOfType){
    console.log("service", nameOfType);
    return this.http.get(`${this.url}/searchType?nameOrgType=${nameOfType}`);
  }

  deleteTypeById(typeId: number){
   return this.http.delete(`${this.url}/${typeId}`);
  }
}
