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
import java.sql.SQLException;
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
                U.setAccountID(rs.getInt(1));
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
    
    public void insert(String email, String username, String password) throws Exception {
        String query = "  insert into Account(UserName,[Password],Email, [Role]) values (?,?,?,1)";
        Connection conn = null;
        PreparedStatement prepare = null;
        try {
            int result = 0;
//            PreparedStatement st = conn.prepareStatement(query);

            conn = getConnection();
            prepare = conn.prepareStatement(query);

            prepare.setString(1, username);
            prepare.setString(2, password);
            prepare.setString(3, email);
//            st.executeUpdate();
            prepare.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closePrepareStatement(prepare);
            closeConnection(conn);
        }
    }
    
    public Account getAccount(String user, String pass) throws Exception {
        String sql = "select*from Account\n" +
        " where [username]='"+user+"' and [password]='"+pass+"'";
      
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            prepare = conn.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()) {
                int accountId=rs.getInt(1);
                String accountName = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                int role=rs.getInt(7);

               Account acc =new Account(accountId, accountName, password, email, address,phone, role);
                return acc ;
            }
         } catch (Exception e) {
            throw e;
        } finally {
            closePrepareStatement(prepare);
            closeConnection(conn);
        }
        return null;
    }
    
    public static void main(String[] args) {
        AccountDAOImpl dao = new AccountDAOImpl();
        try {
            Account acc = new Account();
            acc = dao.getAccount("Dat", "123456");
            System.out.println(acc);
            

        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
}
