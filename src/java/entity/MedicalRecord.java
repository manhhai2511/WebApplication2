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
public class MedicalRecord {
    private int medical_ID;
    private int doctorID;
    private int ptID;
    private String date_in;
    private String date_out;
    private String content;

    public MedicalRecord() {
    }

    public MedicalRecord(int medical_ID, int doctorID, int ptID, String date_in, String date_out, String content) {
        this.medical_ID = medical_ID;
        this.doctorID = doctorID;
        this.ptID = ptID;
        this.date_in = date_in;
        this.date_out = date_out;
        this.content = content;
    }

    public int getMedical_ID() {
        return medical_ID;
    }

    public void setMedical_ID(int medical_ID) {
        this.medical_ID = medical_ID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPtID() {
        return ptID;
    }

    public void setPtID(int ptID) {
        this.ptID = ptID;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Medical Record: "+getMedical_ID(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
