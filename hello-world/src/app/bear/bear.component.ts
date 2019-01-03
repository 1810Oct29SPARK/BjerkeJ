import { Component, OnInit } from '@angular/core';
import { BearService } from '../services/bear.service';
import { Bear } from '../models/bear.model';

@Component({
  selector: 'app-bear',
  templateUrl: './bear.component.html',
  styleUrls: ['./bear.component.css']
})
export class BearComponent implements OnInit {

  private bears: Bear[];

  //inject service by providing it as a constructor argument
  constructor(private bearService: BearService)
  {

  }

  //for Property Binding
  public objectStyle = 
  {
    color: 'red',
    border: '2px solid black',
    cursor: 'pointer',
    margin: '2px'
  };

  public changeStyles(): void
  {
    if(this.objectStyle.color === 'red')
    {
      this.objectStyle.color = 'blue';
      this.objectStyle.border = '2px solid orange';
    } else if (this.objectStyle.color === 'blue')
    {
      this.objectStyle.color = 'green';
      this.objectStyle.border = '2px solid blue';
    } else
    {
      this.objectStyle.color = 'red';
      this.objectStyle.border = '2px solid black';
    }
  };

    //for two-way binding
    public twoWayValue = '';

  ngOnInit() 
  {
    this.bears = this.bearService.getBears();
    console.log(this.bears);
  }

}
