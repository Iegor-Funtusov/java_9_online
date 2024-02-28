import { Component } from '@angular/core';
import { Observable } from "rxjs";
import { ApiService } from "../api.service";
import { DepartmentData } from "../model/department.data";
import { EmployeeData } from "../model/employee.data";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-department',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  templateUrl: './department.component.html',
})
export class DepartmentComponent {

  department$: Observable<DepartmentData> = this.api.departmentById(1);
  employees$: Observable<EmployeeData[]> = this.api.employeesByDepartment(1);

  constructor(private api: ApiService) {
  }
}
