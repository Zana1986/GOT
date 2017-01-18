package servlets;

import crud.PersonHelper;
import crud.TierHelper;
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
 * Created by Yafei on 17/01/2017.
 */
@WebServlet(name = "PersonServlet", urlPatterns = {"/person", "/person/"})
public class PersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonHelper personHelper = new PersonHelper();
        List<Person> personen = personHelper.getAll();

        request.setAttribute("personen", personen);
        //response.getWriter().write(personen.get(0).getName() + "");
        request.setAttribute("activePerson", 1);
        request.getRequestDispatcher("/templates/person.ftl").forward(request, response);

    }
}
