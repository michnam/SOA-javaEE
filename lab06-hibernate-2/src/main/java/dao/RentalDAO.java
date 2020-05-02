package dao;

import entity.Rental;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RentalDAO
{
    private EntityManager em;

    public RentalDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<Rental> findAll()
    {
        Query query = em.createQuery("from Rental ");
        return  query.getResultList();
    }

    public Rental findById(int id)
    {
        return em.find(Rental.class, id);
    }

    public void delete(Rental rental)
    {

    }

}
