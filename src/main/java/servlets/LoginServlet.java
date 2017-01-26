package servlets;

import crud.BenutzerHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Yafei on 09/01/2017.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/logout"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.equals("/login")) {
            String loginKennung = request.getParameter("loginkennung");
            String passwort = request.getParameter("passwort");
            BenutzerHelper benutzerHelper = new BenutzerHelper();
            if (benutzerHelper.checkUser(loginKennung, passwort)) {
                request.getSession().removeAttribute("loginfailed");

                request.getSession().setAttribute("loginKennung", loginKennung);
                response.sendRedirect("/index");
                //request.getRequestDispatcher("/templates/index.ftl").forward(request, response);
            } else {
                request.getSession().setAttribute("loginfailed", 1);
                response.sendRedirect("/index");
            }
        } else if (path.equals("/logout")) {
            request.getSession().removeAttribute("loginKennung");
            response.sendRedirect("/index");
        }

    }
}
