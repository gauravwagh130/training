import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserShow } from './user-show/user-show';
import { HttpClientModule } from '@angular/common/http';
import { UserSearch } from './user-search/user-search';
import { EmployShow } from './employ-show/employ-show';
import { EmploySearch } from './employ-search/employ-search';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserShow, HttpClientModule, UserSearch,EmployShow,EmploySearch],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('AngServiceEx');
}
