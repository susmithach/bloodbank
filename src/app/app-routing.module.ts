import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { RequestbloodComponent } from './requestblood/requestblood.component';


const routes: Routes = [ { path: 'signup', component: SignupComponent},
{path: 'login',component:LoginComponent},
{path:'home',component:HomeComponent},
{path:'search',component:SearchComponent},
{path:'request',component:RequestbloodComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
