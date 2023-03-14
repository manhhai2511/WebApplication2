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
public class Patient {
    private int accountID;
    private int doctorID;
    private int roomNumber;
    private int bedNumber;
    private float cost;
    private String date_in;
    private String date_out;
    private String note;

    public Patient() {
    }

    public Patient(int accountID, int doctorID, int roomNumber, int bedNumber, float cost, String date_in, String date_out, String note) {
        this.accountID = accountID;
        this.doctorID = doctorID;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.cost = cost;
        this.date_in = date_in;
        this.date_out = date_out;
        this.note = note;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Patient: "+getAccountID(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
