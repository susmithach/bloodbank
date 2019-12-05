import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthServiceService } from '../auth-service.service';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { request } from '../request';
import { Router } from '@angular/router';


@Component({
  selector: 'app-requestblood',
  templateUrl: './requestblood.component.html',
  styleUrls: ['./requestblood.component.css']
})
export class RequestbloodComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router,private authservice:AuthServiceService,private bloodservice:BloodbankServiceService) { }
requestForm:FormGroup;
  ngOnInit() {
  
    this.requestForm = this.formBuild.group({
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
  return this.requestForm.get('bloodgroup');
}
get state()
{
  return this.requestForm.get('state');
}
get area()
{
  return this.requestForm.get('area');
}
get pincode()
{
  return this.requestForm.get('pincode');
}
get contactnumber()
{
  return this.requestForm.get('contactnumber');
}
requestBlood()
{
  let NewRequest:request={bloodgroup:this.requestForm.value["bloodgroup"],
  state:this.requestForm.value["state"],
  pincode:this.requestForm.value["pincode"],
  area:this.requestForm.value["area"],
  contactnumber:this.requestForm.value["contactnumber"]};
   this.bloodservice.requestForBlood(NewRequest).subscribe(data=>{
    window.alert("request registered successfully") 
    this.router.navigate(['search'])})
}
}
