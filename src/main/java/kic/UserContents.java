/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kic;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gagso
 */
public class UserContents extends HttpServlet {

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
            out.println("<title>Adding initial users</title>");
            out.println("</head>");
            out.println("<body>");
            
            Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
            KeyFactory keyFactory = datastore.newKeyFactory().setKind("User");
            Key key1 = datastore.allocateId(keyFactory.newKey());
            Key key2 = datastore.allocateId(keyFactory.newKey());
            Key key3 = datastore.allocateId(keyFactory.newKey());
            Key key4 = datastore.allocateId(keyFactory.newKey());
            Entity userEntity1 = Entity.newBuilder(key1)
                    .set("id", "A001")
                    .set("role", "admin")
                    .set("secret", "123456")
                    .set("name", "admin1")
                    .build();
            datastore.add(userEntity1);
            Entity userEntity2 = Entity.newBuilder(key2)
                    .set("id", "0001")
                    .set("role", "client")
                    .set("secret", "itsme")
                    .set("name", "user1")
                    .build();
            datastore.add(userEntity2);
            Entity userEntity3 = Entity.newBuilder(key3)
                    .set("id", "0002")
                    .set("role", "client")
                    .set("secret", "itsme")
                    .set("name", "user2")
                    .build();
            datastore.add(userEntity3);
            Entity userEntity4 = Entity.newBuilder(key4)
                    .set("id", "0003")
                    .set("role", "client")
                    .set("secret", "itsme")
                    .set("name", "user3")
                    .build();
            datastore.add(userEntity4);
            
            out.println("<h1>Successful to add initial users</h1>");
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
