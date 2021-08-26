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
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
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
public class adminPage extends HttpServlet {

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
            out.println("<title>Servlet adminPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add or delete a user here:</h1>");
            out.println("<form action=\"/addNewUser\" method=\"post\">\n"
                    + "            <label for=\"id\">ID:</label><br>\n"
                    + "            <input type=\"text\" id=\"id\" name=\"id\"><br>\n"
                    + "            <label for=\"name\">Username:</label><br>\n"
                    + "            <input type=\"text\" id=\"name\" name=\"name\"><br>\n"
                    + "            <label for=\"secret\">Password:</label><br>\n"
                    + "            <input type=\"password\" id=\"secret\" name=\"secret\"><br><br>\n"
                    + "            <label for=\"role\">\"admin\" or \"client\"</label><br>\n"
                    + "            <input type=\"text\" id=\"role\" name=\"role\"><br><br>\n"
                    + "            <label for=\"role\">\"add\" or \"delete\"</label><br>\n"
                    + "            <input type=\"text\" id=\"addDel\" name=\"addDel\"><br><br>\n"
                    + "            <input type=\"submit\" value=\"Submit\">\n"
                    + "        </form>");
            out.println("<h1>Change password or role for a user here:</h1>");
            out.println("<form action=\"/edit_user\" method=\"post\">\n"
                    + "            <label for=\"name\">Enter the ID </label><br>\n"
                    + "            <input type=\"text\" id=\"id\" name=\"id\"><br>\n"
                    + "            <label for=\"name\">and Username you want to change password or role:</label><br>\n"
                    + "            <input type=\"text\" id=\"name\" name=\"name\"><br>\n"
                    + "            <label for=\"secret\">Password (enter the new one if you need to change it, otherwise enter the old one):</label><br>\n"
                    + "            <input type=\"password\" id=\"secret\" name=\"secret\"><br><br>\n"
                    + "            <label for=\"role\">\"admin\" or \"client\"</label><br>\n"
                    + "            <input type=\"text\" id=\"role\" name=\"role\"><br><br>\n"
                    + "            <input type=\"submit\" value=\"Submit\">\n"
                    + "        </form>");
            Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
            KeyFactory keyFactory = datastore.newKeyFactory().setKind("User");
            Key key = datastore.allocateId(keyFactory.newKey());
            Query<Entity> query = Query.newEntityQueryBuilder()
                    .setKind("User")
                    .setOrderBy(OrderBy.desc("id"))
                    .build();

            QueryResults<Entity> users = datastore.run(query);
            out.println("<h1>User list:</h1>");
            while (users.hasNext()) {
                Entity tempEntity = users.next();
                String role = tempEntity.getString("role");
                String id = tempEntity.getString("id");
                String name = tempEntity.getString("name");
                String secret = tempEntity.getString("secret");
                out.println("User:");
                out.println("<table><tr><td>ID: " + id + " Name: " + name + " Secret: " + secret + " Role: " + role + "</td></tr></table>");
            }
            out.println("");
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
