import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-condition',
  imports: [FormsModule, NgIf],
  templateUrl: './condition.html',
  styleUrl: './condition.css',
})
export class Condition {
  status : boolean

  constructor(){
    this.status = false
  }
}
