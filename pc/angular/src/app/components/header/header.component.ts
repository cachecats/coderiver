import { Component, OnInit } from '@angular/core';

interface ISection {
  title: string;
  link: string;
}

interface INav {
  root: ISection;
  sections: ISection[];
}

@Component({
  selector: 'app-header',
  templateUrl: './header.component.pug',
  styleUrls: ['./header.component.less']
})
export class HeaderComponent implements OnInit {
  nav: INav = {
    root: {title: 'Recipe Book', link: 'recipes'},
    sections: [
      {title: 'Recipes', link: 'recipes'},
      {title: 'Shopping List', link: 'shopping-list'}
    ]
  };

  constructor() { }

  ngOnInit() {
  }
}
