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

  events: EventInterface;
  test: Event[];

  ngOnInit() {
    this.eventService.getAllEvents().subscribe(data => {

      this.events = data;
      this.events = JSON.parse(JSON.stringify(data));
      console.log("the value of event ", this.test, " type", typeof (this.events));
    }, (error) => {
      alert("Error: " + error.statusText)
    });

  }

}
