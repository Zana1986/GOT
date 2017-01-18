package servlets;

import crud.FigurHelper;
import crud.PersonHelper;
import entities.Figur;
import entities.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yafei on 18/01/2017.
 */
@WebServlet(name = "FigurServlet", urlPatterns = {"/figur"})
public class FigurServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FigurHelper figurHelper = new FigurHelper();
        List<Figur> figuren = figurHelper.getAll();

        request.setAttribute("figuren", figuren);
        //response.getWriter().write(personen.get(0).getName() + "");
        request.setAttribute("activeFigur", 1);
        request.getRequestDispatcher("/templates/figur.ftl").forward(request, response);
    }
}
