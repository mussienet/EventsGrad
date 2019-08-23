import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/event/event.service';
import { Event } from 'src/app/event/Event';
import { log } from 'util';
import { EventInterface } from 'src/app/event/event-interface';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  constructor(public eventService: EventService) { }

  // events: EventInterface;
  events: Event;


  ngOnInit() {
    this.eventService.getAllEvents().subscribe(data => {

      // this.events = data; // we can use this one too, they are all the same with the lower one
      this.events = JSON.parse(JSON.stringify(data));

      console.log("the value of event ", this.events, " type", typeof (this.events));

    }, (error) => {
      alert("Error: " + error.statusText)
    });

  }

}
