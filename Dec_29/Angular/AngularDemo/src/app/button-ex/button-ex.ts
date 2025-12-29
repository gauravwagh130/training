import { Component } from '@angular/core';

@Component({
  selector: 'app-button-ex',
  imports: [],
  templateUrl: './button-ex.html',
  styleUrl: './button-ex.css',
})
export class ButtonEx {
  gaurav(){
   this.result = "Hi I am Gaurav..."
  }
  ram(){
   this.result = "Hi I am Ram..."
  }
  akay(){
   this.result = "Hi I am Akay..."
  }
  result : string
}
