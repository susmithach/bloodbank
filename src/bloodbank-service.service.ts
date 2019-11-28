import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthServiceService } from './app/auth-service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { user } from './app/user';
import { environment } from './environments/environment';
import { request } from './app/request';

@Injectable({
  providedIn: 'root'
})
export class BloodbankServiceService {
userdata:user;
isLoggedIn=false;
  constructor(private router:Router,private httpClient: HttpClient,private authservice:AuthServiceService)
   {



    }
    /*getdonor():Observable<any>
    {
      if(this.authservice.loggedIn)
    {
      this.isLoggedIn=true;
      const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
      return this.httpClient.get<user>(environment.baseUrl+"/donate",{headers})
    }
    }*/
    requestForBlood(req:request):Observable<request>
  {
    const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
   return this.httpClient.post<request>(environment.baseUrl+'request'+'/'+this.authservice.loggedInUser,req,{headers});
  }
}
