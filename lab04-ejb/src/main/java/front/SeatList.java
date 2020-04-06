package front;

import ejb.SeatAvailability;
import model.Seat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class SeatList implements Serializable
{
    @EJB
    private SeatAvailability seatAvailability;
    private ArrayList<String> seats;

    @PostConstruct
    private void setup()
    {
        seats = seatAvailability.getFreeSeats();
    }

    public String refresh()
    {
        seats = seatAvailability.getFreeSeats();
        return "reservation";
    }


    public ArrayList<String> getSeats()
    {
        return seats;
    }
}
