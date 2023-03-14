/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.DoctorDAO;
import entity.Account;
import entity.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DoctorDAOImpl extends DBContext implements DoctorDAO{

    @Override
    public ArrayList<Doctor> getAll() throws Exception {
       ArrayList<Doctor> list = new ArrayList<>();
        String sql = "  select * from Doctor";
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
                Doctor U = new Doctor();
                U.setAccountID(rs.getInt("AccountID"));
                U.setDepartmentID(rs.getInt("DepartmentID"));
                U.setPosition_Doctor(rs.getString("Position_doctor"));
                U.setDate_in(rs.getString("date_in"));
                U.setDate_out(rs.getString("date_out"));
                U.setSalary(rs.getFloat("Salary"));
                U.setExperience(rs.getInt("Experience"));
                U.setCertificate(rs.getString("Certificate"));
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
