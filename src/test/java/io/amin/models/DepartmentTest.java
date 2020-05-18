package io.amin.models;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DepartmentTest {

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
    void addDepartmentWithoutID() {
        Department department = new Department();
        department.setName("Minions");
        department.setManager(null);

        entityManager.persist(department);
        Assertions.assertTrue(true);
    }

}
