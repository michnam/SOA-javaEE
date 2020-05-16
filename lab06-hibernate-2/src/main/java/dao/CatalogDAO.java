package dao;

import entity.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CatalogDAO
{
    private EntityManager em;

    public CatalogDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<Catalog> findAll()
    {
        Query query = em.createQuery("from Catalog ");
        return  query.getResultList();
    }

    public Catalog findById(int id)
    {
        return em.find(Catalog.class, id);
    }

    public void addCatalog(Catalog toAdd)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add catalog entry! ");
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void updateCatalog(Catalog updatedCatalog)
    {
        Catalog catalog = em.find(Catalog.class, updatedCatalog.getId());
        try
        {
            em.getTransaction().begin();
            catalog.setBook(updatedCatalog.getBook());
            catalog.setCondition(updatedCatalog.getCondition());
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update catalog entry");
            em.getTransaction().rollback();
        }
    }
}
