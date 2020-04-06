package ejb;

import model.User;

import javax.ejb.Local;

@Local
public interface UserManager
{
    boolean checkCredentials(String username, String password);
    void updateUser(String username, int balance);
    User getUser(String username);
}
