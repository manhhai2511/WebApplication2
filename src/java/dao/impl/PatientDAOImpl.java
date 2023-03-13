/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.DepartmentDAO;
import dao.PatientDAO;
import entity.Department;
import entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI_PRO
 */
public class PatientDAOImpl extends DBContext implements PatientDAO{

    @Override
    public List<Patient> getAll() throws Exception {
        List<Patient> list = new ArrayList<>();
        String sql = "  select * from Patient";
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
                Patient P = new Patient();
                P.setAccountID(rs.getInt(1));
                P.setDoctorID(rs.getInt(2));
                P.setRoomNumber(rs.getInt(3));
                P.setBedNumber(rs.getInt(4));
                P.setCost(rs.getFloat(5));
                P.setDateIn(rs.getString(6));
                P.setDateOut(rs.getString(7));
                P.setNote(rs.getString(8));

                list.add(P);
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
    
    public int deletePatient(int accountID) throws Exception {
        int n = 0;
        String sql = "delete from Product where AccountID = " + accountID;

//        Connection conn = null;
//        PreparedStatement prepare = null;
//        ResultSet rs = null;
        try {
            Statement state = getConnection().createStatement();

            state.executeUpdate(sql);

            n = state.executeUpdate("delete from Product where AccountID = " + accountID);
        } catch (SQLException ex) {
            throw ex;
        }
        return n;
    }

    
    
}
