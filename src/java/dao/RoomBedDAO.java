/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room_bed;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface RoomBedDAO {
    ArrayList<Room_bed> getAll() throws Exception;
}
