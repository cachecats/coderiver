import { Component, HostBinding } from '@angular/core';

@Component({
  selector: 'layout-fullscreen',
  templateUrl: './fullscreen.component.pug',
})
export class LayoutFullScreenComponent {
  @HostBinding('class')
  defaultClass = 'alain-fullscreen';
}
