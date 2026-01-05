import { Routes } from '@angular/router';
import { Menu } from './menu/menu';
import { EmployInsert } from './employ-insert/employ-insert';
import { EmployShow } from './employ-show/employ-show';
import { GenerateToken } from './generate-token/generate-token';
import { Showuser } from './showuser/showuser';

export const routes: Routes = [
  { path: '', component: Menu },
  {
    path: 'menu',
    component: Menu,
    children: [
      { path: 'employAdd', component: EmployInsert, outlet: 'virtusa' },
      { path: 'employShow', component: EmployShow, outlet: 'virtusa' },
      { path: 'generateToken', component: GenerateToken, outlet: 'virtusa' },
      { path: 'showuser', component: Showuser, outlet: 'virtusa' },
    ],
  },
];
