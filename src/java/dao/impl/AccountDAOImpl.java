/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;
import entity.Account;
import dao.AccountDAO;
import dao.DBContext;
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
public class AccountDAOImpl extends DBContext implements AccountDAO {
    public List<Account> getAll() throws Exception { //Get user data in the database
        List<Account> list = new ArrayList<>();
        String sql = "  select * from Account";
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
                Account U = new Account();
                U.setAccountName(rs.getString(2));
                U.setEmail(rs.getString(4));
                U.setPassword(rs.getString(3));
                U.setAddress(rs.getString(1));
                U.setPhone(rs.getString(6));
                U.setRole(rs.getInt(7));
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
    
    public Account getAccountByID(int id) throws Exception {
        String query = "SELECT * FROM Account WHERE AccountID = ?";
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
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getInt(7));
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
    
    
    public static void main(String[] args) {
        AccountDAOImpl dao = new AccountDAOImpl();
        try {
            List<Account> u = new ArrayList<Account>();
            u = dao.getAll();
            System.out.println(u.isEmpty());
            for (Account users : u) {
                System.out.println(users);
            }

        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
