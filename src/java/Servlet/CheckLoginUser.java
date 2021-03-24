/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.TeacherDAO;
import DAO.UserDAO;
import entities.Teacher;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CheckLoginUser extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession sesion = request.getSession();
//        HttpSession sesion = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            User u = new User(username, password);
            UserDAO dao = new UserDAO();
            if (dao.checkLogin(u)) {
                User user = dao.getUserByUsername(username);
                if (user.getPotion().equalsIgnoreCase("teacher")) {
                    Teacher teacher = new Teacher();
                    TeacherDAO teacherDAO = new TeacherDAO();
                    teacher = teacherDAO.getTeacherByUserID(user.getId());
                    sesion.setAttribute("idUser", teacher.getId());
                    sesion.setAttribute("nameUser", teacher.getName());
                    request.setAttribute("newUser", teacher);
                    RequestDispatcher view = request.getRequestDispatcher("/HomeServerlet");
                    view.forward(request, response);
                }
                else{
                    
                }
                
                    
//                User newUser = new User();
//                newUser = dao.getUserByUserName(username);
//                if (newUser.getPosition().equalsIgnoreCase("admin")) {
////                    sesion.setAttribute("nameUser", newUser.getName());
//                    request.setAttribute("newUser", newUser);
//                    RequestDispatcher view = request.getRequestDispatcher("/listBill");
//                    view.forward(request, response);
//                }
//                else{
//                    sesion.setAttribute("nameUser", newUser.getName());
//                    request.setAttribute("newUser", newUser);
//                    RequestDispatcher view = request.getRequestDispatcher("/view/client/trangchu.jsp");
//                    view.forward(request, response);
//                }
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
                view.forward(request, response);
            }
            
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
