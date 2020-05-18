package io.amin.models;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CountryTest {

    @Test
    void getCountryFrom2ndLevelCache() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr-persistence-unit");

        // Session 1
        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();
        Country country1 = em1.find(Country.class, "EG");
        System.out.println(country1);
        em1.getTransaction().commit();
        em1.close();

        // Session 2
        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();
        Country country2 = em2.find(Country.class, "EG");
        System.out.println(country2);
        em2.getTransaction().commit();
        em2.close();

        emf.close();
        Assertions.assertTrue(true);
        
    }

/*

    Cache Concurrency Strategy, Based on use cases,
    we are free to pick one of the following cache concurrency strategies:

    READ_ONLY:
        Used only for entities that never change
        (exception is thrown if an attempt to update such an entity is made).
        It is very simple and performant.
        Very suitable for some static reference data that don't change

    NONSTRICT_READ_WRITE:
        Cache is updated after a transaction that changed the affected data has been committed.
        Thus, strong consistency is not guaranteed
        and there is a small time window in which stale data may be obtained from cache.
        This kind of strategy is suitable for use cases that can tolerate eventual consistency

    READ_WRITE:
        This strategy guarantees strong consistency which it achieves by using ‘soft' locks:
        When a cached entity is updated, a soft lock is stored in the cache for that entity as well,
        which is released after the transaction is committed.
        All concurrent transactions that access soft-locked entries
        will fetch the corresponding data directly from database

    TRANSACTIONAL:
        Cache changes are done in distributed XA transactions.
        A change in a cached entity is either committed or rolled back in both
        database and cache in the same XA transaction

*/


/*

Internal Representation of Cached State
    Entities are not stored in second-level cache as Java instances,
    but rather in their disassembled (hydrated) state:

    - Id (primary key) is not stored (it is stored as part of the cache key)
    - Transient properties are not stored
    - Collections are not stored (see below for more details)
    - Non-association property values are stored in their original form
    - Only id (foreign key) is stored for ToOne associations
    - This depicts general Hibernate second-level cache design in which cache model
        reflects the underlying relational model,
        which is space-efficient and makes it easy to keep the two synchronized.


Internal Representation of Cached Collections

    we have to explicitly indicate that a collection (OneToMany or ManyToMany association)
    is cacheable, otherwise it is not cached.

    Hibernate stores collections in separate cache regions, one for each collection.
    The region name is a fully qualified class name plus the name of collection property,
    for example: com.baeldung.hibernate.cache.model.Foo.bars.
    This gives us the flexibility to define separate cache parameters for collections,
    e.g. eviction/expiration policy.

    Only ids of entities contained in a collection are cached for each collection entry,
    which means that in most cases it is a good idea to make the contained entities cacheable as well.

 */

}
