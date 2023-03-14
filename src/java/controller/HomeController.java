/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI_PRO
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

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
            
            /* Create variable to get data from database */
//            BlogDAO blogDAO = new BlogDAOImpl();// Create a DAO object to get the Blog table data from the Database
//            CategoryDAO categoryDAO = new CategoryDAOImpl();// Create a DAO object to get the Category table data from the Database
//
//            /* Create variable to store data after being retrieved from database */
//            ArrayList<Blog> blogs = blogDAO.getBlogList();// Get Blog List
//            ArrayList<Category> categoryList = categoryDAO.getAllCategory();// Get Category List
//
//            /* Create variable to store data after being retrieved from database */
//            request.setAttribute("blogs", blogs);// Set the Blog List in the application scope
//            request.setAttribute("categoryList", categoryList);// Set the Category List in the application scope
            
            /* Make requests and properties to View Page */
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");// Set URL path of View Page
            dispatcher.forward(request, response);// Make a move to the View page 
            
        } catch (Exception e) {// In case an Exception occurs
            
            /* Make requests and properties to Error Page */
            request.setAttribute("ex", e);// Send type Error to Error Page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
            
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
