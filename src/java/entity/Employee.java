/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;


/**
 *
 * @author Admin
 */
public class Employee {
    private int accountId;
    private int departmentId;
    private String positionEmp;
    private Date dateIn;
    private Date dateOut;
    private float salary;
    private int userManagementId;

    public Employee() {
    }

    public Employee(int accountId, int departmentId, String positionEmp, Date dateIn, Date dateOut, float salary, int userManagementId) {
        this.accountId = accountId;
        this.departmentId = departmentId;
        this.positionEmp = positionEmp;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.salary = salary;
        this.userManagementId = userManagementId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getPositionEmp() {
        return positionEmp;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public float getSalary() {
        return salary;
    }

    public int getUserManagementId() {
        return userManagementId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setPositionEmp(String positionEmp) {
        this.positionEmp = positionEmp;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setUserManagementId(int userManagementId) {
        this.userManagementId = userManagementId;
    }
}
