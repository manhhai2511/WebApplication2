/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.DepartmentDAO;
import entity.Account;
import entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DepartmentDAOImpl extends DBContext implements DepartmentDAO {

    @Override
    public List<Department> getAllDe() throws Exception {
        List<Department> list = new ArrayList<>();
        String sql = "  select * from Department";
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
                Department U = new Department();
                U.setDepartmentID(rs.getInt(1));
                U.setDepartmentName(rs.getString(2));
                U.setDetail(rs.getString(3));
                U.setNote(rs.getString(4));
                
                list.add(U);
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
    
    public ArrayList<Department> getUsersList(int start, int end) throws Exception {
        // Create ArrayList to store all User
        ArrayList<Department> user = new ArrayList<>();

        // Query Statement to get all Categories in Database 
        String sqlQuery = "with x as (	select row_number() over(order by DepartmentID  asc) as row, * from Department \n"
                + "                ) \n"
                + "                select * from x where  row between " + start + " and " + end;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // Get and store all attribute of each User
                int UserID = rs.getInt("DepartmentID");
                String Username = rs.getString("DepartmentName");
                String Password = rs.getString("Detail");
                String email = rs.getString("Note");
                // Add User to Arraylist 
                user.add(new Department(UserID, Username, Password, email));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRS(rs);
            closePrepareStatement(preparedStatement);
            closeConnection(connection);
        }
        return user;
    }
    
    public int getTotalPage() throws Exception {

        //  Variable to store the condition values passed to filter products in Database
        int totalPage = 0;

        // Query statement to get total Product in Database
        String sqlQuery = "select count(DepartmentID) from Department";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        // Execute query to get total Product
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            rs = preparedStatement.executeQuery();
            // set total Product to variable
            if (rs.next()) {
                totalPage = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection(connection);
            closePrepareStatement(preparedStatement);
            closeRS(rs);
        }
        // convet total product to total page (each page have 6 product)
        return (int) Math.ceil((double) totalPage / 6);
    }
    
    public void add(String name,String detail, String note) throws Exception {
        String query = "INSERT INTO Department\n"
                + "           ([DepartmentName]\n"
                + "           ,[Detail]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?,?,?)";

        Connection conn = null;
        PreparedStatement prepare = null;

        try {
//            ps = conn.prepareStatement(query);

            conn = getConnection();
            prepare = conn.prepareStatement(query);
            prepare.setString(1, name);
            prepare.setString(2, detail);
            prepare.setString(3, note);
            prepare.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closePrepareStatement(prepare);
            closeConnection(conn);
        }

    }
    public boolean deleteAccount(String id) throws Exception {
        String query = "	delete from Department where DepartmentID = ?\n";

        Connection conn = null;
        PreparedStatement prepare = null;

        try {
//            ps = conn.prepareStatement(query);

            conn = getConnection();
            prepare = conn.prepareStatement(query);
            prepare.setString(1, id);
            prepare.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            closePrepareStatement(prepare);
            closeConnection(conn);
            return false;
        }

    }
    
    public Department getDepartmentByID(String id) throws Exception {
        String query = "SELECT * FROM Department WHERE departmentID = ?";
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        try {
//            ps = conn.prepareStatement(query);
//            ps.setString(1, id);
//            rs = ps.executeQuery();

            conn = getConnection();
            prepare = conn.prepareStatement(query);
            prepare.setString(1, id);
            rs = prepare.executeQuery();
            while (rs.next()) {
                return new Department(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeRS(rs);
            closePrepareStatement(prepare);
            closeConnection(conn);
        }
        return null;
    }
    
    public Department getAccountByID(int id) throws Exception {
        String query = "SELECT * FROM Department WHERE departmentID = ?";
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        try {
//            ps = conn.prepareStatement(query);
//            ps.setString(1, id);
//            rs = ps.executeQuery();

            conn = getConnection();
            prepare = conn.prepareStatement(query);
            prepare.setInt(1, id);
            rs = prepare.executeQuery();
            while (rs.next()) {
                return new Department(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeRS(rs);
            closePrepareStatement(prepare);
            closeConnection(conn);
        }
        return null;
    }
    
    public void updateUser(int id, String user, String email, String isSell) throws Exception {
        String preSql = "update Department set departmentName=? \n"
                + "               ,Detail=?  \n"
                + "                ,Note=?  \n"
                + "                 where departmentID=" + id;

        Connection conn = null;
        PreparedStatement prepare = null;
        try {
//            PreparedStatement ps = conn.prepareStatement(preSql);

            conn = getConnection();
            prepare = conn.prepareStatement(preSql);

            prepare.setString(1, user);
            prepare.setString(2, email);
            prepare.setString(3, isSell);
            prepare.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            closePrepareStatement(prepare);
            closeConnection(conn);
        }

    }
    
    public static void main(String[] args) {
        DepartmentDAOImpl dao = new DepartmentDAOImpl();
        try {
//            Department d=new Department("á á đfu", "avda334", "abba");
            dao.add("á á đfu", "avda334", "abba");

        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
