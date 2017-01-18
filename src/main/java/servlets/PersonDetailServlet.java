package servlets;

import crud.PersonHelper;
import crud.TierHelper;
import entities.Person;
import entities.Tier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yafei on 17/01/2017.
 */
@WebServlet(name = "PersonDetailServlet", urlPatterns = {"/person/*"})
public class PersonDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonHelper personHelper = new PersonHelper();
        TierHelper tierHelper = new TierHelper();


        String path = URLDecoder.decode(request.getRequestURI(), "UTF-8");
        String personName;
        String pattern = "^/person/([a-zA-Z\\s]+)[/]?";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(path);
        if (m.find()) {

            personName = m.group(1);
            //response.getWriter().write(personName);
            Person p = personHelper.getOne(personName);
            List<Tier> tiere = tierHelper.getAllByPerson(personName);
            if (tiere != null && !tiere.isEmpty()) {
                request.setAttribute("tiere", tiere);
            }
            if (p != null) {
                request.setAttribute("person", p);
            }
            request.getRequestDispatcher("/templates/personDetail.ftl").forward(request, response);
        }
    }
}
