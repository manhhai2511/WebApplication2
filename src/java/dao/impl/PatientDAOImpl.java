/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.PatientDAO;
import entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PatientDAOImpl extends DBContext implements PatientDAO{

    @Override
    public ArrayList<Patient> getAllPatient() throws Exception{
        ArrayList<Patient> list = new ArrayList<>();
        String sql = "  SELECT * FROM Patient";
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();

            conn = getConnection();
            prepare = conn.prepareStatement(sql);
            rs = prepare.executeQuery();
            Patient P;
            while (rs.next()) {
                P = new Patient();
                P.setAccountID(rs.getInt("AccountID"));
                P.setDoctorID(rs.getInt("DoctorID"));
                P.setRoomNumber(rs.getInt("RoomNumber"));
                P.setBedNumber(rs.getInt("BedNumber"));
                P.setCost(rs.getFloat("Cost"));
                P.setDate_in(String.valueOf(rs.getDate("Date_in")));
                P.setDate_out(String.valueOf(rs.getDate("Date_out")));
                P.setNote(rs.getString("Note"));
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

    @Override
    public Patient getPatientByID(String Id) throws Exception {
        String sql = "  SELECT * FROM Patient where AccountID=?";
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        Patient P = new Patient();
        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();

            conn = getConnection();
            prepare = conn.prepareStatement(sql);
            prepare.setString(0, Id);
            rs = prepare.executeQuery();
            while (rs.next()) {
                P.setAccountID(rs.getInt("AccountID"));
                P.setDoctorID(rs.getInt("DoctorID"));
                P.setRoomNumber(rs.getInt("RoomNumber"));
                P.setBedNumber(rs.getInt("BedNumber"));
                P.setCost(rs.getFloat("Cost"));
                P.setDate_in(String.valueOf(rs.getDate("Date_in")));
                P.setDate_out(String.valueOf(rs.getDate("Date_out")));
                P.setNote(rs.getString("Note"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRS(rs);
            closePrepareStatement(prepare);
            closeConnection(conn);
        }
        return P;
    }
    
}
