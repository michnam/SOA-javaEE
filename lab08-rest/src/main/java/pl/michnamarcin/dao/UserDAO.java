package pl.michnamarcin.dao;

import pl.michnamarcin.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO
{
    private static EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();

    public static List<User> findAll()
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        return em.createQuery("from User").getResultList();
    }

    public static User findById(int id)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        return em.find(User.class, id);
    }

    public static void add(User toAdd)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
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

    public static void update(User updatedUser)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        User user = em.find(User.class, updatedUser.getId());
        try
        {
            em.getTransaction().begin();
            user.setUsername(updatedUser.getUsername());
            user.setAge(updatedUser.getAge());
            user.setAvatar(updatedUser.getAvatar());
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update user");
            em.getTransaction().rollback();
        }
    }


    public static void delete(int id)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        try
        {
            User tmp = em.find(User.class, id);
            em.getTransaction().begin();
            em.remove(tmp);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            System.out.println("Couldn't remove user");
            em.getTransaction().rollback();
        }
    }

}
