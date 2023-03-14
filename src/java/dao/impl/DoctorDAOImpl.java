/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.DoctorDAO;
import entity.Account;
import entity.Department;
import entity.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 *
 * @author msi
 */
public class DoctorDAOImpl extends DBContext implements DoctorDao{

    @Override
    public List<Doctor> getAllDoctor() throws Exception {
        List<Doctor> list = new ArrayList<>();
        String sql =" select * from doctor";
//        String sql = " SELECT Doctor.AccountID,Account.UserName as 'Name',Doctor.DepartmentID,Doctor.Position_doctor,Doctor.date_in,\n" +
//"Doctor.date_out,Doctor.Salary,Doctor.Experience,Doctor.Certificate\n" +
//"FROM Account\n" +
//"INNER JOIN Doctor ON Doctor.AccountID = Account.AccountID\n" +
//"\n" +
//"INNER JOIN Department ON Department.DepartmentID= Doctor.DepartmentID";
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
                Doctor D = new Doctor();
                D.setAccountID(rs.getInt(1)); 
                D.setDepartmentID(rs.getInt(2));
                D.setPositionDoctor(rs.getString(3));
                D.setDateIn(rs.getString(4));
                D.setDateOut(rs.getString(5));
                D.setSalary(rs.getFloat(6));
                D.setExperience(rs.getInt(7));
                D.setCertificate(rs.getString(8));
                D.setFullName(rs.getString(9));
                list.add(D);
                
                
//                int AccountID = rs.getInt("AccountID");
//                int setDepartmentID = rs.getInt("setDepartmentID");
//                String PositionDoctor = rs.getString("PositionDoctor");
//                String DateIn = rs.getString("DateIn");
//                String DateOut = rs.getString("DateOut");
//                float Salary = rs.getFloat("Salary");
//                int Experience = rs. getInt("Experience");
//                String Certificate = rs.getString("Certificate");
//                String Name = rs.getString("Name");
//                
//                list.add(new Doctor(AccountID, setDepartmentID, PositionDoctor, DateIn, DateOut, 0, Experience, Certificate, Name));
//                
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
    public ArrayList<Doctor> getDoctorList(int start, int end) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTotalPage() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        DoctorDAOImpl dao = new DoctorDAOImpl();
        try {
            List<Doctor> u = new ArrayList<Doctor>();
            u = dao.getAllDoctor();
            System.out.println(u.isEmpty());
            for (Doctor users : u) {
                System.out.println(users);
            }

        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void AddDoctor(String AccountID, String DepartmentID, String PositionDoctor, 
            String DateIn, String DateOut, String Salary, String Experience, String Certificate, String FullName) {
       {
        String query="INSERT INTO [SWD392_SE1609].[dbo].[Doctor]\n" +
"           ([AccountID]\n" +
"           ,[DepartmentID]\n" +
"           ,[Position_doctor]\n" +
"           ,[date_in]\n" +
"           ,[date_out]\n" +
"           ,[Salary]\n" +
"           ,[Experience]\n" +
"           ,[Certificate]\n" +
"           ,[FullName])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, AccountID);
            ps.setString(2, DepartmentID);
            ps.setString(3, PositionDoctor);
            ps.setString(4, DateIn);
            ps.setString(5, DateOut);
            ps.setString(6, Salary);
            ps.setString(7, Experience);
            ps.setString(8, Certificate);
            ps.setString(9, FullName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }


    } 

    @Override
    public void EditDoctor( String PositionDoctor, String DateIn, String DateOut,
            String Salary, String Experience, String Certificate, String FullName,String accountid) {
        String query="UPDATE [SWD392_SE1609].[dbo].[Doctor]\n" +
"   SET \n" +
"      [Position_doctor] = ?\n" +
"      ,[date_in] = ?\n" +
"      ,[date_out] = ?\n" +
"      ,[Salary] = ?\n" +
"      ,[Experience] = ?\n" +
"      ,[Certificate] = ?\n" +
"      ,[FullName] = ?\n" +
" WHERE AccountID = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, PositionDoctor);
            ps.setString(2, DateIn);
            ps.setString(3, DateOut);
            ps.setString(4, Salary);
            ps.setString(5, Experience);
            ps.setString(6, Certificate);
            ps.setString(7, FullName);
            ps.setString(8, accountid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public Doctor getDoctorByID(String AccountID) {
         List<Doctor> list = new ArrayList<>();
        String query = "SELECT * from Doctor\n" +
"where AccountID = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, AccountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                    return new Doctor(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getFloat(6),
                            rs.getInt(7),
                            rs.getString(8),
                            rs.getString(9));
            }
            
        } catch (Exception e) {
        }
        
        return null;
    }

    @Override
    public void deleteDoctor(String id) throws Exception {
        String sql=" delete from Doctor\n" +
"where AccountID = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        try {
//            ps = conn.prepareStatement(query);
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
        } 
    }

//    @Override
//    public void AddDoctorTest2(String PositionDoctor, String DateIn, String DateOut, String Salary, String Experience, String Certificate, String FullName) {
//        String query="INSERT INTO [SWD392_SE1609].[dbo].[Doctor]\n" +
//"           ([Position_doctor]\n" +
//"           ,[date_in]\n" +
//"           ,[date_out]\n" +
//"           ,[Salary]\n" +
//"           ,[Experience]\n" +
//"           ,[Certificate]\n" +
//"           ,[FullName])\n" +
//"     VALUES\n" +
//"           (?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?)";
//        
//        Connection conn = null;
//        PreparedStatement ps = null;
//        
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            ps.setString(3, PositionDoctor);
//            ps.setString(4, DateIn);
//            ps.setString(5, DateOut);
//            ps.setString(6, Salary);
//            ps.setString(7, Experience);
//            ps.setString(8, Certificate);
//            ps.setString(9, FullName);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }

}
