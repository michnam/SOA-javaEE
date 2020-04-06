package zad2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AgeFilter")
public class AgeFilter implements Filter
{
    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        if(req.getParameterMap().keySet().size() == 0)
        {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println(("<head> <title>Zad 2 - Potwierdz wiek </title> </head> <body>"));
            out.println("<form action = 'form' method='get'> <label>Dowodzik jest?<input type='radio' name='age' value='yes'/> Tak <input type='radio' name='age' value='no'/> Nie</label> ");
            out.println("<br> <input type='submit' value='Wyslij'/> </form> ");
            out.println("</body> </html>");
            out.close();
        }
        else if(req.getParameter("age").equals("yes"))
            chain.doFilter(req, resp);
        else
        {
            PrintWriter out = resp.getWriter();
            out.println("Nie ma dowodziku - nie ma piwa");
            out.close();
        }
    }

    public void init(FilterConfig config) throws ServletException
    {

    }


}
