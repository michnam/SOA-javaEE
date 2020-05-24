package pl.michnamarcin.app;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.michnamarcin.entity.User;
import pl.michnamarcin.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserBean implements Serializable
{
    private ResteasyClient client = new ResteasyClientBuilder().build();
    private ResteasyWebTarget target = client.target(UriBuilder.fromPath("http://localhost:8080/rest"));
    private UserService proxy = target.proxy(UserService.class);

    private User toAdd = new User();
    private User toUpdate = new User();



    public List<User> findAllUsers()
    {
        return proxy.findAllUsers();
    }

    public void deleteUser(User user)
    {
        Response userResponse = proxy.deleteUser(user.getId());
        System.out.println("HTTP code: " + userResponse.getStatus());
        userResponse.close();
    }

    public String goUpdate(User user)
    {
        toUpdate = user;
        return "update-user";
    }

    public String updateUser()
    {
        proxy.updateUser(toUpdate);
        return "index";
    }

    public String addUser()
    {
        proxy.addUser(toAdd);
        toAdd = new User();
        return "index";
    }



    public User getToAdd()
    {
        return toAdd;
    }

    public void setToAdd(User toAdd)
    {
        this.toAdd = toAdd;
    }

    public User getToUpdate()
    {
        return toUpdate;
    }

    public void setToUpdate(User toUpdate)
    {
        this.toUpdate = toUpdate;
    }
}
