package servlets;

import crud.BenutzerHelper;
import crud.BewertungHelper;
import entities.Bewertung;

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
        //if (anlegen.equals("anlegen")) {
            String loginKennung = request.getParameter("loginKennung");
            int benutzerId = benutzerHelper.getBenutzerId(loginKennung);
            String inhalt = request.getParameter("bewertungsInhalt");
            String niveau = request.getParameter("bewertungsNiveau");

            if (bewertungHelper.isExisted(benutzerId)) {
                Bewertung b = bewertungHelper.deleteBewertung(benutzerId);
                //response.getWriter().write(b.getBenutzerid() + " ");
                b.setRating(Integer.parseInt(niveau));
                b.setTextInhalt(inhalt);
                b.setBenutzerid(benutzerId);
                bewertungHelper.addBewertung(b);
            } else {
                bewertungHelper.addBewertung(new Bewertung(1, benutzerId, inhalt, Integer.parseInt(niveau)));
            }


//            bewertungHelper.addBewertung(bewertung);
       // }
        response.sendRedirect("/bewertung");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BewertungHelper bewertungHelper = new BewertungHelper();
        int ratingDurchschnitt = bewertungHelper.getDurchschnitt();
        request.setAttribute("durchschnitt", ratingDurchschnitt);

        //Object[], [0]: Bewertung, [1]: Benutzer
        List ratingsWithNutzer = bewertungHelper.getAllWithNutzer();
        if (ratingsWithNutzer != null && !ratingsWithNutzer.isEmpty()) {
            request.setAttribute("ratingsWithNutzer", ratingsWithNutzer);
        }

        request.setAttribute("activeBewertung", 1);
        request.getRequestDispatcher("/templates/bewertung.ftl").forward(request, response);


    }
}
