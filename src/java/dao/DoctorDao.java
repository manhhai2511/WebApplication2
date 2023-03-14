/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Department;
import entity.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public interface DoctorDao {
    List<Doctor> getAllDoctor() throws Exception;
    ArrayList<Doctor> getDoctorList(int start, int end) throws Exception;
    int getTotalPage() throws Exception;
    void AddDoctor(String AccountID, String DepartmentID, String PositionDoctor, String DateIn, String DateOut,
            String Salary, String Experience, String Certificate, String FullName);
    
//    void AddDoctorTest2( String PositionDoctor, String DateIn, String DateOut,
//            String Salary, String Experience, String Certificate, String FullName);
    
    void EditDoctor(String PositionDoctor, String DateIn, String DateOut,
            String Salary, String Experience, String Certificate, String FullName,String accountid);
    
    
     Doctor getDoctorByID (String AccountID);
     void deleteDoctor(String id) throws Exception ;
}

