import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";
import {UserService} from "../../service/user.service";
import {NgForm} from "@angular/forms";
import "rxjs/Rx";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users : User[];
  private isClicked : boolean = false;
  newUser = new User();

  constructor(private userService : UserService) { }

  ngOnInit() {
    this.userService.getAllUser().subscribe(data =>{
      this.users = data as User[];
    });
  }

  userFormSubmit(form : NgForm){
    this.userService.saveUser(this.newUser).subscribe(() =>{
      this.userService.getAllUser().subscribe(data =>{
        this.users = data as User[];
      });
    });
    form.reset();
  }

  deleteUserById(userId: number){
    this.userService.deleteUserById(userId).subscribe(() =>{
      this.userService.getAllUser().subscribe(data =>{
        this.users = data as User[];
      });
    });
  }

  displayTheDeleteButton() {
    this.isClicked === false ? this.isClicked = true : this.isClicked = false;
  }

}
