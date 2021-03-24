/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ClassicDAO;
import DAO.PhanTramDiemDAO;
import DAO.StudentDAO;
import DAO.SubjectDAO;
import entities.BangDiem;
import entities.Classic;
import entities.PhanTramDiem;
import entities.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class listClassic extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        String userID = (String) sesion.getAttribute("idUser");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            SubjectDAO subjectDAO = new SubjectDAO();
            List<Subject> listSubjects = new ArrayList<Subject>();
            listSubjects = subjectDAO.getListUserByIdTeacher(userID);
            request.setAttribute("listSubject", listSubjects);
            
            ClassicDAO classicDAO = new ClassicDAO();
            List<Classic> listClassics = new ArrayList<>();
            listClassics = classicDAO.getListClassicByIdSubject("1");
            request.setAttribute("listClassics", listClassics);
            
            PhanTramDiemDAO phanTramDiemDAO = new PhanTramDiemDAO();
            PhanTramDiem phanTramDiem = new PhanTramDiem();
            phanTramDiem = phanTramDiemDAO.getPhanTramDiemByIdSubject("1");
            request.setAttribute("phanTramDiem", phanTramDiem);
            
            StudentDAO studentDAO = new StudentDAO();
            List<BangDiem> listBangDiems = new ArrayList<BangDiem>();
            listBangDiems = studentDAO.getListStudentByIdUser(userID);
            request.setAttribute("listBangDiems", listBangDiems);
            
            int countDK = 0, coutKDK = 0;
            
            for (BangDiem listBangDiem : listBangDiems) {
                if (listBangDiem.getPoint().getDKDT() == 0) {
                    countDK ++;
                }
                else{
                    coutKDK ++;
                }
            }
            sesion.setAttribute("duDK", countDK);
            sesion.setAttribute("kduDK", coutKDK);
            
            RequestDispatcher view = request.getRequestDispatcher("/Home.jsp");
//            RequestDispatcher view = request.getRequestDispatcher("/listSubject.jsp");
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
