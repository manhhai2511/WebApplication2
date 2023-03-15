/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Doctor {
    
    private int accountID;
    private int departmentID;
    private String position_Doctor;
    private String date_in;
    private String date_out;
    private float salary;
    private int experience;
    private String certificate;
    private String FullName;


    public Doctor() {
    }

    public Doctor(int accountID, int departmentID, String position_Doctor, String date_in, String date_out, float salary, int experience, String certificate) {
        this.accountID = accountID;
        this.departmentID = departmentID;
        this.position_Doctor = position_Doctor;
        this.date_in = date_in;
        this.date_out = date_out;
        this.salary = salary;
        this.experience = experience;
        this.certificate = certificate;
    }
    public Doctor(int AccountID, int DepartmentID, String PositionDoctor, String DateIn, String DateOut, float Salary, int Experience, String Certificate, String FullName) {
        this.accountID = AccountID;
        this.departmentID = DepartmentID;
        this.position_Doctor = PositionDoctor;
        this.date_in = DateIn;
        this.date_out = DateOut;
        this.salary = Salary;
        this.experience = Experience;
        this.certificate = Certificate;
        this.FullName = FullName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getPosition_Doctor() {
        return position_Doctor;
    }

    public void setPosition_Doctor(String position_Doctor) {
        this.position_Doctor = position_Doctor;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getCertificate() {
        return certificate;
    }
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;

    }
    
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Doctor: "+getAccountID();//To change body of generated methods, choose Tools | Templates.
    }
    
}
