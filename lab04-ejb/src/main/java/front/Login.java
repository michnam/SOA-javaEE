package front;

import ejb.Session;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Login implements Serializable
{
    @EJB
    private Session session;

    private String username;
    private String password;
    private String chosenSeat;

    public String login()
    {
            if(session.login(username, password))
                return "reservation";
            return  "login";
    }

    public String getChosenSeat()
    {
        return chosenSeat;
    }

    public void setChosenSeat(String chosenSeat)
    {
        this.chosenSeat = chosenSeat;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getBalance()
    {
        return session.getBalance();
    }

    public String buySeat()
    {
        String[] tmp = chosenSeat.split(",");
        String[] tmp2 = tmp[0].split(" ");
        int id = Integer.parseInt(tmp2[1]);
        boolean success = session.buySeat(id);
        if(success) return "reservation_done";
        return "reservation_error";
    }
}
