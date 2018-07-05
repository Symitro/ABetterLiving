import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { AllTasksPage } from '../pages/all-tasks/all-tasks';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = LoginPage;
  
  pages: Array<{title: string, icon: string, component: any}>;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.pages = [
      { title: 'Home', icon: 'home' , component: HomePage },
      { title: 'Alle', icon: 'apps' ,component: AllTasksPage },
      { title: 'Heute', icon: 'clock' , component: HomePage },
      { title: 'Markiert', icon: 'star' , component: HomePage },
      { title: 'Projekte', icon: 'folder-open' , component: HomePage },
      { title: 'Erledigt', icon: 'checkmark-circle' , component: HomePage }
    ];

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }

  public logout(){
      localStorage.removeItem('jwt_token');
      localStorage.removeItem('jwt_token_expires');
      this.nav.setRoot('LoginPage');
  }

}
