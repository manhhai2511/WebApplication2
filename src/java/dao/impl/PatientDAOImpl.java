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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI_PRO
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
                P.setDate_in(rs.getString(6));
                P.setDate_out(rs.getString(7));
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

    public static void main(String[] args) {
        PatientDAOImpl dao = new PatientDAOImpl();
        try {
            List<Patient> u = new ArrayList<Patient>();
            u = dao.getAll();
            System.out.println(u.isEmpty());
            for (Patient users : u) {
                System.out.println(users);
            }

        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
