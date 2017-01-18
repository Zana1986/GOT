package servlets;

import crud.FigurHelper;
import crud.OrtHelper;
import crud.PersonHelper;
import crud.TierHelper;
import entities.Figur;
import entities.Ort;
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
@WebServlet(name = "OrtServlet", urlPatterns = {"/ort"})
public class OrtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrtHelper ortHelper = new OrtHelper();
        List<Ort> orte = ortHelper.getAll();

        request.setAttribute("orte", orte);
        request.setAttribute("activeOrt", 1);
        request.getRequestDispatcher("/templates/ort.ftl").forward(request, response);
    }
}
