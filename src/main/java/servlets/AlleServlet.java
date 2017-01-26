package servlets;

import crud.FigurHelper;
import crud.HausHelper;
import crud.StaffelHelper;
import entities.Figur;
import entities.Haus;
import entities.Staffel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlleServlet", urlPatterns = {"/alle"})
public class AlleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FigurHelper figurHelper = new FigurHelper();
        List<Figur> figuren = figurHelper.getAll();
        if (figuren != null && !figuren.isEmpty()) {
            request.setAttribute("figuren", figuren);
        }

        HausHelper hausHelper = new HausHelper();
        List<Haus> haeuser = hausHelper.getAll();
        if (haeuser != null && !haeuser.isEmpty()) {
            request.setAttribute("haeuser", haeuser);
        }

        StaffelHelper staffelHelper = new StaffelHelper();
        List<Staffel> staffeln = staffelHelper.getAll();
        if (staffeln != null && !staffeln.isEmpty()) {
            request.setAttribute("staffeln", staffeln);
        }

        request.getRequestDispatcher("/templates/alle.ftl").forward(request, response);
    }
}
