import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Event } from 'src/app/event/Event';
import { HttpClient } from '@angular/common/http';
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { flatten } from '@angular/compiler';
import { mapTo } from 'rxjs/internal/operators/mapTo';
import { EventInterface } from 'src/app/event/event-interface';
import { stringify } from 'querystring';
// import {Http,Response} from '@angular/http';



const url = "http://localhost:8081/getallevents";
@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http:HttpClient) { }

  //events: Event[];

  getAllEvents(): Observable<EventInterface[]> {
  
    return this.http.get(url);
  
  }
}
