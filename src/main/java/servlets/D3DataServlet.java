package servlets;

import com.google.gson.Gson;
import crud.RelationHelper;
import db.D3NetworkJson;
import db.PersonLink;
import db.PersonNode;
import entities.Relation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by Yafei on 13/01/2017.
 */
@WebServlet(name = "D3DataServlet", urlPatterns = {"/d3data"})
public class D3DataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer out = response.getWriter();
        Gson gson = new Gson();

        RelationHelper relationHelper = new RelationHelper();
        //List results = relationHelper.getAllWithPeronen();
        List<Relation> results = relationHelper.getAll();
        int len = results.size();

        PersonNode[] nodes = new PersonNode[2*len];
        PersonLink[] links = new PersonLink[len];
        D3NetworkJson networkJson = new D3NetworkJson(nodes, links);
        for (int i = 0; i < len; i++) {
//            int figurida = (int)((Object[])results.get(i))[0];
//            int figuridb = (int)((Object[])results.get(i))[1];
//            String namea = (String)((Object[])results.get(i))[2];
//            String nameb = (String)((Object[])results.get(i))[3];
            Relation r = results.get(i);
//            int figurida = r.getPersonen().getId();
//            int figuridb = r.getFreunde().getId();
            String namea = r.getPersonen().getName();
            String nameb = r.getFreunde().getName();
            nodes[i] = new PersonNode(namea, namea, 1);
            nodes[i + len] = new PersonNode(nameb, nameb, 1);
            links[i] = new PersonLink(i, i + len, 1);
        }

        gson.toJson(networkJson, out);


        // Debug
//        File file = new File("/Users/Yafei/IdeaProjects/DB/web/jsonfiles/test.json");
//        FileInputStream fis = new FileInputStream(file);
//        byte[] data = new byte[(int) file.length()];
//        fis.read(data);
//        fis.close();
//
//        String str = new String(data, "UTF-8");
//
//        out.write(str);

    }
}
