import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { request } from '../request';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router,private bloodservice:BloodbankServiceService,private authservice:AuthServiceService) { }
reqlst:request[];
check:boolean=false
  ngOnInit() {
    this.bloodservice.getrequest().subscribe(data=>this.reqlst=data)
    this.check=this.authservice.loggedIn;
  }
  register()
  {
    this.router.navigate(['signup'])
  }

}
