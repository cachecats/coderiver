import { Component, Input, HostBinding } from '@angular/core';

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'setting-drawer-item',
  templateUrl: './setting-drawer-item.component.pug',
  preserveWhitespaces: false,
})
export class SettingDrawerItemComponent {
  i: any = {};

  @HostBinding('class')
  defaultClass = 'setting-drawer__body-item';

  @Input()
  set data(val: any) {
    this.i = val;
    if (val.type === 'px') {
      this.pxVal = +val.value.replace('px', '');
    }
  }

  pxVal: number;
  pxChange(val: number) {
    this.i.value = `${val}px`;
  }
  format = (value: any) => `${value} px`;
}
