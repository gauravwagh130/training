import { Routes } from '@angular/router';
import { Menu } from './menu/menu';
import { UserShow } from './user-show/user-show';
import { UserSearch } from './user-search/user-search';
import { EmployShow } from './employ-show/employ-show';
import { EmploySearch } from './employ-search/employ-search';

export const routes: Routes = [
    {path:'',component:Menu},
    {path:'menu',component:Menu},
    {path:'menu',component:Menu,children:[
        {path:'usershow',component:UserShow,outlet:'virtusa'},
        {path:'usersearch',component:UserSearch,outlet:'virtusa'},
        {path:'employshow',component:EmployShow,outlet:'virtusa'},
        {path:'employsearch',component:EmploySearch,outlet:'virtusa'},
        
    ]}
];
