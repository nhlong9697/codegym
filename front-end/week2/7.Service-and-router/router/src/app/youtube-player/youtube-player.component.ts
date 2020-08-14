import { Component, OnInit, OnDestroy } from '@angular/core';
import { YoutubeService } from '../service//youtube.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-youtube-player',
  templateUrl: './youtube-player.component.html',
  styleUrls: ['./youtube-player.component.css'],
})
export class YoutubePlayerComponent implements OnInit, OnDestroy {
  song: any;
  sub: Subscription;
  constructor(
    private youtubeService: YoutubeService,
    private activatedRoute: ActivatedRoute,
    private domSanitizer: DomSanitizer
  ) {}

  ngOnInit(): void {
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      //get song id
      const id = paramMap.get('id');
      //use service to find id
      this.song = this.youtubeService.find(id);
    });
    console.log(this.sub);
  }

  getSrc() {
    const url = 'https://www.youtube.com/embed/' + this.song.id;
    console.log(this.domSanitizer.bypassSecurityTrustResourceUrl(url));
    return this.domSanitizer.bypassSecurityTrustResourceUrl(url);
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
