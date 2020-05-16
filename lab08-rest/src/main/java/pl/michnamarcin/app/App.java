package pl.michnamarcin.app;

import pl.michnamarcin.rest.MovieController;
import pl.michnamarcin.rest.UserController;
import pl.michnamarcin.rest.UserRedirectionController;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class App extends Application
{
    private Set<Object> singletons = new HashSet<>();

    public App()
    {
        singletons.add(new MovieController());
        singletons.add(new UserController());
        singletons.add(new UserRedirectionController());
    }



    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
