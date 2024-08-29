package it.bozzoni;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");
        root.addElement("message").addText("Hello, World with DOM4J!");

        resp.setContentType("text/xml");
        resp.getWriter().write(document.asXML());
    }
}
