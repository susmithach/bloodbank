import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserServiceService } from './user-service.service';
import { environment } from 'src/environments/environment';
import { user } from './user';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  
  loggedInUser={loggedOut:true};
  validCredentials:boolean = true;
  accessToken: string; // JWT token
  redirectUrl = '/';
  loggedIn:boolean = false;
  name:string;
  baseUrl = environment.baseUrl;
  private token: string;
  error: string = "Login Failed";
  role:string;
  isAdmin:boolean = false;
  
  username:string;
  
  

  authenticateSpring(user:string,password:string):Observable<any> {
    let credentials = btoa(user+':'+password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials)
    return this.http.get(this.baseUrl+'authenticateService/authenticate', {headers})
  }
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  constructor(private userService:UserServiceService,public router: Router,private http:HttpClient) { }

  authenticateUser(user) {
    // for(let validUser of this.userService.userList){
    //   if(validUser.username == user.username && validUser.password == user.password){
    //     this.loggedInUser = user;
    //     this.validCredentials = true;
    //     if(user.username == 'admin')
    //       this.movieService.isAdmin = true;
    //     this.router.navigate(['search-bar']);
    //     this.loggedIn = true;
    //     this.movieService.isLoggedIn = true;
    //   }
    //   else
    //     this.validCredentials = false;
    // }

    this.authenticateSpring(user.username,user.password).subscribe(
      (data)=>{
        console.log(data)
        this.role=data.role;
        this.loggedInUser = user.username;
        this.validCredentials = true;
        if(data.role == 'ADMIN')
          this.isAdmin = true;
        this.loggedIn = true;
        // this.foodService.isLoggedIn = true;
        // this.setToken(data.token);
        this.accessToken=data.token;
        console.log(this.accessToken)
        window.alert("Login successfully")
       // this.router.navigate(['search-bar']);
       this.router.navigate(['search']);
      },
      (error)=>{
        this.validCredentials = false;
        console.log(error);
        console.log("ERROR");
      }
    )

  }
  logout() {
    // this.loggedInUser = {loggedOut:true};
    // this.movieService.isAdmin = false;
    // this.loggedIn = false;
    // this.movieService.isLoggedIn = false;
    // this.movieService.clickedOnAdd = false;
    // this.movieService.addedToFavorites = false;
    // this.Favoritesservice.clearcart();
    // this.router.navigate(['login']);
    // //  this.router.navigate(['search-bar']);

    this.loggedInUser = {loggedOut:true};
    this.isAdmin=false;
    this.loggedIn = false;

    this.router.navigate(['login']);
  }
}
