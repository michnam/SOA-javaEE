package dao;

import entity.Borrow;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BorrowDAO
{
    private EntityManager em;

    public BorrowDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<Borrow> findAll()
    {
        Query query = em.createQuery("from Borrow ");
        return  query.getResultList();
    }

    public Borrow findById(int id)
    {
        return em.find(Borrow.class, id);
    }

    public void delete(Borrow borrow)
    {
        try
        {
            Borrow tmp = em.find(Borrow.class, borrow.getId());
            em.getTransaction().begin();
            em.remove(tmp);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            System.out.println("Couldn't remove borrow");
            em.getTransaction().rollback();
        }
    }

    public void add(Borrow borrow)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(borrow);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            System.out.println("Couldn't add borrow");
            em.getTransaction().rollback();
        }
    }

    public void update(Borrow borrow)
    {
        System.out.println("Borrow id " + borrow.getId());
        Borrow tmp = em.find(Borrow.class, borrow.getId());
        try
        {
            em.getTransaction().begin();
            tmp.setCatalog(borrow.getCatalog());
            tmp.setUser(borrow.getUser());
            tmp.setRentDate(borrow.getRentDate());
            if(borrow.getReturnDate() != null) tmp.setReturnDate(borrow.getReturnDate());
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update borrow entry");
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

}
