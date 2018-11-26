import { EventEmitter, Injectable } from '@angular/core';
import { RecipeItem } from '../components/recipes/recipes-list/recipe-item/recipe-item.component';
import { Ingredient } from '../shared/components/ingredient/ingredient.component';
import { ShoppingListService } from './shopping-list.service';

@Injectable()
export class RecipesService {
  public readonly recipeSelected: EventEmitter<RecipeItem> = new EventEmitter();

  private readonly recipes: RecipeItem[] = [
    new RecipeItem('Ketchup', 'Homemade ketchup, old recipe!',
    'https://cdn.pixabay.com/photo/2015/08/11/20/43/tomato-885168_960_720.jpg', [
      new Ingredient('tomatoes', 10),
      new Ingredient('vinegar', 1),
      new Ingredient('salt', 1),
      new Ingredient('suggar', 1)
    ]),
    new RecipeItem('Pizza', 'Some delicious pizza yum!',
    'https://cdn.pixabay.com/photo/2017/09/19/20/41/pizza-2766568_960_720.jpg', [])
  ];

  constructor(
    private readonly shoppingListService: ShoppingListService
  ) { }

  public getRecipe(id: number): RecipeItem {
    return this.recipes[id];
  }

  public getRecipes(): Promise<RecipeItem[]> {
    return new Promise<RecipeItem[]>((resolve, reject) => {
      resolve(this.recipes);
    });
  }

  public addIngredientsToShoppingList(ingredients: Ingredient[]): void {
    this.shoppingListService.addIngredients(ingredients);
  }

  public removeRecipe(index: number): void {
    this.recipes.splice(index, 1);
  }
}
