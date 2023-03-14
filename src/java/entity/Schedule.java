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
public class Schedule {
    private int schedule_ID;
    private int doctor_ID;
    private int ptID;
    private String date;
    private String time;
    private String content;
    private int room;
    private int departmentID;

    public Schedule() {
    }

    public Schedule(int schedule_ID, int doctor_ID, int ptID, String date, String time, String content, int room, int departmentID) {
        this.schedule_ID = schedule_ID;
        this.doctor_ID = doctor_ID;
        this.ptID = ptID;
        this.date = date;
        this.time = time;
        this.content = content;
        this.room = room;
        this.departmentID = departmentID;
    }

    public int getSchedule_ID() {
        return schedule_ID;
    }

    public void setSchedule_ID(int schedule_ID) {
        this.schedule_ID = schedule_ID;
    }

    public int getDoctor_ID() {
        return doctor_ID;
    }

    public void setDoctor_ID(int doctor_ID) {
        this.doctor_ID = doctor_ID;
    }

    public int getPtID() {
        return ptID;
    }

    public void setPtID(int ptID) {
        this.ptID = ptID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Schedule: "+getSchedule_ID(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
