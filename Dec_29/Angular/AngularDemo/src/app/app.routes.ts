import { Routes } from '@angular/router';
import { Menu } from './menu/menu';

import { OneWay } from './one-way/one-way';
import { ButtonEx } from './button-ex/button-ex';
import { Calculator } from './calculator/calculator';
import { Condition } from './condition/condition';
import { SwitchEx } from './switch-ex/switch-ex';
import { EmployShow } from './employ-show/employ-show';
import { Login } from './login/login';

export const routes: Routes = [
  { path: '', component: Login },
  {
    path: 'menu',
    component: Menu,
    children: [
      { path: 'one-way', component: OneWay, outlet: 'Virtusa' },
      { path: 'button-ex', component: ButtonEx, outlet: 'Virtusa' },
      { path: 'calculator', component: Calculator, outlet: 'Virtusa' },
      { path: 'condition', component: Condition, outlet: 'Virtusa' },
      { path: 'switch-ex', component: SwitchEx, outlet: 'Virtusa' },
      { path: 'employ-show', component: EmployShow, outlet: 'Virtusa' },
    ],
  },
];
