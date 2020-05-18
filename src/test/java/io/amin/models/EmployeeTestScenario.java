package io.amin.models;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTestScenario {

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
//    @Disabled
    void getEmployees() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> rootEntry = cq.from(Employee.class);
        CriteriaQuery<Employee> all = cq.select(rootEntry);
        TypedQuery<Employee> allQuery = entityManager.createQuery(all);
        List<Employee> employees = allQuery.getResultList();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        assertTrue(employees.size() > 0);
    }

    @Test
    @Order(1)
    void createEmployee() {
        Employee employee = new Employee();
        employee.setId(999);
        employee.setFirstName("Ahmed");
        employee.setLastName("Aboulroos");
        employee.setCommissionPct(0.30f);
        employee.setEmail("ahmedaboulroos@gmail.com");
        employee.setHireDate(LocalDate.of(2020, 5, 18));
        employee.setPhoneNumber("01096257562");
        employee.setSalary(5000.00);
        employee.setJob(entityManager.find(Job.class, "IT_PROG"));
        entityManager.persist(employee);
    }

    @Test
    @Order(2)
    void readEmployee() {
        Employee employee = entityManager.find(Employee.class, 999);
        System.out.println("\n" + employee + "\n");
        assertAll(
                () -> assertEquals(999, employee.getId()),
                () -> assertEquals("Ahmed", employee.getFirstName()),
                () -> assertEquals("Aboulroos", employee.getLastName()),
                () -> assertEquals(0.30f, employee.getCommissionPct()),
                () -> assertEquals("ahmedaboulroos@gmail.com", employee.getEmail()),
                () -> assertEquals(LocalDate.of(2020, 5, 18), employee.getHireDate()),
                () -> assertEquals("01096257562", employee.getPhoneNumber()),
                () -> assertEquals(5000.00, employee.getSalary())
        );
    }

    @Test
    @Order(3)
    void updateEmployee() {
        Employee employee = entityManager.find(Employee.class, 999);
        employee.setFirstName("Amin");
        employee.setLastName("Eltineen");
        employee.setSalary(10_000.00);
        entityManager.persist(employee);
    }

    @Test
    @Order(4)
    void readEmployeeAgain() {
        Employee employee = entityManager.find(Employee.class, 999);
        System.out.println("\n" + employee + "\n");
        assertAll(
                () -> assertEquals(999, employee.getId()),
                () -> assertEquals("Amin", employee.getFirstName()),
                () -> assertEquals("Eltineen", employee.getLastName()),
                () -> assertEquals(0.30f, employee.getCommissionPct()),
                () -> assertEquals("ahmedaboulroos@gmail.com", employee.getEmail()),
                () -> assertEquals(LocalDate.of(2020, 5, 18), employee.getHireDate()),
                () -> assertEquals("01096257562", employee.getPhoneNumber()),
                () -> assertEquals(10_000.00, employee.getSalary())
        );
    }

    @Test
    @Disabled
    @Order(5)
    void deleteEmployee() {
//        there is a routine that creates a job history automatically in the database
//        it must be deleted first before deleting the employee

        Employee employee = entityManager.find(Employee.class, 999);
        entityManager.remove(employee);
    }

}
