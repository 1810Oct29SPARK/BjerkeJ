import { Component, OnInit } from '@angular/core';
import { DogService } from '../dog.service';

@Component({
  selector: 'app-dog',
  templateUrl: './dog.component.html',
  styleUrls: ['./dog.component.css']
})
export class DogComponent implements OnInit {

  imgURL: string;

  constructor(private dogService: DogService) { }

  ngOnInit() {
  }

  getDog(){
    this.dogService.getRandomDog().subscribe( (e) => {
      this.imgURL = e.message;
    });
  }
}
