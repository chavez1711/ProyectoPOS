/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package paq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Profesor
 */
public class BuscaPelServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException
    {
        String genero = request.getParameter("genero");
        List<Pelicula> peliculas = ClienteRestPelicula.peliculasPorTema(genero);
        
        System.out.println("Genero " + genero);
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscaPelServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultados</h1>");
            out.println("<div><table width=\"80%\" style=\"margin: 0 auto; border:2px solid;text-align:center\" bgcolor=\"gainsboro\">");
            out.println("<tr style=\"outline: thin solid\">");
            out.println("<th>Título</th>");
            out.println("<th>Año</th>");
            out.println("<th>Poster</th>");
            out.println("</tr>");
            for(Pelicula cadaPel :peliculas)   
            {
                out.println("<tr style=\"outline: thin solid\">");
                out.println("<td style=\"text-align:center\">" + cadaPel.getTitulo() + "</td>");
                out.println("<td style=\"text-align:center\">" + cadaPel.getAnio() + "</td>");
                out.println("<td><img src=\"" + cadaPel.getPoster() + "\"></td>");
                out.println("</tr>");
            }
            out.println("</table></div>");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscaPelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscaPelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
