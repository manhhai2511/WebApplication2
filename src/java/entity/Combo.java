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
public class Combo {
    private int comboID;
    private String comboName;
    private float cost;
    private String description;
    private int scheduleID;

    public Combo() {
    }

    public Combo(int comboID, String comboName, float cost, String description, int scheduleID) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.cost = cost;
        this.description = description;
        this.scheduleID = scheduleID;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }
    
    
}
