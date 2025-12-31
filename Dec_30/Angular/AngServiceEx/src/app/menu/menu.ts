import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-menu',
  standalone:true,
  imports: [RouterOutlet,RouterModule],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {

}
