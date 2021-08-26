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
import com.google.cloud.datastore.Value;
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
public class Login extends HttpServlet {

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
        String name = (String) request.getParameter("name");
        String secret = (String) request.getParameter("secret");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
            KeyFactory keyFactory = datastore.newKeyFactory().setKind("User");
            Key key = datastore.allocateId(keyFactory.newKey());
            Query<Entity> query = Query.newEntityQueryBuilder()
                    .setKind("User")
                    .setFilter(CompositeFilter.and(
                            PropertyFilter.eq("name", name),
                            PropertyFilter.eq("secret", secret)))
                    .build();

            QueryResults<Entity> users = datastore.run(query);

            if (users.hasNext()) {
                Entity tempEntity = users.next();
                // do something with the task
//                Entity task = datastore.get(tempEntity.getKey());
//                out.println("<p>" + task + "</p>"); //shown sth
                String role = tempEntity.getString("role");
                out.println("<p>" + role + "</p>");
                if (role.equals("admin")) { //if type is "admin"
                    response.sendRedirect("admin");
                } else {
                    response.sendRedirect("client");
                }
//                String role = tempEntity.getString("role");
//                Set<String> propNames = tempEntity.getNames();
//                for (String propName : propNames) {
//                    out.println("<p>" + tempEntity.getString(propName) + "</p>");
//                }
//                out.println("<h1>Welcome " + name + "</h1>");
//                out.println("<h2>You are " + role + "</h1>");
            }
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
