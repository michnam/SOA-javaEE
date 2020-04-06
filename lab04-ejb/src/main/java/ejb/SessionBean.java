package ejb;

import model.User;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class SessionBean implements Session
{
    @EJB
    private SeatManager seatManager;

    @EJB
    private UserManager userManager;


    private User user;

    public boolean login(String username, String password)
    {
        if(userManager.checkCredentials(username, password))
        {
            user = userManager.getUser(username);
            return true;
        }
        return false;
    }

    public int getBalance()
    {
        return user.getBalance();
    }

    public boolean buySeat(int id)
    {
        int price = seatManager.getSeatPrice(id);
        int balance = user.getBalance();

        if(balance < price) return false;
        if(!seatManager.buyTicket(id))
        {
            return false;
        }
        user.setBalance(balance - price);
        return true;
    }


}
