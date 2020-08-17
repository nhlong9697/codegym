import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageGalleryModule } from './image-gallery/image-gallery.module';
import { GalleryConfig } from './image-gallery/token';
import { ContentProjectionModule } from './content-projection/content-projection.module';
import { AuthService } from './service/auth.service';

@NgModule({
  declarations: [AppComponent],
  //import other modules
  imports: [
    BrowserModule,
    AppRoutingModule,
    ImageGalleryModule,
    ContentProjectionModule,
  ],
  providers: [
    { provide: GalleryConfig, useValue: 2 },
    { provide: AuthService, useClass: AuthService },
    { provide: 'API_ENDPOINT', useValue: 'http://api.example.com' },
    { provide: 'API_URL', useExisting: 'API_ENDPOINT' },
    {
      provide: 'some_token',
      useFactory: () => {
        return Math.random();
      },
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
