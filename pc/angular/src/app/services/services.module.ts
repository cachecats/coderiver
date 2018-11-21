import { NgModule } from '@angular/core';
import { RecipesService } from './recipes.service';
import { ShoppingListService } from './shopping-list.service';
import { AuthService } from './auth.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [HttpClientModule],
  providers: [AuthService, RecipesService, ShoppingListService]
})
export class ServicesModule {}
