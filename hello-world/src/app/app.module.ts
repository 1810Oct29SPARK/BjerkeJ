import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { BearComponent } from './bear/bear.component';
import { BearService } from './services/bear.service';

@NgModule({
  // What components are present in the module
  declarations: [
    BearComponent
  ],
  //Other modules which this module depends on
  imports: [
    BrowserModule,
    FormsModule
  ],
  //Services which will be shared by all components
  providers: [BearService],
  //Which components should be initialized at app start
  bootstrap: [BearComponent]
})
export class AppModule { }
