import { Directive, HostBinding, HostListener } from '@angular/core';

@Directive({
  selector: '[appDropdown]'
})
export class DropdownDirective {
  @HostBinding('class.open') isOpen = false;

  constructor(
  ) { }

  @HostListener('click') handleClick(e: Event): void {
    this.isOpen = !this.isOpen;
  }
}
