import { Routes } from '@angular/router';
import { DepartmentComponent } from "./department/department.component";

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'departments',
    pathMatch: 'full'
  },
  {
    path: 'departments',
    pathMatch: 'prefix',
    component: DepartmentComponent
  }
];
