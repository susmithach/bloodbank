import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';
import { BloodbankServiceService } from 'src/bloodbank-service.service';
import { slot } from '../slot';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router,private authservice:AuthServiceService,private bloodservice:BloodbankServiceService) { }
  slotForm:FormGroup;
  slotbook:boolean=false;
    ngOnInit() {
    
      this.slotForm = this.formBuild.group({
        hospital: ['',[
          Validators.required
        ]],
        city: ['',[
          Validators.required
        ]],
        date:['',[Validators.required]],
        time:['',[Validators.required]]
      })
    }
  get hospital()
  {
    return this.slotForm.get('hospital');
  }
  get city()
  {
    return this.slotForm.get('city');
  }
  get date()
  {
    return this.slotForm.get('date');
  }
  get time()
  {
    return this.slotForm.get('time');
  }
  result:boolean=false;
  requestslot()
  {
    let NewSlot:slot={hospital:this.slotForm.value["hospital"],
    city:this.slotForm.value["city"],
    date:this.slotForm.value["date"],
    time:this.slotForm.value["time"]};
     this.bloodservice.requestForSlot(NewSlot).subscribe(data=>{
    this.result=true;
      this.router.navigate(['slot'])}, 
     (error)=>{
      console.log(error);
      console.log("slot already exists");
      this.slotbook=true;
    })
  }
}
