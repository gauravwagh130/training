import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  imports: [FormsModule],
  templateUrl: './calculator.html',
  styleUrl: './calculator.css',
})
export class Calculator {
  firstNumber: number;
  secondNumber: number;
  result: number;

  sum() {
    this.result = this.firstNumber + this.secondNumber;
  }

  sub() {
    this.result = this.firstNumber - this.secondNumber;
  }

  mult() {
    this.result = this.firstNumber * this.secondNumber;
  }

  constructor() {}
}
