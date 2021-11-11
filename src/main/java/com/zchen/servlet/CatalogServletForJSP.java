package com.zchen.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet("/CatalogServletForJSP")
public class CatalogServletForJSP extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServletForJSP() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append(request.getParameter("name"));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        String sku = request.getParameter("sku");

        response.setHeader("someHeader", "someHeaderValue");
        response.addCookie(new Cookie("someCookie", "someCookieValue"));

        Catalog.addItem(new CatalogItem(name, manufacturer, sku));

        request.setAttribute("items", Catalog.getItems());
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsps/list.jsp");
        dispatcher.forward(request, response);
    }

}
