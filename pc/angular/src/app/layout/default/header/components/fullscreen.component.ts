import { Component, HostListener, HostBinding } from '@angular/core';
// import * as screenfull from 'screenfull';
const screenfull = require('screenfull');

@Component({
  selector: 'header-fullscreen',
  template: `
    <i nz-icon [type]="status ? 'fullscreen' : 'fullscreen-exit'"></i>
    {{ status ? '退出全屏' : '全屏' }}
  `,
})
export class HeaderFullScreenComponent {
  status = false;

  @HostBinding('class')
  defaultClass = 'd-block';

  @HostListener('window:resize')
  _resize() {
    this.status = screenfull.isFullscreen;
  }

  @HostListener('click')
  _click() {
    if (screenfull.enabled) {
      screenfull.toggle();
    }
  }
}
