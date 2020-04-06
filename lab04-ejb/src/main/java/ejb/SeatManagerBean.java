package ejb;

import model.Seat;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@Startup
public class SeatManagerBean implements SeatManager
{

    private ArrayList<Seat> seats;

    @PostConstruct
    public void setupSeats()
    {
        seats = new ArrayList<>();
        int id = 0;
        for(int i = 0; i < 5; i++)
        {
            seats.add(new Seat(id, "class A", 20));
            id+=1;
        }
        for(int i = 0; i < 5; i++)
        {
            seats.add(new Seat(id, "class B", 10));
            id+=1;
        }

    }

    @Lock(READ)
    public ArrayList<Seat> getSeatList()
    {
        return seats;
    }

    @Lock(READ)
    public int getSeatPrice(int id)
    {
        return seats.get(id).getPrice();
    }


    @Lock(WRITE)
    public boolean buyTicket(int id)
    {
        if(seats.get(id).isBooked()) return false;
        seats.get(id).setBooked(true);
        return true;
    }


}
