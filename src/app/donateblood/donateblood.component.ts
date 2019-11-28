import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-donateblood',
  templateUrl: './donateblood.component.html',
  styleUrls: ['./donateblood.component.css']
})
export class DonatebloodComponent implements OnInit {

  constructor(private formBuild:FormBuilder) { }
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
      contactnumber:['',Validators.required,Validators.minLength(10)]
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

}
