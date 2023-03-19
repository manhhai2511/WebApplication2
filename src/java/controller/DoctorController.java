/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.DoctorDAO;
import dao.MedicalRecordDAO;
import dao.PatientDAO;
import dao.RoomBedDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.DoctorDAOImpl;
import dao.impl.MedicalRecordDAOImpl;
import dao.impl.PatientDAOImpl;
import dao.impl.RoomBedDAOImpl;
import entity.Account;
import entity.Doctor;
import entity.MedicalRecord;
import entity.Patient;
import entity.Room_bed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class DoctorController extends HttpServlet {

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
            out.println("<title>Servlet DoctorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoctorController at " + request.getContextPath() + "</h1>");
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

        PatientDAO patientDAO = new PatientDAOImpl();
        AccountDAO accountDAO = new AccountDAOImpl();
        RoomBedDAO roomBedDAO = new RoomBedDAOImpl();
        MedicalRecordDAO recordDAO = new MedicalRecordDAOImpl();
        try {

            ArrayList<MedicalRecord> medicalRecord = recordDAO.getAll();
            request.setAttribute("medicalRecord", medicalRecord);

            ArrayList<Patient> patientList = patientDAO.getAllPatient();
            request.setAttribute("patientList", patientList);

            ArrayList<Account> accountList = (ArrayList<Account>) accountDAO.getAll();
            request.setAttribute("accountList", accountList);

            ArrayList<Room_bed> room_beds = (ArrayList<Room_bed>) roomBedDAO.getAll();
            request.setAttribute("room_beds", room_beds);

            RequestDispatcher dispatcher = request.getRequestDispatcher("PTManagement.jsp");
            dispatcher.forward(request, response);
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
            throws ServletException, IOException {PatientDAO patientDAO = new PatientDAOImpl();
        AccountDAO accountDAO = new AccountDAOImpl();
        RoomBedDAO roomBedDAO = new RoomBedDAOImpl();
        MedicalRecordDAO recordDAO = new MedicalRecordDAOImpl();
        try {
            int id = Integer.parseInt(request.getParameter("recordId"));
            String content = request.getParameter("content");
            
            MedicalRecord record = new MedicalRecord();
            record.setPtID(id);
            record.setContent(content);
            
            int n = recordDAO.updateMedicalRecord(record);
            request.setAttribute("message", "Update Medical Record For Patient Successfully");
            
            ArrayList<MedicalRecord> medicalRecord = recordDAO.getAll();
            request.setAttribute("medicalRecord", medicalRecord);

            ArrayList<Patient> patientList = patientDAO.getAllPatient();
            request.setAttribute("patientList", patientList);

            ArrayList<Account> accountList = (ArrayList<Account>) accountDAO.getAll();
            request.setAttribute("accountList", accountList);

            ArrayList<Room_bed> room_beds = (ArrayList<Room_bed>) roomBedDAO.getAll();
            request.setAttribute("room_beds", room_beds);

            RequestDispatcher dispatcher = request.getRequestDispatcher("PTManagement.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
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
