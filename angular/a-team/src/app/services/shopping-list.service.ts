import { EventEmitter, Injectable } from '@angular/core';
import { Ingredient } from '../shared/components/ingredient/ingredient.component';

@Injectable()
export class ShoppingListService {
  public ingredientCreated: EventEmitter<Ingredient> = new EventEmitter();
 // public ingredientsChanged: EventEmitter<Ingredient[]> = new EventEmitter();

  private ingredients: Ingredient[] = [
    new Ingredient('tomatoes', 3),
    new Ingredient('cheese', 1),
    new Ingredient('potatoes', 2)
  ];

  constructor() {}

  public getIngredients(): Promise<Ingredient[]> {
    return new Promise<Ingredient[]>((resolve, reject) => {
      resolve(this.ingredients);
    });
  }

  public addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
   // this.ingredientsChanged.emit(this.ingredients.slice());
  }

  public removeIngredient(index: number) {
    this.ingredients.splice(index, 1);
   // this.ingredientsChanged.emit(this.ingredients.slice());
  }

  public addIngredients(ingredients: Ingredient[]): void {
    this.ingredients.push(...ingredients);
    // this.ingredientsChanged.emit(this.ingredients.slice());
  }

}
