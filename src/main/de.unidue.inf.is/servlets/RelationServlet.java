package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import crud.PersonHelper;
import crud.RelationHelper;
import entities.Person;
import entities.Relation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by Yafei on 12/01/2017.
 */
@WebServlet(name = "RelationServlet", urlPatterns = {"/relation"})
public class RelationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activeRelation", 1);
        request.getRequestDispatcher("/templates/relationWithName.ftl").forward(request, response);
    }
}
