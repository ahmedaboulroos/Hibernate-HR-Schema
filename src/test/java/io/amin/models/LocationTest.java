package io.amin.models;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocationTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hr-persistence-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @BeforeEach
    void beforeEach() {
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void afterEach() {
        entityManager.getTransaction().commit();
    }

    @Test
    void addLocationWithoutId() {
        Location location = new Location();
        location.setCity("minioooooooooons");
        entityManager.persist(location);
        Assertions.assertTrue(true);
    }

}
