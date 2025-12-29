import { Component } from '@angular/core';

@Component({
  selector: 'app-one-way',
  imports: [],
  templateUrl: './one-way.html',
  styleUrl: './one-way.css',
})
export class OneWay {
  topic: string;
  batch: string;
  company: string;

  constructor(){
    this.topic= "Angular 18"
    this.batch = "Batch 3"
    this.company = "Virtusa" 
  }

}
