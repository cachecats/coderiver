import { NgModule } from '@angular/core';
import { CanDeactivateGuardService } from './can-deactivate-guard.service';
import { AuthGuardService } from './auth-guard.service';

@NgModule({
  providers: [AuthGuardService, CanDeactivateGuardService]
})
export class GuardsModule {}
