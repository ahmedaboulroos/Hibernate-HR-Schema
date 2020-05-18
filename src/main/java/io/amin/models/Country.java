package io.amin.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID", unique = true, nullable = false)
    private String id;

    @Column(name = "COUNTRY_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    Region region;

    @OneToMany(mappedBy = "country")
    private Set<Location> locations;

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", region.id=" + region.getId() +
                ", locations.size=" + locations.size() +
                '}';
    }

}
