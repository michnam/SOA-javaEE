package ejb;

import model.Seat;

import javax.ejb.EJB;
import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface SeatAvailability
{
    ArrayList<String> getFreeSeats();
}
