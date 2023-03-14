/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.RoomBedDAO;
import entity.Account;
import entity.Room_bed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoomBedDAOImpl extends DBContext implements RoomBedDAO{

    @Override
    public ArrayList<Room_bed> getAll() throws Exception{
        ArrayList<Room_bed> list = new ArrayList<>();
        String sql = "  select * from Room_bed";
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();

            conn = getConnection();
            prepare = conn.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()) {
                Room_bed R = new Room_bed();
                R.setRoom(rs.getInt("Room"));
                R.setBed_Active(rs.getInt("Bed_Active"));
                R.setTotal_Bed(rs.getInt("Total_Bed"));
                list.add(R);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRS(rs);
            closePrepareStatement(prepare);
            closeConnection(conn);
        }
        return list;
    }
    
}
