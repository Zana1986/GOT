package servlets;

import crud.*;
import entities.*;

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
@WebServlet(name = "BewertungServlet", urlPatterns = {"/bewertung", "/bewertung/*"})
public class BewertungServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BewertungHelper bewertungHelper = new BewertungHelper();
        BenutzerHelper benutzerHelper = new BenutzerHelper();

        String loginKennung = request.getParameter("loginKennung");
        Benutzer benutzer = benutzerHelper.getOne(loginKennung);
        String inhalt = request.getParameter("bewertungsInhalt");
        String niveau = request.getParameter("bewertungsNiveau");
        int ratingLevel;
        try {
            ratingLevel = Integer.parseInt(niveau);
        } catch (NumberFormatException e) {
            response.getWriter().write("Bewertungsniveau ist falsch.");
            return;
        }
        String bewertungstyp = request.getParameter("bewertungstyp");

        if (bewertungstyp.equals("figur")) {
            String fid = request.getParameter("figurid");
            int figurid;
            try {
                figurid = Integer.parseInt(fid);
            } catch (NumberFormatException figurE) {
                response.getWriter().write("Falsche figur ID order herkunftsort ID.");
                return;
            }

            FigurBewertungHelper figurBewertungHelper = new FigurBewertungHelper();
            FigurBewertung figurBewertung = bewertungHelper.isExistedByFigur(benutzer.getId(), figurid);
            if (figurBewertung != null) {
                figurBewertung.setTextInhalt(inhalt);
                figurBewertung.setRating(ratingLevel);
                figurBewertungHelper.updateFigurBewertung(figurBewertung);
            } else {
                FigurHelper figurHelper = new FigurHelper();
                Figur figur = figurHelper.getOneById(figurid);
                figurBewertungHelper.addFigurBewertung(new FigurBewertung(inhalt, ratingLevel, benutzer, figur));
            }
        } else if (bewertungstyp.equals("haus")) {
            String hid = request.getParameter("hausid");
            int hausid;
            try {
                hausid = Integer.parseInt(hid);
            } catch (NumberFormatException figurE) {
                response.getWriter().write("Falsche Haus ID.");
                return;
            }

            HausBewertungHelper hausBewertungHelper = new HausBewertungHelper();
            HausBewertung hausBewertung = bewertungHelper.isExistedByHaus(benutzer.getId(), hausid);
            if (hausBewertung != null) {
                hausBewertung.setTextInhalt(inhalt);
                hausBewertung.setRating(ratingLevel);
                hausBewertungHelper.updateHausBewertung(hausBewertung);
            } else {
                HausHelper hausHelper = new HausHelper();
                Haus haus = hausHelper.getOneById(hausid);
                hausBewertungHelper.addHausBewertung(new HausBewertung(inhalt, ratingLevel, benutzer, haus));
            }
        } else if (bewertungstyp.equals("staffel")) {
            String s = request.getParameter("staffelnummer");
            int nummer;
            try {
                nummer = Integer.parseInt(s);
            } catch (NumberFormatException staffelE) {
                response.getWriter().write("Falsche Staffelnummer.");
                return;
            }

            StaffelBewertungHelper staffelBewertungHelper = new StaffelBewertungHelper();
            StaffelBewertung staffelBewertung = bewertungHelper.isExistedByStaffel(benutzer.getId(), nummer);
            if (staffelBewertung != null) {
                staffelBewertung.setRating(ratingLevel);
                staffelBewertung.setTextInhalt(inhalt);
                staffelBewertungHelper.updateStaffelBewertung(staffelBewertung);
            } else {
                StaffelHelper staffelHelper = new StaffelHelper();
                Staffel staffel = staffelHelper.getOne(nummer);
                staffelBewertungHelper.addStaffelBewertung(new StaffelBewertung(inhalt, ratingLevel, benutzer, staffel));
            }

        } else if (bewertungstyp.equals("episode")) {
            String s = request.getParameter("staffelnummer");
            String e = request.getParameter("episodenummer");
            int nummer, epiNummer;
            try {
                nummer = Integer.parseInt(s);
                epiNummer = Integer.parseInt(e);
            } catch (NumberFormatException episodeE) {
                response.getWriter().write("Falsche Staffelnummer order Episodenummer.");
                return;
            }

            EpisodeBewertungHelper episodeBewertungHelper = new EpisodeBewertungHelper();
            EpisodeBewertung episodeBewertung = bewertungHelper.isExistedByEpisode(benutzer.getId(), nummer, epiNummer);
            if (episodeBewertung != null) {
                episodeBewertung.setTextInhalt(inhalt);
                episodeBewertung.setRating(ratingLevel);

                //update Episodebewertung
                episodeBewertungHelper.updateEpisodeBewertung(episodeBewertung);
            } else {
                EpisodeHelper episodeHelper = new EpisodeHelper();
                Episode episode = episodeHelper.getOne(nummer, epiNummer);
                episodeBewertungHelper.addEpisodeBewertung(new EpisodeBewertung(inhalt, ratingLevel, benutzer, episode));
            }
        }

        response.sendRedirect("/bewertung");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BewertungHelper bewertungHelper = new BewertungHelper();
        int ratingDurchschnitt = bewertungHelper.getDurchschnitt();
        request.setAttribute("durchschnitt", ratingDurchschnitt);

        //Object[], [0]: Bewertung, [1]: Benutzer
//        List ratingsWithNutzer = bewertungHelper.getAllWithNutzer();
        List<Bewertung> ratingsAllNutzer = bewertungHelper.getAll();
        if (ratingsAllNutzer != null && !ratingsAllNutzer.isEmpty()) {
            request.setAttribute("ratingsAllNutzer", ratingsAllNutzer);
            request.setAttribute("durchschnitt", bewertungHelper.getDurchschnitt());
        }

        request.setAttribute("activeBewertung", 1);
        request.getRequestDispatcher("/templates/bewertung.ftl").forward(request, response);


    }
}
