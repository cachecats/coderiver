import { Component, OnInit } from '@angular/core';
import { RecipeItem } from '../recipes-list/recipe-item/recipe-item.component';
import { RecipesService } from '../../../services/recipes.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.pug',
  styleUrls: ['./recipe-details.component.less']
})
export class RecipeDetailsComponent implements OnInit {
  recipe: RecipeItem;
  id: number;

  constructor(
    private readonly recipesService: RecipesService,
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.id = +params.id;
      this.recipe = this.recipesService.getRecipe(this.id);
    });
  }

  onAddToShoppingList(): void {
    this.recipesService.addIngredientsToShoppingList(this.recipe.ingredients);
  }

  onDeleteRecipe(): void {
    this.recipesService.removeRecipe(this.id);
    this.router.navigate(['../'], {relativeTo: this.route});
  }
}
