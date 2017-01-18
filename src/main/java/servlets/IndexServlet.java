package servlets;

import crud.PlaylisteHelper;
import entities.Playliste;

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
        PlaylisteHelper playlisteHelper = new PlaylisteHelper();
        List<Playliste> results = playlisteHelper.getAll();

        if (results != null && !results.isEmpty()) {
            request.setAttribute("playlisten", results);
        }

        request.setAttribute("activeStart", 1);
        request.getRequestDispatcher("/templates/index.ftl").forward(request, response);
    }
}
