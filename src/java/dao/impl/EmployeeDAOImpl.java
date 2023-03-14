/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.EmployeeDAO;
import entity.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeDAOImpl extends DBContext implements EmployeeDAO {

    private final Connection conn = getConnection();

    public int addEmployees(Employee emp) {
        int n = 0;
        String sql = "insert into Employee_SE1609([AccountID],[DepartmentID],[Position_emp],[Date_in],[Date_out],[Salary],[UserManagerID])"
                + " values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, emp.getAccountId());
            pre.setInt(2, emp.getDepartmentId());
            pre.setString(3, emp.getPositionEmp());
            pre.setDate(4, (Date) emp.getDateIn());
            pre.setDate(5, (Date) emp.getDateOut());
            pre.setFloat(6, emp.getSalary());
            pre.setInt(7, emp.getUserManagementId());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateEmployees(Employee emp) {
        int n = 0;
        String sql = "update Employee_SE1609 set DepartmentID=?,Position_emp=?,"
                + "Date_in=?,Date_out=?,Salary=?,"
                + "UserManagerID=?"
                + " where AccountID=? ";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, emp.getDepartmentId());
            pre.setString(2, emp.getPositionEmp());
            pre.setDate(3, (Date) emp.getDateIn());
            pre.setDate(4, (Date) emp.getDateOut());
            pre.setFloat(5, emp.getSalary());
            pre.setInt(6, emp.getUserManagementId());
            pre.setInt(7, emp.getAccountId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteByID(int EmployeeID) {
        int n = 0;
        String sql = "delete from Employee_SE1609 where AccountID=" + EmployeeID;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }
    
    public Employee findById(int accountId) {
        int n = 0;
        String sql = "select* from Employee_SE1609 where AccountID=" + accountId;
        ResultSet rs = getData(sql);
        
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                int departmentId = rs.getInt(2);
                String positionEmp = rs.getString(3);
                Date dateIn = rs.getDate(4);
                Date dateOut = rs.getDate(5);
                float salary = rs.getFloat(6);
                int userManagementId = rs.getInt(7);

                return new Employee(id, departmentId, positionEmp, dateIn, dateOut, salary, userManagementId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Vector<Employee> listAllEmployees() {
        Vector<Employee> vector = new Vector<>();
        String sql = "select * from Employee_SE1609";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int accountId = rs.getInt(1);
                int departmentId = rs.getInt(2);
                String positionEmp = rs.getString(3);
                Date dateIn = rs.getDate(4);
                Date dateOut = rs.getDate(5);
                float salary = rs.getFloat(6);
                int userManagementId = rs.getInt(7);

                vector.add(new Employee(accountId, departmentId, positionEmp, dateIn, dateOut,
                        salary, userManagementId));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<Employee> listAllEmployees(String sql) {
        Vector<Employee> vector = new Vector<>();

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int accountId = rs.getInt(1);
                int departmentId = rs.getInt(2);
                String positionEmp = rs.getString(3);
                Date dateIn = rs.getDate(4);
                Date dateOut = rs.getDate(5);
                float salary = rs.getFloat(6);
                int userManagementId = rs.getInt(7);

                vector.add(new Employee(accountId, departmentId, positionEmp, dateIn, dateOut,
                        salary, userManagementId));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
}
