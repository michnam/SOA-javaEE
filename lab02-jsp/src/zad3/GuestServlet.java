package zad3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "GuestServlet")
public class GuestServlet extends HttpServlet
{
    private static Vector<Guest> guests = new Vector<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        try
        {
            if(request.getParameter("logout").equals("yes"))
            {
                session.invalidate();
                response.sendRedirect("login");
            }
        }
        catch(Exception ignored) {}
        String username = (String)session.getAttribute("username");
        if(username == null)
            response.sendRedirect("login");
        //add new guest
        List<String> parameterNames = new ArrayList<>(request.getParameterMap().keySet());
        if(parameterNames.size() != 0)
            guests.add(new Guest(request.getParameter("name"), request.getParameter("email"), request.getParameter("comment")));

        response.sendRedirect("ksiega-gosci");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String name = (String)session.getAttribute("name");
        String surname = (String)session.getAttribute("surname");
        String email = (String)session.getAttribute("email");
        if(username == null)
            response.sendRedirect("login");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        out.println("<html>");
        out.println(("<head> <title>Zad 3 - Ksiega gosci </title> </head> <body>"));
        out.println("<div>Witaj " + username + "!  <form action = 'ksiega-gosci' method='post'> <button name='logout' type='submit' value='yes'> Wyloguj </button>  </form> <br><br> </div>");

        //form
        out.println("Zostaw po sobie slad:");
        out.println("<form action = 'ksiega-gosci' method='post'><br><label>Twoje imie: <input type='text' name='name' value='"+ name + " " + surname +"'/></label> <br> <label>Twoj email: <input type='text' name='email' value='"+ email + "'/></label> <br> <label>Komentarz: <input type='text' name='comment'/></label> <br>");
        out.println("<br> <input type='submit' value='Wyslij'/> </form> ");

        //guests
        for( Guest g : guests)
        {
            out.println("<div>" + g.getName() + " (" + g.getEmail() + ") napisal: <br>");
            out.println("<p style='text-indent: 20px;'> " +  g.getComment() + "</p>");
        }


        out.println("</body> </html>");
        out.close();
    }
}
