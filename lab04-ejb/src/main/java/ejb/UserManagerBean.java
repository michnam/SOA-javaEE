package ejb;

import model.User;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.HashMap;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@Startup
public class UserManagerBean implements UserManager
{
    private HashMap<String, User> users;

    @PostConstruct
    public void setupUsers()
    {
        users = new HashMap<String, User>();
        users.put("adam", new User("adam","123", 30));
        users.put("maciek", new User("maciek","123", 40));
        users.put("andrzej", new User("andrzej","123", 50));
    }

    @Lock(READ)
    public User getUser(String username)
    {
        return users.get(username);
    }

    @Lock(READ)
    public boolean checkCredentials(String username, String password)
    {
        if(users.containsKey(username))
            return password.equals(users.get(username).getPassword());
        return false;
    }

    @Lock(WRITE)
    public void updateUser(String username, int balance)
    {
        User old = getUser(username);
        User tmp = new User(username, old.getPassword(), balance);
        users.replace(username, tmp);
    }
}
