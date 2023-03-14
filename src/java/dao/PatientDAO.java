/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Patient;
import java.util.List;

/**
 *
 * @author MSI_PRO
 */
public interface PatientDAO {
    List<Patient> getAll() throws Exception;
    
    public int deletePatient(int accountID) throws Exception;
}
