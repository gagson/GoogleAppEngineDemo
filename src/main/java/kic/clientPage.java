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
public class clientPage extends HttpServlet {

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
            out.println("<title>Client Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Google cloud services:</h1>");
            out.println("<h2>Google Cloud Storage:</h1>");
            out.println("<form action=\"storage_tester\" method=\"post\" enctype=\"multipart/form-data\">\n"
                    + "        <input type=\"file\" id=\"myFile\" name=\"file\">\n"
                    + "        <input type=\"submit\" value=\"Submit\">\n"
                    + "    </form>");
            out.println("<h2>Google Cloud Datastore:</h1>");
            out.println("<a href='/submit_entity'>Create new entity here</a>");
            out.println("<h2>Google Cloud Basic String Translation:</h1>");
            out.println("<form action=\"translation\" method=\"post\">\n"
                    + "<label for=\"string\">English string to be translated in Japanese:</label><br>\n"
                    + "            <input type=\"text\" id=\"string\" name=\"string\"><br>\n"
                    + "            <input type=\"submit\" value=\"Submit\">"
                    + "    </form>");
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
