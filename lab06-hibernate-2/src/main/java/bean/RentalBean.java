package bean;

import dao.RentalDAO;
import entity.Rental;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RentalBean implements Serializable
{
    private RentalDAO rentalDAO = new RentalDAO();

    public List<Rental> getAllRental()
    {
        return rentalDAO.findAll();
    }
}
