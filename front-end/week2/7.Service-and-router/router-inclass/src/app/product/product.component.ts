import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss'],
})
export class ProductComponent implements OnInit {
  value: Number;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
    this.value = parseInt(this.activatedRoute.snapshot.params.id);
    alert(this.value);
  }

  ngOnInit(): void {}
  goToEmployee = () => {
    this.router.navigateByUrl('/employee');
  };
}
