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
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yafei on 17/01/2017.
 */
@WebServlet(name = "TierDetailServlet", urlPatterns = {"/tier/*"})
public class TierDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TierHelper tierHelper = new TierHelper();


        String path = URLDecoder.decode(request.getRequestURI(), "UTF-8");
        String tierName;
        String pattern = "^/tier/([a-zA-Z\\s]+)[/]?";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(path);
        if (m.find()) {
            tierName = m.group(1);
            Tier tier = tierHelper.getOneByName(tierName);
            if (tier != null) {
                request.setAttribute("tier", tier);
            }
            request.getRequestDispatcher("/templates/tierDetail.ftl").forward(request, response);
        }
    }
}
