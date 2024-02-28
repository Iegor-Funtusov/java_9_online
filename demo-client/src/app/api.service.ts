import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Observable} from "rxjs";
import {DepartmentData} from "./model/department.data";
import {EmployeeData} from "./model/employee.data";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  departmentById(id: number): Observable<DepartmentData> {
    return this.http.get<DepartmentData>(`http://localhost:8080/rest/departments/${id}`);
  }

  employeesByDepartment(id: number): Observable<EmployeeData[]> {
    return this.http.get<EmployeeData[]>(`http://localhost:8080/rest/departments/${id}/employees`);
  }
}
