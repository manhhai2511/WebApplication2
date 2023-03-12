/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Employee;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface EmployeeDAO {
    public int addEmployees(Employee emp);
    public int updateEmployees(Employee emp);
    public Vector<Employee> listAllEmployees();
    public Vector<Employee> listAllEmployees(String sql);
    public Employee findById(int accountId);
}
