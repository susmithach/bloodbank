import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { donate } from '../donate';


@Component({
  selector: 'app-donateblood',
  templateUrl: './donateblood.component.html',
  styleUrls: ['./donateblood.component.css']
})
export class DonatebloodComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router,private bloodservice:BloodbankServiceService) { }
donateForm:FormGroup;
  ngOnInit() {
  
    this.donateForm = this.formBuild.group({
      bloodgroup: ['',[
        Validators.required
      ]],
      state: ['',[
        Validators.required
      ]],
      area:['',[Validators.required]],
      pincode:['',[Validators.required,Validators.min(100000),Validators.max(999999)]],
      contactnumber:['',[Validators.required,Validators.minLength(10)]]
    })
  }
get bloodgroup()
{
  return this.donateForm.get('bloodgroup');
}
get state()
{
  return this.donateForm.get('state');
}
get area()
{
  return this.donateForm.get('area');
}
get pincode()
{
  return this.donateForm.get('pincode');
}
get contactnumber()
{
  return this.donateForm.get('contactnumber');
}
donateblood()
{
  let NewDonate:donate={bloodgroup:this.donateForm.value["bloodgroup"],
  state:this.donateForm.value["state"],
  pincode:this.donateForm.value["pincode"],
  area:this.donateForm.value["area"],
  contactnumber:this.donateForm.value["contactnumber"]};
   this.bloodservice.addDonateBloood(NewDonate).subscribe(data=>{this.router.navigate(['slot'])});
 
}
}
