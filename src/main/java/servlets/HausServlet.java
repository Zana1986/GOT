package servlets;

import crud.HausBewertungHelper;
import crud.HausHelper;
import entities.Haus;

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
@WebServlet(name = "HausServlet", urlPatterns = {"/haus"})
public class HausServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HausBewertungHelper hausBewertungHelper = new HausBewertungHelper();
//        List hausBewertungen = hausBewertungHelper.getAll();
//        if (hausBewertungen != null && !hausBewertungen.isEmpty()) {
//            request.setAttribute("");
//        }


        HausHelper hausHelper = new HausHelper();
        List<Haus> haeuser = hausHelper.getAll();
        if (haeuser != null && !haeuser.isEmpty()) {
            request.setAttribute("haeuser", haeuser);
            //request.setAttribute("activeHaus", 1);
            request.getRequestDispatcher("/templates/haus.ftl").forward(request, response);
        }
    }
}
