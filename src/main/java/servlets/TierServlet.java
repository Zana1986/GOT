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
import java.util.List;

/**
 * Created by Yafei on 18/01/2017.
 */
@WebServlet(name = "TierServlet", urlPatterns = {"/tier"})
public class TierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TierHelper tierHelper = new TierHelper();
        List<Tier> tiere = tierHelper.getAll();

        request.setAttribute("tiere", tiere);
        //response.getWriter().write(personen.get(0).getName() + "");
        request.setAttribute("activeTier", 1);
        request.getRequestDispatcher("/templates/tier.ftl").forward(request, response);
    }
}
