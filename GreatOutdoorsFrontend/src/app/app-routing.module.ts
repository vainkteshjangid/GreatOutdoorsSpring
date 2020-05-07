import {Routes, RouterModule} from '@angular/router';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserLogoutComponent } from './user-logout/user-logout.component';
import { NgModule } from '@angular/core';
import { UserListComponent } from './user-list/user-list.component';
import { CartComponent } from './cart/cart.component';



const routes:Routes=[
    {path:'user/newUser',component:UserRegistrationComponent},
    {path:'user/login',component:UserLoginComponent},
    {path:'user/viewAll',component:UserListComponent},
    {path:'logout',component:UserLogoutComponent},
    {path:'cart/viewCart',component:CartComponent}
]

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{ };