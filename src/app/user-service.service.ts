import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {user} from './user'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  userExists:boolean=true;

  constructor(private router:Router,private httpclient:HttpClient) { }

  addUser(user:any) {
    let NewUsers:user={firstname:user["firstname"],lastname:user["lastname"],username:user["username"],password:user["password"],age:user["age"],gender:user["gender"],email:user["email"],state:user["state"],area:user["area"],pincode:user["pincode"],weight:user["weight"],bloodgroup:user["bloodgroup"],contactnumber:user["contactnumber"]}
    this.addUsers(NewUsers).subscribe(data=>{
      this.userExists=data;
      if(data)
      {
        this.router.navigate(['login'])
      }
    },
    (error)=>{
      console.log(error)
    }
    )
}
addUsers(user:user):Observable<any>
  {
    return this.httpclient.post<user>(environment.baseUrl+'users',user)
  }
}
