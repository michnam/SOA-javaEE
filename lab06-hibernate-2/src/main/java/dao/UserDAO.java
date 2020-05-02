package dao;

import entity.Book;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDAO
{
    private EntityManager em;

    public UserDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<User> findAll()
    {
        Query query = em.createQuery("from User ");
        return  query.getResultList();
    }

    public User findById(int id)
    {
        return em.find(User.class, id);
    }



    public void addUser(User toAdd)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add user");
            em.getTransaction().rollback();
        }
    }

    public void updateUser(User updatedUser)
    {
        User user = em.find(User.class, updatedUser.getId());
        try
        {
            em.getTransaction().begin();
            user.setUserName(updatedUser.getUserName());
            user.setUserSurname(updatedUser.getUserSurname());
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update user");
            em.getTransaction().rollback();
        }
    }

}
