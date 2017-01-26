package servlets;

import crud.EpisodeHelper;
import entities.Episode;
import entities.EpisodeBewertung;

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
 * Created by Yafei on 11/01/2017.
 */
@WebServlet(name = "EpisodeServlet", urlPatterns = {"/staffel/*", "/staffel/*/*"})
public class EpisodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String pattern = "^/staffel/s([1-9])/e([0-9]{1,2})$";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(path);
        if (m.find()) {
            int staffelNummer = Integer.parseInt(m.group(1));
            int episodeNummer = Integer.parseInt(m.group(2));

            if (staffelNummer >= 1 && staffelNummer <=6 && episodeNummer >=0 && episodeNummer <=10) {
                EpisodeHelper episodeHelper = new EpisodeHelper();
                Episode episode = episodeHelper.getOne(staffelNummer, episodeNummer);
                if (episode != null) {
                    request.setAttribute("episode", episode);
                    int rating = 0;
                    int count = 0;
                    for (EpisodeBewertung eb: episode.getEpisodeBewertungen()) {
                        rating += eb.getRating();
                        count += 1;
                    }
                    rating = count != 0 ? rating/count : 0;
                    request.setAttribute("rating", rating);
                }

                try {
                    request.getRequestDispatcher("/templates/episodeDetail.ftl").forward(request, response);
                } catch (ServletException | IOException e) {
                    request.setAttribute("errormessage", "Template error: please contact the admin.");
                    e.printStackTrace();
                }

            }
        } else {
            pattern = "^/staffel/s([1-9])$";
            r = Pattern.compile(pattern);
            m = r.matcher(path);
            if (m.find()) {
                int staffelNummer = Integer.parseInt(m.group(1));
                if (staffelNummer >= 1 && staffelNummer <= 6) {
                    request.setAttribute("staffelnummer", staffelNummer);
                    EpisodeHelper episodeHelper = new EpisodeHelper();
                    List<Episode> episoden = episodeHelper.getAllByStaffel(staffelNummer);
                    if (episoden != null && !episoden.isEmpty()) {
                        request.setAttribute("episoden", episoden);
                    }

                    try {
                        request.getRequestDispatcher("/templates/episode.ftl").forward(request, response);
                    } catch (ServletException | IOException e) {
                        request.setAttribute("errormessage", "Template error: please contact the admin.");
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
