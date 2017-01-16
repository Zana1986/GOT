package servlets;

import crud.BenutzerHelper;
import entities.Benutzer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Yafei on 14/01/2017.
 */
@WebServlet(name = "RegisterSubmitServlet", urlPatterns = {"/registerSubmit"})
public class RegisterSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer out = response.getWriter();
        String name = request.getParameter("newName");
        String loginkennung = request.getParameter("newLoginkennung");
        String passwort = request.getParameter("newPasswort");

        BenutzerHelper benutzerHelper = new BenutzerHelper();
        if (benutzerHelper.isExisted(loginkennung)) {
            out.write("Email ist existiert.");
//            request.setAttribute("loginKenung", "leer");
        } else {
            Benutzer benutzer = new Benutzer(name, passwort, loginkennung);
            benutzerHelper.addBenutzer(benutzer);
            request.getSession().setAttribute("loginKenung", loginkennung);
            response.sendRedirect("/index");
            //out.write("Success.");
//            request.getRequestDispatcher("/templates/angemeldetIndex.ftl").forward(request, response);
        }
    }
}
