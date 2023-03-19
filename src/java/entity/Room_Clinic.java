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
public class Room_Clinic {
    private int roomID;
    private int departmentID;
    private int doctorID;

    public Room_Clinic() {
    }

    public Room_Clinic(int roomID, int departmentID, int doctorID) {
        this.roomID = roomID;
        this.departmentID = departmentID;
        this.doctorID = doctorID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
    
    
}
