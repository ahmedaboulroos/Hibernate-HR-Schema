package io.amin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "REGIONS")

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Region {

    @Id
    @Column(name = "REGION_ID")
    private Integer id;

    @Column(name = "REGION_NAME")
    private String name;

    @OneToMany(mappedBy = "region")
    private Set<Country> countries;

}

/*

    In order to make an entity eligible for second-level caching,
    we annotate it with Hibernate specific @org.hibernate.annotations.Cache annotation
    and specify a cache concurrency strategy.

    Some developers consider that it is a good convention
    to add the standard @javax.persistence.Cacheable annotation as well
    (although not required by Hibernate)

*/
