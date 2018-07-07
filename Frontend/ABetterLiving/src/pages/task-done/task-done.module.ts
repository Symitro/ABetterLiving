import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TaskDonePage } from './task-done';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [
    TaskDonePage
  ],
  imports: [
    IonicPageModule.forChild(TaskDonePage),
    ComponentsModule
  ],
})
export class TaskDonePageModule {}
