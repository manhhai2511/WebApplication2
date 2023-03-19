/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MedicalRecord;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface MedicalRecordDAO {
    
    ArrayList<MedicalRecord> getAll() throws Exception;
    
    MedicalRecord getMedicalRecordByPtID(String ptID) throws Exception;
    
    int updateMedicalRecord(MedicalRecord medicalRecord) throws Exception;
}
