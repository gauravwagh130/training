import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
// import { RouterOutlet } from "../../../node_modules/@angular/router/types/_router_module-chunk";
import { RouterTestingModule } from '@angular/router/testing';

@Component({
  selector: 'app-menu',
  imports: [RouterOutlet, RouterModule],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {
  constructor() {
    localStorage.clear();
  }
}
