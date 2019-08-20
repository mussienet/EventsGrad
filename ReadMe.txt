Angular
dir
 ng -v
ng --version

In terminal
ng new name
ng serve
ng g c name
ng g s name

bootstrap in the index.html of the app folder of src
copy the <app-root><app-root> from the newly created app into the <body> of the index.html of the app folder of src
copy any component of the selector into the app.component.html and past it i.e into the <router-outlet>

creat model class eg Event.ts and in the constructor pass all the parameters
and in the event.service.ts write a method eg getAllEvents(and pass http as a parameter) and return type as observable of Event
 where url is a constant.
on the onInit method write the following
 ngOnInit() {
 
   this.eventService.getAllEvents().subscribe(data => {
 
     console.log(data)
       
this.events = data;
   
 });

 
 }

use ng serve -o to run and open in browser