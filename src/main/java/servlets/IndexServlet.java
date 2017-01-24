package servlets;

import crud.PlaylisteHelper;
import crud.SuchenHelper;
import entities.Figur;
import entities.Haus;
import entities.Playliste;
import entities.Staffel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yafei on 14/01/2017.
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SuchenHelper suchenHelper = new SuchenHelper();
        List<Figur> figuren = suchenHelper.getFigurLimit(5);
        if (figuren != null && !figuren.isEmpty()) {
            request.setAttribute("figuren", figuren);
        }
        List<Haus> haeuser = suchenHelper.getHausLimit(5);
        if (haeuser != null && !haeuser.isEmpty()) {
            request.setAttribute("haeuser", haeuser);
        }
        List<Staffel> staffeln = suchenHelper.getStaffelLimit(5);
        if (staffeln != null && !staffeln.isEmpty()) {
            request.setAttribute("staffeln", staffeln);
        }
        List<Playliste> playlisten = suchenHelper.getPlaylisteLimit(5);
        if (playlisten != null && !playlisten.isEmpty()) {
            request.setAttribute("playlisten", playlisten);
        }

        request.setAttribute("activeStart", 1);
        request.getRequestDispatcher("/templates/index.ftl").forward(request, response);
    }
}
