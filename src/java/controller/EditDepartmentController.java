/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Department;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.DepartmentDAOImpl;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class EditDepartmentController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditAccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAccountController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            //Get ID from jsp
            String id = request.getParameter("UserID");
            DepartmentDAOImpl dao = new DepartmentDAOImpl();
            //select users from id 
            Department x = dao.getDepartmentByID(id);

            //Push data to jsp
            HttpSession session = request.getSession();
            session.setAttribute("userid", x.getDepartmentID());
            request.setAttribute("dpname", x.getDepartmentName());
            request.setAttribute("dpdetail", x.getDetail());
            request.setAttribute("depnote", x.getNote());

            request.getRequestDispatcher("EditDepartment.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            //Step 1: get data from jsp
            HttpSession session = request.getSession();
            int uid = (int) session.getAttribute("userid");
            String namedp = request.getParameter("namedp"); //Get by name
            String detail = request.getParameter("detail");
            String note = request.getParameter("note");
            System.out.println(uid);
            System.out.println(namedp);
            System.out.println(detail);
            System.out.println(note);
            //Step 2: update to database
            DepartmentDAOImpl dao = new DepartmentDAOImpl();
            dao.updateUser(uid, namedp, detail, note);
            request.getRequestDispatcher("Departmentmanager").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("thank.jsp");
        }

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
