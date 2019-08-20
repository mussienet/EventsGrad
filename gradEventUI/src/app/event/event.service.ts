import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Event } from 'src/app/event/Event';
import { HttpClient } from '@angular/common/http';
import { EventInterface } from 'src/app/event/event-interface';


const url = "http://localhost:8081/getallevents";
@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) { }


  getAllEvents(): Observable<EventInterface> {

    return this.http.get<EventInterface>(url);
    
  }
}
