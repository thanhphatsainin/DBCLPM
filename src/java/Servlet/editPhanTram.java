/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.PhanTramDiemDAO;
import entities.PhanTramDiem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class editPhanTram extends HttpServlet {

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
        String phantramID = request.getParameter("id");
        String cc = request.getParameter("cc");
        String tp1 = request.getParameter("tp1");
        String tp2 = request.getParameter("tp2");
        String dt = request.getParameter("thi");
        
        try (PrintWriter out = response.getWriter()) {
            PhanTramDiem phanTramDiem = new PhanTramDiem();            
            PhanTramDiemDAO phanTramDiemDAO = new PhanTramDiemDAO();
//            phanTramDiem.setId(phantramID);
            phanTramDiem.setId("1");
//            phanTramDiem.setIdSubject("1");
            phanTramDiem.setPhantramCC(Float.parseFloat(cc));
            phanTramDiem.setPhantramTP1(Float.parseFloat(tp1));
            phanTramDiem.setPhantramTP2(Float.parseFloat(tp2));
            phanTramDiem.setPhantramDT(Float.parseFloat(dt));
            
            phanTramDiemDAO.editPhanTramDiem(phanTramDiem);
            
            //request.setAttribute("listToy", list);
//            String url = request.getContextPath()+"/listtoy";
            RequestDispatcher view = request.getRequestDispatcher("/listClassic");
            view.forward(request, response);
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
