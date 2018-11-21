import { Component, Input, OnInit } from '@angular/core';
import { RecipeItem } from './recipe-item/recipe-item.component';

@Component({
  selector: 'app-recipes-list',
  templateUrl: './recipes-list.component.pug',
  styleUrls: ['./recipes-list.component.less']
})
export class RecipesListComponent implements OnInit {
  @Input() recipes: RecipeItem[];

  constructor() { }

  ngOnInit() {
  }
}
