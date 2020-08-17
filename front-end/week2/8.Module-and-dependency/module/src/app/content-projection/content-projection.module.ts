import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CpCardComponent } from './cp-card/cp-card.component';
import { ContentProjectionComponent } from './content-projection.component';
import { ContentChildComponent } from './content-child/content-child.component';

@NgModule({
  imports: [CommonModule],
  declarations: [
    CpCardComponent,
    ContentProjectionComponent,
    ContentChildComponent,
  ],
  //export the main component so that other module can use this component
  exports: [ContentProjectionComponent, ContentChildComponent],
})
export class ContentProjectionModule {}
