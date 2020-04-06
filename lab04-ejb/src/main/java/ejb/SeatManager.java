package ejb;

import model.Seat;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface SeatManager
{
    ArrayList<Seat> getSeatList();
    int getSeatPrice(int id);
    boolean buyTicket(int id);
}
