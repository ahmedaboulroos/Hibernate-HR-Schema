package io.amin.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "LOCATION_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_generator")
    @SequenceGenerator(name = "locations_generator", sequenceName = "LOCATIONS_SEQ", initialValue = 0, allocationSize = 100)
    private Integer id;

    @Column(name = "STREET_ADDRESS")
    private String street;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String state;

    @OneToMany(mappedBy = "location")
    Set<Department> departments;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    Country country;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", departments.size=" + departments.size() +
                ", country.id=" + country.getId() +
                '}';
    }

}
