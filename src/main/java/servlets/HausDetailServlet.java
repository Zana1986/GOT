package servlets;

import crud.AngehoertHelper;
import crud.BeherrschenHelper;
import crud.HausBewertungHelper;
import crud.HausHelper;
import entities.Angehoert;
import entities.Beherrschen;
import entities.Haus;
import entities.HausBewertung;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yafei on 13/01/2017.
 */
@WebServlet(name = "HausDetailServlet", urlPatterns = {"/haus/*"})
public class HausDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String hausName;
        String pattern = "^/haus/([a-zA-Z]+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(path);
        if (m.find()) {
            hausName = m.group(1);
            //response.getWriter().write(hausName);

//            AngehoertHelper angehoertHelper = new AngehoertHelper();
//            List<Angehoert> angehoertResults = angehoertHelper.getAllByHaus(hausName);
//            if (angehoertResults != null && !angehoertResults.isEmpty()) {
//                request.setAttribute("personen", angehoertResults);
//            }
//            BeherrschenHelper beherrschenHelper = new BeherrschenHelper();
//            List<Beherrschen> beherrschenResults = beherrschenHelper.getAllByHaus(hausName);
//            if (beherrschenResults != null && !beherrschenResults.isEmpty()) {
//                request.setAttribute("beherrschen", beherrschenResults);
//            }

            HausHelper hausHelper = new HausHelper();
            Haus haus = hausHelper.getOne(hausName);
            if (haus != null) {
                request.setAttribute("haus", haus);
                int ratingLevel = 0;
                int count = 0;
//                for (HausBewertung hb: haus.getHausBewertungen()) {
//                    ratingLevel += hb.getRating();
//                    count += 1;
//                }
                ratingLevel = (count != 0 ? ratingLevel/count : 1);
                request.setAttribute("ratingLevel", ratingLevel);

                //response.getWriter().write(haus.getOwners().size() + " " + haus.getOrte().size());
            }


//            HausBewertungHelper hausBewertungHelper = new HausBewertungHelper();
//            int hausBewertungsNiveau = hausBewertungHelper.getOne(hausName);
//            request.setAttribute("bewertunsNiveau", hausBewertungsNiveau);

            request.getRequestDispatcher("/templates/hausDetail.ftl").forward(request, response);
        }

    }
}
