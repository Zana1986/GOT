package servlets;

import crud.PlaylisteHelper;
import entities.Playliste;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "PlaylisteServlet", urlPatterns = {"/playliste", "/playliste/*"})
public class PlaylisteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/playliste/neu")) {
            String loginKennung = request.getParameter("loginKennung");
            String playlisteName = request.getParameter("playlisteName");
            if (loginKennung != null) {
                PlaylisteHelper playlisteHelper = new PlaylisteHelper();
                Playliste playliste = playlisteHelper.neuePlayliste(playlisteName, loginKennung);
            }
            response.sendRedirect("/index");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaylisteHelper playlisteHelper = new PlaylisteHelper();

        String path = URLDecoder.decode(request.getRequestURI(), "UTF-8");
        String pattern = "^/playliste/([1-9][0-9]{0,4})$";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(path);
        if (m.find()) {
            int playlistId = Integer.parseInt(m.group(1));
            if (playlistId >= 1) {
                Playliste playliste = playlisteHelper.getOne(playlistId);
                request.setAttribute("playliste", playliste);
            }
            request.getRequestDispatcher("/templates/playlisteDetail.ftl").forward(request, response);
        } else if (!request.getRequestURI().equals("/playliste")) {
            String loginKennung = request.getParameter("loginKennung");
            if (loginKennung != null) {
                Playliste playliste = playlisteHelper.neuePlayliste("Playliste 1024", loginKennung);
                if (playliste != null) {
                    request.setAttribute("playliste", playliste);
                }
            }
            request.getRequestDispatcher("/templates/playlisteDetail.ftl").forward(request, response);
        } else {
            List<Playliste> playlisten = playlisteHelper.getAll();

            if (playlisten != null && !playlisten.isEmpty()) {
                request.setAttribute("playlisten", playlisten);
            }
            request.getRequestDispatcher("/templates/playliste.ftl").forward(request, response);
        }
    }
}
