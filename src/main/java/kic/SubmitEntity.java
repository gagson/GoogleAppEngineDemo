/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gagso
 */
public class SubmitEntity extends HttpServlet {

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
            out.println("<title>Servlet SubmitEntry</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"receive_entity\" method=\"post\">\n"
                    + "                <div class=\"row p-1\"></div>\n"
                    + "                <div class=\"row\" id=\"newRow1\">\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Entity:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"entity\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                <div class=\"row p-1\"></div>\n"
                    + "                <div class=\"row\" id=\"newRow1\">\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Property 1:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"pro1\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Value 1:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"val1\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                    </div>\n"
                    + "                <div class=\"row p-1\"></div>\n"
                    + "                <div class=\"row\" id=\"newRow1\">\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Property 2:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"pro2\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Value 2:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"val2\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                    </div>\n"
                    + "                <div class=\"row p-1\"></div>\n"
                    + "                <div class=\"row\" id=\"newRow1\">\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Property 3:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"pro3\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                    <label class=\"col-md-4\"></label>\n"
                    + "                    <label class=\"col-md-2\">Value 3:</label>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <input type=\"text\" name=\"val3\" class=\"form-control\">\n"
                    + "                    </div>\n"
                    + "                    </div>\n"
                    + "                <div class=\"row\">\n"
                    + "                    <label class=\"col-md-3\"></label>\n"
                    + "                    <input type=\"submit\" value=\"Submit\" class=\"col-md-6 btn btn-primary btn-block\">\n"
                    + "                    <label class=\"col-md-3\"></label>\n"
                    + "                </div>\n"
                    + "            </form>\n");
           
           
//            out.println("<button value=\"keyword\" name=\"keyword\" class=\"col-md-2 btn btn-light btn-block\"><a href=\"./submit_keyword\">Search Entity by a keyword</a></div>");
            out.println("<h1>Servlet SubmitEntry at " + request.getContextPath() + "</h1>");
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
