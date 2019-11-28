import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm: FormGroup;
  categories:["male","female"];
  constructor(private formBuilder:FormBuilder,private userService:UserServiceService) { }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      username : ['',[
        Validators.required,
        this.isUsernameTaken
      ]],
      firstname:['',[
        Validators.required
      ]],
      lastname:['',[
        Validators.required
      ]],
      password:['',[
        Validators.required
      ]],
      confirmPassword:['',[
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]],
     age:['',[Validators.required,Validators.min(21),Validators.max(60)]],
     gender:['',[Validators.required]],
    contactnumber:['',[Validators.required,Validators.minLength(10)]],
    weight:['',[Validators.required]],
    bloodgroup:['',[Validators.required]],
    area:['',[Validators.required]],
    state:['',[Validators.required]],
    pincode:['',[Validators.required,Validators.min(100000),Validators.max(999999)]],
email:['',[Validators.required]],
    })



  }

  get f() { return this.signUpForm.controls; }
  get username() {
    return this.signUpForm.get('username');
  }
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }
  get age() {
    return this.signUpForm.get('age');
  }
  get gender() {
    return this.signUpForm.get('gender');
  }
  get contactnumber() {
    return this.signUpForm.get('contactnumber');
  }
  get weight() {
    return this.signUpForm.get('weight');
  }
  get bloodgroup()
  {
    return this.signUpForm.get('bloodgroup');
  }
  get area()
  {
    return this.signUpForm.get('area');
  }
  get state()
{
  return this.signUpForm.get('state');
}
get pincode()
{
  return this.signUpForm.get('pincode');
}
get email()
{
  return this,this.signUpForm.get('email');
}
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
      if (formControl.value === 'admin') {
          return { 'userNameTaken': true };
        } else {
          return null;
        }
      }

}
