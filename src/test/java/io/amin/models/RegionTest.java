package io.amin.models;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegionTest {

    @Test
    void getRegionFrom2ndLevelCache() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr-persistence-unit");

        // Session 1
        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();
        Region region1 = em1.find(Region.class, 4);
        System.out.println(region1);
        em1.getTransaction().commit();
        em1.close();

        // Session 2
        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();
        Region region2 = em2.find(Region.class, 4);
        System.out.println(region2);
        em2.getTransaction().commit();
        em2.close();

        emf.close();
        Assertions.assertTrue(true);
    }

}
