package dao;

import entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CategoryDAO
{
    private EntityManager em;

    public CategoryDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<Category> findAll()
    {
        Query query = em.createQuery("from Category");
        return  query.getResultList();
    }
}
