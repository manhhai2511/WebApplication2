/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MSI_PRO
 */
public class Patient {
    private int accountID;
    private int doctorID;
    private int roomNumber;
    private int bedNumber;
    private float cost;
    private String dateIn;
    private String dateOut;
    private String note;

    public Patient() {
    }

    public Patient(int accountID, int doctorID, int roomNumber, int bedNumber, float cost, String dateIn, String dateOut, String note) {
        this.accountID = accountID;
        this.doctorID = doctorID;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.cost = cost;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
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

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Patient{" + "accountID=" + accountID + ", doctorID=" + doctorID + ", roomNumber=" + roomNumber + ", bedNumber=" + bedNumber + ", cost=" + cost + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", note=" + note + '}';
    }
    
    
}
