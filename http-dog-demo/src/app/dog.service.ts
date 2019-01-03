import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DogService {

  /**
   * DI - Dependency Injection
   * Get the **HttpClientModule**
   * This will allow me to send requests
   */


  constructor(private http: HttpClient) { }

  getRandomDog(): Observable<any>{
    return this.http.get('https://dog.ceo/api/breeds/image/random')
  }
}
