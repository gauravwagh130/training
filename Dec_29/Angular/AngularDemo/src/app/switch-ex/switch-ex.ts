import { NgSwitch, NgSwitchCase, NgSwitchDefault } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-switch-ex',
  imports: [FormsModule, NgSwitch, NgSwitchCase, NgSwitchDefault],
  templateUrl: './switch-ex.html',
  styleUrl: './switch-ex.css',
})
export class SwitchEx {
  choice : number
}
