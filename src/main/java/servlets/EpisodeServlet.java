package servlets;

import crud.AuftretenInHelper;
import crud.EpisodeBewertungHelper;
import crud.EpisodeHelper;
import entities.AuftretenIn;
import entities.Episode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yafei on 11/01/2017.
 */
@WebServlet(name = "EpisodeServlet", urlPatterns = {"/staffel/*"})
public class EpisodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffelNummer = Integer.parseInt(request.getParameter("nummer"));

        if (staffelNummer >= 1 && staffelNummer <= 6) {
            EpisodeHelper episodeHelper = new EpisodeHelper();
            List<Episode> episoden = episodeHelper.getAllByStaffel(staffelNummer);
            if (episoden != null && !episoden.isEmpty()) {
                request.setAttribute("episoden", episoden);
            }

            EpisodeBewertungHelper episodeBewertungHelper = new EpisodeBewertungHelper();
            int[] ratings = new int[episoden.size()];

            AuftretenInHelper auftretenInHelper = new AuftretenInHelper();
            List<AuftretenIn>[] figurenEpisoden = new List[episoden.size()];
            for (Episode e : episoden) {
                int i = e.getEpiNummer();
                ratings[i] = episodeBewertungHelper.getAllByEpisode(staffelNummer, i);
                figurenEpisoden[i] = auftretenInHelper.getAllByEpisode(staffelNummer, i);
            }
            request.setAttribute("ratings", ratings);
            request.setAttribute("figurenEpisoden", figurenEpisoden);
        }

        try {
            request.getRequestDispatcher("/templates/episode.ftl").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("errormessage", "Template error: please contact the admin.");
            e.printStackTrace();
        }
    }
}
