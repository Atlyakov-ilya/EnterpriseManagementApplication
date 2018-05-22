import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {User} from "../model/user";

@Injectable()
export class UserService{

  private url = `http://127.0.0.1:8080/user`;

  constructor(private http: HttpClient){}

  getAllUser(){
    return this.http.get(`${this.url}/`);
  }

  saveUser(user : User){
    const body = {lastName: user.lastName, firstName: user.firstName, middleName: user.middleName};
    return this.http.post(`${this.url}/`, body);
  }

  deleteUserById(userId : number){
   return this.http.delete(`${this.url}/${userId}`);
  }

}
