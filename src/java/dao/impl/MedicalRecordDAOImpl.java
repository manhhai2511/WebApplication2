/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.MedicalRecordDAO;
import entity.MedicalRecord;
import entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MedicalRecordDAOImpl extends DBContext implements MedicalRecordDAO{

    @Override
    public ArrayList<MedicalRecord> getAll() throws Exception {

           ArrayList<MedicalRecord> list = new ArrayList<>();
        String sql = "  select * from Medical_Record";
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
                MedicalRecord R = new MedicalRecord();
                R.setMedical_ID(rs.getInt("ID_medical"));
                R.setDoctorID(rs.getInt("DoctorID"));
                R.setPtID(rs.getInt("PtID"));
                R.setDate_in(rs.getString("Date_in"));
                R.setDate_in(rs.getString("Date_out"));
                R.setContent(rs.getString("Content"));
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

    @Override
    public MedicalRecord getMedicalRecordByPtID(String ptID) throws Exception {
        String sql = "  SELECT * FROM Medical_Record where PtID = ?";
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        MedicalRecord P = new MedicalRecord();
        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();

            conn = getConnection();
            prepare = conn.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(ptID));
            rs = prepare.executeQuery();
            while (rs.next()) {
               P.setMedical_ID(rs.getInt("ID_medical"));
               P.setDoctorID(rs.getInt("DoctorID"));
               P.setPtID(rs.getInt("PtID"));
               P.setDate_in(rs.getString("Date_in"));
               P.setDate_out(rs.getString("Date_out"));
               P.setContent(rs.getString("Content"));
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
