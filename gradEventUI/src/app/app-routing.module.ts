import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventComponent } from './event/event.component';
import { EventDetailsComponent } from './event-details/event-details.component';


const routes: Routes = [
  { path: 'events', component: EventComponent },
  { path: 'event/:id', component: EventDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
