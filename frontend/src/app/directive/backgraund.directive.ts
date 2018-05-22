import {Directive, HostListener, HostBinding, ElementRef} from '@angular/core';

@Directive({
  selector: '[listBackground]'
})
export class BackgroundDirective {

  @HostBinding('style.backgroundColor') background: string;

  @HostListener('mouseenter') mouseEnter() {
    this.background = '#F5F5F5';
  }

  @HostListener('mouseleave') mouseLeave() {
    this.background = 'transparent';
  }

}
