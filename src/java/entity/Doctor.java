/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author msi
 */
public class Doctor {
    private  int AccountID;
    private int DepartmentID; 
    private String PositionDoctor;
    private String DateIn;
    private  String DateOut;
    private float Salary;
    private int Experience;
    private String Certificate;
    private String FullName;
    

    public Doctor() {
    }

    public Doctor(int AccountID, int DepartmentID, String PositionDoctor, String DateIn, String DateOut, float Salary, int Experience, String Certificate, String FullName) {
        this.AccountID = AccountID;
        this.DepartmentID = DepartmentID;
        this.PositionDoctor = PositionDoctor;
        this.DateIn = DateIn;
        this.DateOut = DateOut;
        this.Salary = Salary;
        this.Experience = Experience;
        this.Certificate = Certificate;
        this.FullName = FullName;
    }



   

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    
    

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getPositionDoctor() {
        return PositionDoctor;
    }

    public void setPositionDoctor(String PositionDoctor) {
        this.PositionDoctor = PositionDoctor;
    }

    public String getDateIn() {
        return DateIn;
    }

    public void setDateIn(String DateIn) {
        this.DateIn = DateIn;
    }

    public String getDateOut() {
        return DateOut;
    }

    public void setDateOut(String DateOut) {
        this.DateOut = DateOut;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public String getCertificate() {
        return Certificate;
    }

    public void setCertificate(String Certificate) {
        this.Certificate = Certificate;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    @Override
    public String toString() {
        return "Doctor{" + "AccountID=" + AccountID + ", DepartmentID=" + DepartmentID + ", PositionDoctor=" + PositionDoctor + ", DateIn=" + DateIn + ", DateOut=" + DateOut + ", Salary=" + Salary + ", Experience=" + Experience + ", Certificate=" + Certificate + ", FullName=" + FullName + '}';
    }

    
    


}
