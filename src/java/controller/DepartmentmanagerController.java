package controller;

import entity.Department;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.DepartmentDAOImpl;
import java.util.ArrayList;

/**
 *
 *Management account of user
 */
public class DepartmentmanagerController extends HttpServlet {

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
        try {
            int indexPage = 1;
            // get the Page position being displayed to the user so that page transitions can be performed
            String index = request.getParameter("indexPage");
            if (index != null) {
                indexPage = Integer.parseInt(index);
            }
            request.setAttribute("indexPage", indexPage);
            //Get data from DAO
            DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
            // Get total Page of list product(each page have max 6 products)

            List<Department> listAccount = departmentDAO.getUsersList(6 * (indexPage - 1) + 1, 6 * indexPage);
            //Get total page
            int totalPage = departmentDAO.getTotalPage();
            request.setAttribute("totalPage", totalPage);
            
            //Get data from DAO
//            DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
            // Get total Page of list product(each page have max 6 products)

             List<Department> listDepartment1 = departmentDAO.getAllDe();
            //Get total page
            //Set data to JSP
            request.setAttribute("list", listAccount);
            request.getRequestDispatcher("newjsp.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
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
