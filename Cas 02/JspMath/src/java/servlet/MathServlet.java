/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MathModel;
import storage.MathOperationStorage;
import util.Operations;

/**
 *
 * @author student1
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/math"})
public class MathServlet extends HttpServlet {

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
        String action = request.getParameter("action");
        if (action != null) {
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            MathModel model = new MathModel(a, b);
            String userOperation = null;
            switch (action) {
                case Operations.OPERATION_ADDITION:
                    model.setC(a + b);
                    userOperation = Operations.OPERATION_ADDITION;
                    break;
                case Operations.OPERATION_SUBTRACTION:
                    model.setC(a - b);
                    userOperation = Operations.OPERATION_SUBTRACTION;
                    break;
                case Operations.OPERATION_MULTIPLICATION:
                    model.setC(a * b);
                    userOperation = Operations.OPERATION_MULTIPLICATION;
                    break;
                case Operations.OPERATION_DIVISION:
                    if (b != 0) {
                        model.setC(a / (double) b);
                    }
                    userOperation = Operations.OPERATION_DIVISION;
                    break;
                default:
                    model.setC(0.0);
            }
            request.setAttribute("model", model);
            MathOperationStorage.getInstance().add(model);
            request.setAttribute("userOperation", userOperation);
            getServletContext().getRequestDispatcher("/math_jstl.jsp").forward(request, response);
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
