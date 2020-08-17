import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
@Component({
  selector: 'app-content-projection',
  templateUrl: './content-projection.component.html',
  styleUrls: ['./content-projection.component.scss'],
  //if re-declare AuthService the authService at this component will be different to
  //the authService at app.component
  //providers: [AuthService],
  viewProviders: [AuthService],
})
export class ContentProjectionComponent implements OnInit {
  constructor(public authService: AuthService) {}

  ngOnInit(): void {}
}
