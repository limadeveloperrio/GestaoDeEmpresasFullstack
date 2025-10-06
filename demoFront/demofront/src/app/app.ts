import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './util/navbar/navbar';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Navbar],
  template: `
    <app-navbar></app-navbar>
    <div class="container mt-3">
      <router-outlet></router-outlet>
    </div>
  `
})
export class App {}
