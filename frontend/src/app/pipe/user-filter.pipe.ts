import { Pipe, PipeTransform } from '@angular/core';
import {User} from "../model/user";
import {nodeValue} from "@angular/core/src/view";

@Pipe({
  name: 'userFilter'
})
export class UserFilterPipe implements PipeTransform {

  transform(users, searchUser: string, fieldLName: string, fieldFName: string, fieldMName: string) {
    if (searchUser === '') {
      return users;
    }
    return users.filter(user => user[fieldLName].
    toLowerCase().indexOf(searchUser.toLowerCase()) !== -1 || user[fieldFName].
    toLowerCase().indexOf(searchUser.toLowerCase()) !== -1 || user[fieldMName].
    toLowerCase().indexOf(searchUser.toLowerCase()) !== -1);

  }
}

