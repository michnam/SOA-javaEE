import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "Zad1")
public class Zad1 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();

        List<String> parameterNames = new ArrayList<>(request.getParameterMap().keySet());
        List<Double> numbers = new ArrayList<>();
        try
        {
            for(String s : parameterNames)
            {
                numbers.add(Double.parseDouble(request.getParameter(s)));
            }
            Collections.sort(numbers);


            // creating html response
            out.println("<html>");
            out.println(("<head> <title>Zad 1 - Liczby w kolejnosci </title> </head> <body>"));
            out.println("<br> Liczby w kolejnosci rosnacej: <br>");

            for(Double d : numbers)
            {
                out.println("<br> " + d);
            }

            out.println("</body> </html>");
            out.close();
        }
        catch(Exception e)
        {
            out.println("Wszystkie parametry musza być liczbami");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        int l1 = Integer.parseInt(request.getParameter("l1"));
        int l2 = Integer.parseInt(request.getParameter("l2"));
        int l3 = Integer.parseInt(request.getParameter("l3"));
        int l4 = Integer.parseInt(request.getParameter("l4"));
        int l5 = Integer.parseInt(request.getParameter("l5"));
        int mean = (l1 + l2 + l3 + l4 + l5)/5;
        out.println("<html>");
        out.println(("<head> <title>Zad 1 - Srednia 5 liczb </title> </head>"));
        out.println("<body>Zaokraglona srednia liczb: " + mean +  "</body> </html>");
        out.close();
    }
}
