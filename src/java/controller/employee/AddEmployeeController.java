/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.AccountDAO;
import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.DepartmentDAOImpl;
import dao.impl.EmployeeDAOImpl;
import entity.Account;
import entity.Department;
import entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddEmployeeController", urlPatterns = {"/addEmployee"})
public class AddEmployeeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("do");
            String message = "";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            
            EmployeeDAO employeeDao = new EmployeeDAOImpl();

            if (service != null) {
                if (service.equals("addEmployee")) {

                    //Get and store all attribute of each Product
                    try {
                        int accountId = Integer.parseInt(request.getParameter("accountId"));
                        int departmentId = Integer.parseInt(request.getParameter("department"));
                        String positionEmp = request.getParameter("position");
                        Date dateIn = new Date(formatter.parse(request.getParameter("datein")).getTime());
                        Date dateOut = new Date(formatter.parse(request.getParameter("dateout")).getTime());
                        float salary = Float.parseFloat(request.getParameter("salary"));
                        int userManagementId = Integer.parseInt(request.getParameter("userManagement")); 
                        
                        Employee emp = new Employee(accountId, departmentId, positionEmp, dateIn, dateOut, salary, userManagementId);
                        if (employeeDao.addEmployees(emp) > 0) {
                            message = "<p style=\"color: green\">Succesful</p>";
                        } else {
                            message = "<p style=\"color: green\">Fail to add products</p>";
                        }
                    } catch (NumberFormatException e) {
                        message = "<p style=\"color: red\">Wrong format input</p>";
                        e.printStackTrace();
                    }

                }
            }

            DepartmentDAO departmentDAO = new DepartmentDAOImpl();
            AccountDAO accountDAO = new AccountDAOImpl();

            List<Department> listDepartment = departmentDAO.getAllDe();
            List<Account> listAccount = accountDAO.getAll();

            request.setAttribute("listDepartment", listDepartment);
            request.setAttribute("listAccount", listAccount);
            request.getRequestDispatcher("add-employee.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
