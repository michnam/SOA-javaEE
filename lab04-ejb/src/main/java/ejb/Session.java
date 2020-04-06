package ejb;

import javax.ejb.Local;

@Local
public interface Session
{
    boolean login(String username, String password);
    int getBalance();
    boolean buySeat(int id);
}
