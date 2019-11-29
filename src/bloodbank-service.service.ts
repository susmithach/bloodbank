import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthServiceService } from './app/auth-service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { user } from './app/user';
import { environment } from './environments/environment';
import { request } from './app/request';
import { donate } from './app/donate';
import { slot } from './app/slot';
import { search1 } from './app/search1';

@Injectable({
  providedIn: 'root'
})
export class BloodbankServiceService {
userdata:user;
isLoggedIn=false;
donor:donate[];
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
  addDonateBloood(don:donate):Observable<donate>
  {
    const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
    return this.httpClient.post<donate>(environment.baseUrl+'donate'+'/'+this.authservice.loggedInUser,don,{headers});
  }
  requestForSlot(sl:slot):Observable<slot>
  {
    const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
    return this.httpClient.post<slot>(environment.baseUrl+'slot'+'/'+this.authservice.loggedInUser,sl,{headers});
  }
  searchBlood(se:search1):Observable<any>
  {
    const headers = new HttpHeaders({Authorization: 'Bearer ' +this.authservice.accessToken});
    return this.httpClient.post<donate[]>("http://localhost:8022/donate",se,{headers});
  }
}
