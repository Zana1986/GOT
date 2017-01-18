package servlets;

import crud.BurgHelper;
import crud.OrtHelper;
import crud.PersonHelper;
import crud.TierHelper;
import entities.Burg;
import entities.Ort;
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
@WebServlet(name = "OrtDetailServlet", urlPatterns = {"/ort/*"})
public class OrtDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrtHelper ortHelper = new OrtHelper();

        String path = URLDecoder.decode(request.getRequestURI(), "UTF-8");
        String ortName;
        String pattern = "^/ort/([a-zA-Z\\s]+)[/]?";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(path);
        if (m.find()) {
            ortName = m.group(1);
            Ort ort = ortHelper.getOneByName(ortName);
            if (ort != null) {
                request.setAttribute("ort", ort);
                PersonHelper personHelper = new PersonHelper();
                List<Person> personen = personHelper.getAllByOrt(ortName);
                if (personen != null && !personen.isEmpty()) {
                    request.setAttribute("lokalePersonen", personen);
                }
                BurgHelper burgHelper = new BurgHelper();
                List<Burg> burge = burgHelper.getAllByOrtname(ortName);
                if (burge != null && !burge.isEmpty()) {
                    request.setAttribute("burge", burge);
                }
            }
            request.getRequestDispatcher("/templates/ortDetail.ftl").forward(request, response);
        }
    }
}
