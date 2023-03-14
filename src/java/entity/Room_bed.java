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
public class Room_bed {
    private int room;
    private int total_Bed;
    private int bed_Active;

    public Room_bed() {
    }

    public Room_bed(int room, int total_Bed, int bed_Active) {
        this.room = room;
        this.total_Bed = total_Bed;
        this.bed_Active = bed_Active;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getTotal_Bed() {
        return total_Bed;
    }

    public void setTotal_Bed(int total_Bed) {
        this.total_Bed = total_Bed;
    }

    public int getBed_Active() {
        return bed_Active;
    }

    public void setBed_Active(int bed_Active) {
        this.bed_Active = bed_Active;
    }

    @Override
    public String toString() {
        return "Room_Bed: "+getRoom(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
