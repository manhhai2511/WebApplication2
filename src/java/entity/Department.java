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
public class Department {
    private int departmentID;
    private String departmentName;
    private String detail;
    private String note;

    public Department() {
    }

    public Department(int departmentID, String departmentName, String detail, String note) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.detail = detail;
        this.note = note;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", departmentName=" + departmentName + ", detail=" + detail + ", note=" + note + '}';
    }

    
    
}
