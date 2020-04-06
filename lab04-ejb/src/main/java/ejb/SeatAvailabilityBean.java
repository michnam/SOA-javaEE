package ejb;

import model.Seat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class SeatAvailabilityBean implements SeatAvailability
{

    @EJB
    private SeatManager seatManager;

    @Override
    public ArrayList<String> getFreeSeats()
    {
        ArrayList<Seat> seats = seatManager.getSeatList();
        ArrayList<String> freeSeats = new ArrayList<>();

        for(Seat s : seats)
        {
            if(!s.isBooked())
            {
                freeSeats.add(s.toString());
            }
        }

        return freeSeats;
    }
}
