package servlets;

import crud.StaffelBewertungHelper;
import crud.StaffelHelper;
import entities.Staffel;
import freemarker.template.*;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yafei on 09/01/2017.
 */
@WebServlet(name = "StaffelServlet", urlPatterns = {"/staffel"})
public class StaffelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StaffelHelper staffelHelper = new StaffelHelper();
        List<Staffel> staffeln = staffelHelper.getAll();
        request.setAttribute("staffeln", staffeln);

        StaffelBewertungHelper staffelBewertungHelper = new StaffelBewertungHelper();
        int[] ratings = new int[staffeln.size()];
        for (Staffel s : staffeln) {
            int i = s.getNummer();
            ratings[i - 1] = staffelBewertungHelper.getAllByStaffel(i);
        }
        request.setAttribute("ratings", ratings);
        request.setAttribute("activeStaffel", 1);

        try {
            request.getRequestDispatcher("/templates/staffel.ftl").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("errormessage", "Template error: please contact the admin.");
            e.printStackTrace();
        }

    }
}
