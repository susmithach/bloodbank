import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { donate } from '../donate';
import { search1 } from '../search1';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router,private bloodservice:BloodbankServiceService) { }
  loginSearchForm :FormGroup;
  ngOnInit() {
    this.loginSearchForm = this.formBuild.group({
      state: ['',[
        Validators.required
      ]],
      area: ['',[
        Validators.required
      ]],
      pincode:['',[Validators.required,Validators.min(100000),Validators.max(999999)]],
      bloodgroup:['',[Validators.required]]
    })
  }
get state()
{
  return this.loginSearchForm.get('state')
}
get area()
{
  return this.loginSearchForm.get('area');
}
get pincode()
{
  return this.loginSearchForm.get('pincode');
}
get bloodgroup()
{
  return this.loginSearchForm.get('bloodgroup');
}
requestblood()
{
  this.router.navigate(['request']);
}
donateBlood()
{
  this.router.navigate(['donate']);
}
donatelist:donate[];



searchForBlood()
{
  let NewSearch:search1={bloodgroup:this.loginSearchForm.value["bloodgroup"],
  state:this.loginSearchForm.value["state"],
  pincode:this.loginSearchForm.value["pincode"],
  area:this.loginSearchForm.value["area"]};
  console.log(NewSearch)
   this.bloodservice.searchBlood(NewSearch).subscribe(data=>{this.donatelist=data
    console.log(data)
    this.bloodservice.donor=this.donatelist
  this.router.navigate(['requestlist'])
  })
  
}

}
