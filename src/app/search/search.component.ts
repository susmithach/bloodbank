import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router) { }
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
}
