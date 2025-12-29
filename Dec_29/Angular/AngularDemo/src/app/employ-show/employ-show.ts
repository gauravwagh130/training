import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Employ } from '../employ';

@Component({
  selector: 'app-employ-show',
  imports: [FormsModule, NgFor],
  templateUrl: './employ-show.html',
  styleUrl: './employ-show.css',
})
export class EmployShow {
  employs = [
    new Employ(1, "Sabari","Java","programmer",88423),
    new Employ(2, "Stuti","Angular","programmer",90042),
    new Employ(3, "Santhiya","SB","TeamLead",95224),
    new Employ(4, "Namassivayam","Java","Manager",90522),
    new Employ(5, "Sai Sushma","Sql","Expert",98822),
    new Employ(6, "Sadarch","Dotnet","Tester",98822)
  ]
}
