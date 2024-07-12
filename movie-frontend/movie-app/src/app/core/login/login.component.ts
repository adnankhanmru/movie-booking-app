import { Component, inject } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { Router } from '@angular/router';

import { Masterservice } from '../services/master.service';

@Component({

 selector: 'app-login',

 standalone: true,

 imports: [FormsModule,Component],

 templateUrl: './login.component.html',

 styleUrl: './login.component.css'

})

export class LoginComponent {

 loginObj:any = {

  "emailId": "",

  "password": ""

 }

 masterSrv =inject(Masterservice);

 router = inject(Router);

 onLogin() {

  debugger;

  this.masterSrv.login(this.loginObj).subscribe((res:any)=>{

   debugger;

   if(res.result) {

    localStorage.setItem('ticketUser',JSON.stringify(res.data));

    this.router.navigateByUrl('dashboard');

   } else {

    alert(res.message)

   }

  })

 }

}

