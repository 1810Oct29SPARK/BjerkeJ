import { Component } from '@angular/core';

//Component directive - this decorator defines the AppComponent class to be a component (reusable)
@Component({
  //tag namem for the custom HTMLelement representing this component
  selector: 'app-root',
  //the template
  templateUrl: './app.component.html',
  //style sheets
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hello-world';
}
