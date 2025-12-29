import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OneWay } from './one-way/one-way';
import { TwoWay } from './two-way/two-way';
import { ButtonEx } from './button-ex/button-ex';
import { Calculator } from './calculator/calculator';
import { Condition } from './condition/condition';
import { SwitchEx } from './switch-ex/switch-ex';
import { EmployShow } from './employ-show/employ-show';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, OneWay, TwoWay, ButtonEx, Calculator, Condition, SwitchEx, EmployShow],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('AngularDemo');
}
