import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { RecipeItem } from './recipes-list/recipe-item/recipe-item.component';
import { RecipesService } from '@services/recipes.service';
import { AuthService } from '@services/auth.service';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.pug',
  styleUrls: ['./recipes.component.less'],
  providers: [RecipesService]
})
export class RecipesComponent implements OnInit {
  recipes: RecipeItem[];
  inBrowser: boolean;

  emailFormControl = new FormControl('', [
    Validators.email,
    Validators.required
  ]);
  passwordFormControl = new FormControl('', [
    Validators.required
  ]);

  constructor(
    private readonly recipesService: RecipesService,
    private readonly authService: AuthService,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    @Inject(PLATFORM_ID) private readonly platformId: Object
  ) { }

  ngOnInit() {
    this.inBrowser = isPlatformBrowser(this.platformId);

    if (this.inBrowser) {
      this.route.queryParams.subscribe((params: Params) => {
        if (Object.keys(params).length) {
          // Facebook Login
          if (params.code && params.state) {
            this.authService.facebookSignIn(params.code)
              .subscribe(() => {
                  this.router.navigate(['/']);
                });
          } else if (params.oauth_token && params.oauth_verifier) {
            // Twitter Login
            this.authService.twitterSignIn(params.oauth_token, params.oauth_verifier)
              .subscribe(() => {
                  this.router.navigate(['/']);
                });
          } else if (params.code) {
            // Google Login
            this.authService.googleSignIn(params.code)
              .subscribe(() => {
                  this.router.navigate(['/']);
                });
          }
        }
      });

      this.recipesService.getRecipes()
        .then((recipes: RecipeItem[]) => this.recipes = recipes);
    }
  }

  testApi() {
    const request: XMLHttpRequest = new XMLHttpRequest();

    request.onload = (e: Event) => {
      console.log(e);
    };

    request.open('GET', 'api/getStuff', true);
    request.send();
  }

  signUp() {
    this.authService.signUp(this.emailFormControl.value, this.passwordFormControl.value);
  }

  signIn() {
    this.authService.signIn(this.emailFormControl.value, this.passwordFormControl.value);
  }

  getProtected() {
    this.authService.getProtected()
      .subscribe((res: any) => {
        console.log(res);
      });
  }

  facebookLogin() {
    this.authService.requestFacebookRedirectUri()
      .subscribe((response: {redirect_uri: string}) => {
        window.location.replace(response.redirect_uri);
      });
  }

  twitterLogin() {
    this.authService.requestTwitterRedirectUri()
      .subscribe((response: {redirect_uri: string}) => {
        window.location.replace(response.redirect_uri);
      });
  }

  googleLogin() {
    this.authService.requestGoogleRedirectUri()
      .subscribe((response: {redirect_uri: string}) => {
        window.location.replace(response.redirect_uri);
      });
  }
}
