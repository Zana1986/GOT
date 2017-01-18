package servlets;

import crud.SuchenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yafei on 17/01/2017.
 */
@WebServlet(name = "SuchenServlet", urlPatterns = {"/suchen"})
public class SuchenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("suchInfo");
        String type = request.getParameter("suchTyp");
        SuchenHelper suchenHelper = new SuchenHelper();
        List results = null;

        if (type.equals("Figur")) {
            results = suchenHelper.getFigurLike(info);
            request.setAttribute("figur", 1);
        } else if (type.equals("Haus")) {
            results = suchenHelper.getHausLike(info);
            request.setAttribute("haus", 1);
        } else if (type.equals("Staffel")) {
            int nummer;
            if (info.equals("")) nummer = 1;
            else nummer = Integer.parseInt(info);
            results = suchenHelper.getStaffelLike(nummer);
            request.setAttribute("staffel", 1);
        } else if (type.equals("Playliste")) {
            int nummer = Integer.parseInt(info);
            results = suchenHelper.getPlaylisteLike(nummer);
            request.setAttribute("playliste", 1);
        } else {
            response.getWriter().write("Nichts zu suchen.");
        }

        if (results != null && !results.isEmpty()) {
            request.setAttribute("suchErgebnis", results);
            //response.getWriter().write("Nichts zu suchen.");
            request.getRequestDispatcher("/templates/suchErgebnis.ftl").forward(request, response);
        } else {
            response.getWriter().write("Nichts zu suchen.");
        }
    }
}
