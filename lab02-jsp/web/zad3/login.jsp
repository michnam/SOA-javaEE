<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="zad3.DaneOsobowe" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zad 3 - login</title>
</head>
<body>
    <div>
        <%
            Vector<DaneOsobowe> daneOsobowes = new Vector<DaneOsobowe>(Arrays.asList(new DaneOsobowe("andrzej","1","Andrzej","Kowalski","andrzejek@gmail.com"), new DaneOsobowe("marcin","123","Marcin","Nowak","marcin@gmail.com")));
            List<String> parameterNames = new ArrayList<>(request.getParameterMap().keySet());
            String name = null;
            String surname = null;
            String email = null;

            if(parameterNames.contains("login") && request.getParameter("login").equals(""))
                out.println("Nie podales loginu! <br><br>");
            else if(parameterNames.contains("passw") && request.getParameter("passw").equals(""))
                out.println("Nie podales hasla! <br><br>");
            else if(parameterNames.contains("login") && parameterNames.contains("passw"))
            {
                boolean correct = false;
                for(DaneOsobowe d : daneOsobowes)
                {
                    if(d.getUsername().equals(request.getParameter("login")) && d.getPassw().equals(request.getParameter("passw")))
                    {
                        correct = true;
                        name = d.getName();
                        surname = d.getSurname();
                        email = d.getEmail();
                    }


                }

                if(correct)
                {
                    session.setAttribute("username", request.getParameter("login"));
                    session.setAttribute("name", name);
                    session.setAttribute("surname", surname);
                    session.setAttribute("email", email);
                    response.sendRedirect("ksiega-gosci");
                }
                else
                    out.println("Niepoprawne dane! <br><br>");

            }
        %>
    </div>

    <div>
        <form action = 'login' method='post'>
            <label>Login:<br> <input type='text' name='login' /> </label> <br>
            <label>Haslo:<br><input type='password' name='passw'/> </label> <br>
            <br> <input type='submit' value='Zaloguj'/>
        </form>
    </div>


</body>
</html>
